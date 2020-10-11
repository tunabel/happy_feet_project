package c1812m.happyfeet.commons.mapper;

import c1812m.happyfeet.dto.ProductDto;
import c1812m.happyfeet.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product entity);
    Product toEntity(ProductDto dto);

}
