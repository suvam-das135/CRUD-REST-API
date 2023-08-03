package com.api.service;

import com.api.Exception.HnDBankException;
//import com.api.dto.CustomerDTO;
import com.api.dto.ProductDTO;
//import com.api.entity.Customer;
import com.api.entity.Product;
import com.api.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRespository;

    @Override
    public int addProduct(ProductDTO productDto) throws HnDBankException {
        Optional<Product> optional = productRespository.findById(productDto.getProductId());
        if (optional.isPresent())
            throw new HnDBankException("Service.PRODUCT_FOUND");
        Product product = new Product();
        product.setExpirydate(productDto.getExpirydate());
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setProductDesp(productDto.getProductDesp());
        Product p = productRespository.save(product);
        return p.getProductId();
    }
    @Override
    public ProductDTO getProduct(Integer ProductId) throws HnDBankException {
        Optional<Product> optional = productRespository.findById(ProductId);
        Product product = optional.orElseThrow(() -> new HnDBankException("Service.PRODUCT_NOT_FOUND"));
//        Customer customer = new Customer();
        ProductDTO productDto = new ProductDTO();
        productDto.setProductId(product.getProductId());
        productDto.setExpirydate(product.getExpirydate());
        productDto.setProductDesp(product.getProductDesp());
        productDto.setProductName(product.getProductName());
        return productDto;
    }
    @Override
    public List<ProductDTO> findAll() throws HnDBankException {
        Iterable<Product> products = productRespository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        products.forEach(product -> {
            ProductDTO productDto = new ProductDTO();
            productDto.setProductId(product.getProductId());
            productDto.setExpirydate(product.getExpirydate());
            productDto.setProductDesp(product.getProductDesp());
            productDto.setProductName(product.getProductName());
            productDTOs.add(productDto);
        });
        if (productDTOs.isEmpty())
            throw new HnDBankException("Service.CUSTOMERS_NOT_FOUND");
        return productDTOs;
    }

    @Override
    public void updateProduct(Integer ProductId, ProductDTO productDTO) throws HnDBankException {
        Optional<Product> optional = productRespository.findById(ProductId);
        Product product = optional.orElseThrow(() -> new HnDBankException("Service.PRODUCT_NOT_FOUND"));
        product.setProductDesp(productDTO.getProductDesp());
        product.setProductName(productDTO.getProductName());
    }

    @Override
    public void deleteProduct(Integer ProductId) throws HnDBankException {
        Optional<Product> optional = productRespository.findById(ProductId);
        optional.orElseThrow(() -> new HnDBankException("Service.PRODUCT_NOT_FOUND"));
        productRespository.deleteById(ProductId);
    }

//    @Override
//    public void findBy(String emailId, int custId) throws HnDBankException {
//        List<Customer> custlist = customerRespository.findByEmailId(emailId);
//        System.out.println(custlist);
//        List<String> name = customerRespository.findNameByEmailId(emailId);
//        System.out.println(name);
//
//        customerRespository.updateCustomerEmailId("h1234@gmail.com", custId);
//
////        optional.orElseThrow(() -> new HnDBankException("Service.CUSTOMER_NOT_FOUND"));
//
//    }

}
