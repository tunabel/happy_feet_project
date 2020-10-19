package c1812m.happyfeet.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDto {
    int id;
    String name;
    String desc;
    double price;
    Date createDate;
    BrandDto brandDto;
    int status;
}
