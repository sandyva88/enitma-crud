package com.enitma.CRUD.controllers;


import com.enitma.CRUD.models.DataBase.Product;
import com.enitma.CRUD.models.request.AddProductRequest;
import com.enitma.CRUD.models.response.AddProductResponse;
import com.enitma.CRUD.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping (value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @PostMapping (value = "/add")
    public ResponseEntity <Object> addProduct (@RequestBody AddProductRequest addProductRequest) {
        log.info("Add Product Request : {}", addProductRequest.toString());
        AddProductResponse res = productService.addProduct(addProductRequest);
        return ResponseEntity.ok(res);
    }

    @GetMapping (value = "/get/{id}")
    public ResponseEntity <Object> getProduct (@PathVariable("id") int id){
        log.info("Get Product ID : {}", id);
        Product product = productService.getProduct(id);
        if (product == null){
            return new ResponseEntity<>("No se encontro el producto", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity <Object> geta1LLProduct (){
        log.info("Get All Products" );
        List<Product> listProducts= productService.getAllProducts();
        if (listProducts.isEmpty()){
            return new ResponseEntity<>("No se encontro ningun producto", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(listProducts);
    }

    @DeleteMapping (value = "/delete/{id}")
    public ResponseEntity<Object>deleteProduct (@PathVariable("id") int id){
        log.info("Init request delete: ");
         productService.deleteProduct(id);
         log.info("Se elimino el producto");
         return ResponseEntity.ok("Se elimino el producto");
    }

    @PutMapping (value = "/put/{id}")
    public ResponseEntity<Object>putProduct (@PathVariable("id") int id, @RequestBody AddProductRequest addProductRequest) {
        log.info("Update product {} Request: {}", id, addProductRequest);
        return productService.putProduct(id, addProductRequest);
    }

}
