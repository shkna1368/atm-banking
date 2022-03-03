package com.shabab.bank.account;


import com.shabab.bank.common.BaseEntity;
import com.shabab.bank.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "T_ACCOUNTS")
@Data
public class Account extends BaseEntity {

    @NotNull
    @Column(name = "BALANCE")
    private BigDecimal balance;



    @NotNull
    @Column(name = "ACCOUNT_TYPE")
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;


        @ManyToOne
        @JoinColumn(name = "USER_ID")
       private User user;



}
