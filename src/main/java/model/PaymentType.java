package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "PaymentType")
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String paymentTypeCode;

    @Column(nullable = false)
    private String typeName;

    // @DuyTam: cho nay khong can thiet, vi 1 invoice co 1 PaymentType la dung
    // nhung chung ta chua can biet la 1 payment type co nhung invoice nao

    //@OneToMany(mappedBy = "paymentType")
    //private List<Invoice> invoices;


}
