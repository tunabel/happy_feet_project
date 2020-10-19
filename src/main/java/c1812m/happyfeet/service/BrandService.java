package c1812m.happyfeet.service;

import c1812m.happyfeet.commons.exception.CustomBadRequestException;
import c1812m.happyfeet.commons.exception.CustomNotFoundException;
import c1812m.happyfeet.commons.exception.ItemDuplicationException;
import c1812m.happyfeet.commons.mapper.BrandMapper;
import c1812m.happyfeet.dto.BrandDto;
import c1812m.happyfeet.model.Brand;
import c1812m.happyfeet.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    BrandMapper brandMapper;

    public Brand findById(int id) {
        Optional<Brand> brandOptional = brandRepository.findById(id);

        return brandOptional.orElseThrow(() -> new CustomNotFoundException("Brand ID doesn't exist"));
    }

    public Brand save(BrandDto dto) {
        Brand brand = brandMapper.toEntity(dto);

        Brand foundBrand = brandRepository.findFirstByName(dto.getName());

        if (foundBrand != null) {
            throw new ItemDuplicationException("Brand Name already exists");
        } else {
            return brandRepository.save(brand);
        }
    }
    
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand update(BrandDto dto, int brandId) {

        if (dto.getId() != brandId) {
            throw new CustomBadRequestException("Brand ID mismatch");
        }

        Brand brand = findById(dto.getId());

        Brand foundBrand = brandRepository.findFirstByName(dto.getName());

        if (brand != null) {
            if (foundBrand != null && foundBrand.getId() != brand.getId()) {
                throw new ItemDuplicationException("Brand Name already exists");
            }

            return brandRepository.save(brand);
        } else {
            throw new CustomNotFoundException("Brand ID doesn't exist");
        }
    }
}
