package c1812m.happyfeet.commons.mapper;

import c1812m.happyfeet.dto.BrandDto;
import c1812m.happyfeet.model.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandMapperClass {
    public BrandDto toDto(Brand brand) {
        if (brand == null) {
            return null;
        } else {
            BrandDto brandDto = new BrandDto();
            brandDto.setId(brand.getId());
            brandDto.setName(brand.getName());
            brandDto.setDesc(brand.getDesc());
            brandDto.setCreateDate(brand.getCreateDate());
            return brandDto;
        }
    }

    public Brand toEntity(BrandDto dto) {
        if (dto == null) {
            return null;
        } else {
            Brand brand = new Brand();
            brand.setId(dto.getId());
            brand.setName(dto.getName());
            brand.setDesc(dto.getDesc());
            brand.setCreateDate(dto.getCreateDate());

            return brand;
        }
    }
}
