package c1812m.happyfeet.commons.mapper;

import c1812m.happyfeet.dto.ProductDto;
import c1812m.happyfeet.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperClass {
    public ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        } else {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setDesc(product.getDesc());
            productDto.setPrice(product.getPrice());
            productDto.setCreateDate(product.getCreateDate());
            productDto.setStatus(product.getStatus());
            return productDto;
        }
    }

    public Product toEntity(ProductDto dto) {
        if (dto == null) {
            return null;
        } else {
            Product product = new Product();
            product.setId(dto.getId());
            product.setName(dto.getName());
            product.setDesc(dto.getDesc());
            product.setPrice(dto.getPrice());
            product.setCreateDate(dto.getCreateDate());
            product.setStatus(dto.getStatus());
            return product;
        }
    }
}
