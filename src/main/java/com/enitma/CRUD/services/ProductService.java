package com.enitma.CRUD.services;

import com.enITma.CRUD.models.DataBase.Product;
import com.enITma.CRUD.models.request.AddProductRequest;
import com.enITma.CRUD.models.response.AddProductResponse;
import com.enITma.CRUD.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public AddProductResponse addProduct (AddProductRequest addProductRequest){
        Product product = new Product();
        product.setName(addProductRequest.getName());
        product.setPrice(addProductRequest.getPrice());
        product.setCreationDate(new Date());
        product = productRepository.save(product);

        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setIdProduct(product.getIdProduct());
        addProductResponse.setName(product.getName());
        addProductResponse.setPrice(product.getPrice());
        addProductResponse.setCreationDate(product.getCreationDate());
        return addProductResponse;
    }

    public Product getProduct (int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts () {
        return productRepository.findAll();
    }

    public void deleteProduct (int id) {
        productRepository.deleteById(id);
    }

    public ResponseEntity<Object> putProduct (int id, AddProductRequest addProductRequest){
        Product product= productRepository.findById(id).orElse(null);
        if (product != null){
            product.setName(addProductRequest.getName());
            product.setPrice(addProductRequest.getPrice());
            product = productRepository.save(product);
            return ResponseEntity.ok(product);
        }

        return new ResponseEntity<>("No se encontro el producto", HttpStatus.NOT_FOUND);
    }

}
