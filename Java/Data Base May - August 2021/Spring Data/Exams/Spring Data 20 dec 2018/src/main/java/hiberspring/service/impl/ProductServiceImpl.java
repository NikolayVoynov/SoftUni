package hiberspring.service.impl;

import hiberspring.domain.dtos.ProductSeedDto;
import hiberspring.domain.dtos.ProductSeedRootDto;
import hiberspring.domain.entities.Product;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String PRODUCTS_FILE_PATH = "src/main/resources/files/products.xml";

    private final ProductRepository productRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final BranchService branchService;


    public ProductServiceImpl(ProductRepository productRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser, BranchService branchService) {
        this.productRepository = productRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.branchService = branchService;
    }

    @Override
    public Boolean productsAreImported() {
        return productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(PRODUCTS_FILE_PATH));
    }

    @Override
    public String importProducts() throws JAXBException, IOException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .parseXml(ProductSeedRootDto.class, PRODUCTS_FILE_PATH)
                .getProducts()
                .stream()
                .filter(productSeedDto -> {
                    boolean isValid = validationUtil.isValid(productSeedDto)
                            && branchService.isEntityExists(productSeedDto.getBranch());

                    sb.append(isValid ? String.format("Successfully imported Product %s.", productSeedDto.getName()) :
                            "Error: Invalid data.")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setBranch(branchService.findBranchByGivenName(productSeedDto.getBranch()));

                    return product;
                })
                .forEach(productRepository::save);

        return sb.toString();
    }
}
