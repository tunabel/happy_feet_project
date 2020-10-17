package c1812m.happyfeet.controller;

import c1812m.happyfeet.commons.mapper.BrandMapper;
import c1812m.happyfeet.commons.response.CustomUtils;
import c1812m.happyfeet.commons.swagger.SwaggerConfig;
import c1812m.happyfeet.dto.BrandDto;
import c1812m.happyfeet.model.Brand;
import c1812m.happyfeet.service.BrandService;
import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/brand")
@Api(value = "happyfeet", tags = {SwaggerConfig.brandTag})
public class BrandController {

    @Autowired
    BrandService brandService;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    CustomUtils utils;

    @PostMapping(value = "/")
    public ResponseEntity create(@NotNull @RequestBody BrandDto dto) {

        Brand brand = brandService.save(dto);

        return new ResponseEntity(brand, HttpStatus.OK);
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

    @ApiOperation(value = "View a list of available brands", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/")
    public ResponseEntity<Map<String, Object>> getAll() {
        List<Brand> brandList = brandService.findAll();

        List<BrandDto> brandDtoList = brandList.stream()
                .map(brand -> brandMapper.toDto(brand))
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
