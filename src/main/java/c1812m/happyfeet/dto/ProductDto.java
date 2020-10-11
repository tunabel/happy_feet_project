package c1812m.happyfeet.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDto {
    int id;
    BrandDto brandDTO;
    String name;
    String desc;
    double price;
    Date createDate;
    int status;
}
