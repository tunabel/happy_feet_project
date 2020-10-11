package c1812m.happyfeet.dto;

import c1812m.happyfeet.model.Product;
import lombok.Data;

@Data
public class SkuDto {
    private int id;
    private Product product;
    private int size;
    private int status;
}
