package c1812m.happyfeet.commons.mapper;

import c1812m.happyfeet.dto.BrandDto;
import c1812m.happyfeet.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDto toDto(Brand brand);

    Brand toEntity(BrandDto dto);
}
