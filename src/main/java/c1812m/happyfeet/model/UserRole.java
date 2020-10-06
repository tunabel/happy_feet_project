package c1812m.happyfeet.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user_role")
@Entity
public class UserRole {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "user_role_id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "role_id")
    private int roleId;
}
