package com.shabab.bank.transaction;


import com.shabab.bank.account.Account;
import com.shabab.bank.common.BaseEntity;
import com.shabab.bank.credit_card.CreditCard;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "T_TRANSACTION_HISTORY")
@Data
public class TransactionHistory extends BaseEntity {





     @NotNull
    @Column(name = "TRANSACTION_TYPE",nullable = false)
     @Enumerated(EnumType.STRING)
    private TransactionType transactionType ;

  @NotNull
    @Column(name = "TRANSACTION_SOURCE",nullable = false)
     @Enumerated(EnumType.STRING)
    private TransactionSource transactionSource ;



    @NotNull
    @Column(name = "AMOUNT")
    private BigDecimal amount;



        @ManyToOne
        @JoinColumn(name = "ACCOUNT_ID")
       private Account account;


        @ManyToOne
        @JoinColumn(name = "CREDIT_CARD_ID")
       private CreditCard creditCard;




}
