package hiberspring.service.impl;

import hiberspring.domain.dtos.EmployeeSeedRootDto;
import hiberspring.domain.entities.Employee;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeCardService;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final String EMPLOYEES_FILE_PATH = "src/main/resources/files/employees.xml";

    private final EmployeeRepository employeeRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser, BranchService branchService, EmployeeCardService employeeCardService) {
        this.employeeRepository = employeeRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
    }

    @Override
    public Boolean employeesAreImported() {
        return employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEES_FILE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .parseXml(EmployeeSeedRootDto.class, EMPLOYEES_FILE_PATH)
                .getEmployees()
                .stream()
                .filter(employeeSeedDto -> {
                    boolean isValid = validationUtil.isValid(employeeSeedDto)
                            && branchService.isEntityExists(employeeSeedDto.getBranch())
                            && employeeCardService.isEntityExists(employeeSeedDto.getCard());

                    sb.append(isValid ? String.format("Successfully imported Employee %s %s.",
                                    employeeSeedDto.getFirstName(), employeeSeedDto.getLastName()) :
                                    "Error: Invalid data.")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(employeeSeedDto -> {
                    Employee employee = modelMapper.map(employeeSeedDto, Employee.class);

                    employee.setCard(employeeCardService.getCardByGivenNumber(employeeSeedDto.getCard()));
                    employee.setBranch(branchService.findBranchByGivenName(employeeSeedDto.getBranch()));

                    return employee;
                })
                .forEach(employeeRepository::save);

        return sb.toString();
    }

    @Override
    public String exportProductiveEmployees() {
        StringBuilder sb = new StringBuilder();

//        Map<Long, Employee> employeesMap = new HashMap<>();
//
//        employeeRepository
//                .findEmployeeInBranchWithAtLeastOneProduct()
//                        .forEach(employee -> {
//                            employeesMap.put(employee.getId(), employee);
//                        });
//
//        employeesMap.entrySet().stream().sorted();

        employeeRepository
                .findEmployeeInBranchWithAtLeastOneProduct()
                .forEach(employee -> {
                    sb.append(String.format("Name: %s", employee[0]))
                            .append(System.lineSeparator())
                            .append(String.format("Position: %s", employee[1]))
                            .append(System.lineSeparator())
                            .append(String.format("Card Number: %s", employee[2]))
                            .append(System.lineSeparator())
                            .append("-------------------------")
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
