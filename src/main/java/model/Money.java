package model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "money")
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng giá trị của id
    private Long id;
    @Column
    private String moneyCode; // Mã tiền tệ
    @Column
    private String moneyName; // Tên tiền tệ

}

