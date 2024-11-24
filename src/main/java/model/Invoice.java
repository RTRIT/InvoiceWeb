package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceNo;

    @Column(nullable = false)
    private LocalDate invoiceDate;

    @Column(nullable = false)
    private Integer sequenceNo;

    @Column(nullable = false)
    private Double netTotal ;

    @Column(nullable = false)
    private Double vatTotal ;

    @Column(nullable = false)
    private Double grossTotal ;

    @Column
    private String buyerNoteOnInvoice;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Double paid;

    @ManyToOne
    @JoinColumn(name = "vendorid", referencedColumnName = "vendorid")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "paymentType", referencedColumnName = "id")
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "paymentTime", referencedColumnName = "id")
    private PaymentTime paymentTime;

    @ManyToOne
    @JoinColumn(name = "moneyId", referencedColumnName = "id")
    private Money money;
}
