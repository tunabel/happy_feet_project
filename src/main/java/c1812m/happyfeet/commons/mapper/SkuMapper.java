package c1812m.happyfeet.commons.mapper;

import c1812m.happyfeet.dto.SkuDto;
import c1812m.happyfeet.model.Sku;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkuMapper {
    SkuDto toDto(Sku entity);
    Sku toEntity(SkuDto dto);
}
