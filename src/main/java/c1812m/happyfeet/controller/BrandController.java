package c1812m.happyfeet.controller;

import c1812m.happyfeet.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/brand")
public class BrandController {

    @Autowired
    BrandRepository brandRepository;

}
