package com.shabab.bank.credit_card;

import com.shabab.bank.account.Account;
import com.shabab.bank.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
/**
 *
 * @author Shabab
 */
@Entity
@Table(name = "T_CREDIT_CARD")
@Data
public class CreditCard extends BaseEntity {

    @NotNull
    @Column(name = "CARD_NUMBER",length = 16)
    private String cardNumber;

    @NotNull
    @Column(name = "PIN",length = 4)
    private String pin;

     @NotNull
    @Column(name = "FINGER_PRINT",unique = true,nullable = false)
    private String fingerPrint;



     @NotNull
    @Column(name = "STATUS",nullable = false)
     @Enumerated(EnumType.STRING)
    private CreditCardStatus status ;


        @ManyToOne
        @JoinColumn(name = "ACCOUNT_ID")
       private Account account;



}
