package c1812m.happyfeet.controller;

import c1812m.happyfeet.commons.CustomUtils;
import c1812m.happyfeet.commons.mapper.BrandMapper;
import c1812m.happyfeet.dto.BrandDto;
import c1812m.happyfeet.model.Brand;
import c1812m.happyfeet.service.BrandService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    CustomUtils utils;

    @PostMapping(value = "/")
    public ResponseEntity<Map<String, Object>> create(@NotNull @RequestBody BrandDto dto) {

        Brand brand = brandService.save(dto);

        if (brand != null) {
            return utils.createResponse(brand, HttpStatus.CREATED);
        } else {
            return utils.createResponse(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/{brandId}")
    public ResponseEntity<Map<String, Object>> getById(@NotNull @PathVariable int brandId) {
        Brand brand = brandService.findById(brandId);

        if (brand != null) {
            return utils.createResponse(brand, HttpStatus.FOUND);
        } else {
            return utils.createResponse(brand, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<Map<String, Object>> getAll() {

        List<BrandDto> brandDtoList = brandService
                .findAll().stream().map(brand -> brandMapper.toDto(brand))
                .collect(Collectors.toList());

        return utils.createResponse(brandDtoList, HttpStatus.OK);
    }

    @PutMapping(value = "/{brandId}")
    public ResponseEntity<Map<String, Object>> update(@NotNull @RequestBody BrandDto dto, @PathVariable int brandId) {

        Brand updatedBrand = brandService.update(dto, brandId);

        if (updatedBrand != null) {
            return utils.createResponse(updatedBrand, HttpStatus.OK);
        } else {
            return utils.createResponse(updatedBrand, HttpStatus.BAD_REQUEST);
        }
    }
}
