package c1812m.happyfeet.service;

import c1812m.happyfeet.commons.mapper.BrandMapper;
import c1812m.happyfeet.dto.BrandDto;
import c1812m.happyfeet.model.Brand;
import c1812m.happyfeet.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return brandOptional.orElse(null);
    }

    public Brand save(BrandDto dto) {
        Brand brand = brandMapper.toEntity(dto);

        Brand foundBrand = brandRepository.findFirstByName(dto.getName());

        if (foundBrand != null) {
            return null;
        } else {
            return brandRepository.save(brand);
        }
    }
    
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand update(BrandDto dto, int brandId) {

        if (dto.getId() != brandId) {
            return null;
        }

        Brand brand = findById(dto.getId());

        Brand foundBrand = brandRepository.findFirstByName(dto.getName());

        if (brand != null) {
            if (foundBrand != null && foundBrand.getId() != brand.getId()) {
                return null;
            }

            return brandRepository.save(brand);
        } else {
            return null;
        }
    }
}
