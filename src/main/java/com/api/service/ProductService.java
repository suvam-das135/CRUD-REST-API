package com.api.service;

import com.api.Exception.HnDBankException;
import com.api.dto.ProductDTO;

import java.util.List;
public interface ProductService {
    public int addProduct(ProductDTO product) throws HnDBankException;
    public ProductDTO getProduct(Integer ProductId) throws HnDBankException;
    public List<ProductDTO> findAll() throws HnDBankException;
    public void updateProduct(Integer ProductId, ProductDTO productDTO) throws HnDBankException;
    public void deleteProduct(Integer ProductId)throws HnDBankException;
}
