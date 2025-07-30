package com.enitma.CRUD.repository;

import com.enITma.CRUD.models.DataBase.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Integer> {

}
