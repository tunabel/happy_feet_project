package c1812m.happyfeet.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDto {
    int id;
    BrandDto brandDTO;
    String name;
    String desc;
    double price;
    Date createDate;
    int status;
}
