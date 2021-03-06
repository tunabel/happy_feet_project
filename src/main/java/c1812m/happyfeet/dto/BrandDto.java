package c1812m.happyfeet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BrandDto {
    int id;
    List<ProductDto> productDtoList;
    String name;
    String desc;
    Date createDate;
}
