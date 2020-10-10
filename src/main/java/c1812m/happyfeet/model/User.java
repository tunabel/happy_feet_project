package c1812m.happyfeet.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @Id
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private int gender;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String fullname;

    @Column(name = "create_date")
    private Date createDate;

    @Transient
    private String passwordRaw;

}
