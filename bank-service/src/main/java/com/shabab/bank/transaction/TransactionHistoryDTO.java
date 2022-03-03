package com.shabab.bank.transaction;

import com.shabab.bank.common.BaseDTO;
import com.shabab.bank.credit_card.CreditCardDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class TransactionHistoryDTO extends BaseDTO {




    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private TransactionType transactionType ;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private TransactionSource transactionSource ;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private BigDecimal amount;


    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
       private CreditCardDTO creditCard;




}
