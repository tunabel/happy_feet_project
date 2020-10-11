package c1812m.happyfeet.controller;

import c1812m.happyfeet.commons.response.CustomUtils;
import c1812m.happyfeet.model.Product;
import c1812m.happyfeet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomUtils utils;

    //ADMIN - create new product
    //ADMIN - update product

    @GetMapping(value = "/")
    public ResponseEntity<Map<String, Object>> getAll() {

        List<Product> productList = productRepository.findAllByStatus(1);

        return utils.createResponse(productList, HttpStatus.OK);
    }


}
