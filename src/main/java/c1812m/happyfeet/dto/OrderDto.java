package c1812m.happyfeet.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    private int id;
    private String guid;
    private String username;
    private String customerName;
    private String address;
    private String phone;
    private String email;
    private double price;
    private Date createDate;
    private int status;
}
