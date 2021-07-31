package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.BranchSeedDto;
import hiberspring.domain.entities.Branch;
import hiberspring.repository.BranchRepository;
import hiberspring.service.BranchService;
import hiberspring.service.TownService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service

public class BranchServiceImpl implements BranchService {

    private static final String BRANCHES_FILE_PATH = "src/main/resources/files/branches.json";

    private final BranchRepository branchRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownService townService;
    private final Gson gson;


    public BranchServiceImpl(BranchRepository branchRepository, ModelMapper modelMapper, ValidationUtil validationUtil,
                             TownService townService, Gson gson) {
        this.branchRepository = branchRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townService = townService;
        this.gson = gson;
    }

    @Override
    public Boolean branchesAreImported() {
        return branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Path.of(BRANCHES_FILE_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson
                        .fromJson(readBranchesJsonFile(), BranchSeedDto[].class))
                .filter(branchSeedDto -> {
                    boolean isValid = validationUtil.isValid(branchSeedDto)
                            && townService.isEntityExists(branchSeedDto.getTown());

                    sb.append(isValid ? String.format("Successfully imported Branch %s.", branchSeedDto.getName()) :
                                    "Error: Invalid data.")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(branchSeedDto -> {
                    Branch branch = modelMapper.map(branchSeedDto, Branch.class);
                    branch.setTown(townService.getTownByGivenName(branchSeedDto.getTown()));

                    return branch;
                })
                .forEach(branchRepository::save);

        return sb.toString();
    }

    @Override
    public boolean isEntityExists(String branchName) {
        return branchRepository.existsBranchByName(branchName);
    }

    @Override
    public Branch findBranchByGivenName(String name) {
        return branchRepository.getBranchByName(name).orElse(null);
    }
}
