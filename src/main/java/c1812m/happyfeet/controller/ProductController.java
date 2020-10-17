package c1812m.happyfeet.controller;

import c1812m.happyfeet.commons.mapper.ProductMapper;
import c1812m.happyfeet.commons.response.CustomUtils;
import c1812m.happyfeet.dto.ProductDto;
import c1812m.happyfeet.model.Product;
import c1812m.happyfeet.repository.ProductRepository;
import c1812m.happyfeet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CustomUtils utils;

    @Autowired
    ProductMapper productMapper;

    //ADMIN - create new product
    //ADMIN - update product


    //User - get all
    @GetMapping(value = "/")
    public ResponseEntity<Map<String, Object>> getAll() {

        List<Product> productList = productService.findAllActive();

        return utils.createResponse(productList, HttpStatus.OK);
    }

    //User - get one (details)
    @GetMapping(value = "/{productId}")
    public ResponseEntity<Map<String, Object>> getOne(@PathVariable int productId) {

        Product foundProduct = productService.findActiveById(productId);

        ProductDto result = productMapper.toDto(foundProduct);

        return utils.createResponse(result, HttpStatus.FOUND);
    }

    //User - get all with search and sort



}
