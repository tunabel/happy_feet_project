package c1812m.happyfeet.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private int id;
    private String username;
    private String password;
    private String email;
    private int gender;
    private String phone;
    private String address;
    private String fullname;
    private Date createDate;
    int status;
    private String passwordRaw;
}
