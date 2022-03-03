package com.shabab.bank.credit_card;


import com.shabab.bank.account.AccountDTO;
import com.shabab.bank.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class CreditCardDTO extends BaseDTO {
    /**
     *
     * @author Shabab
     */

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private String cardNumber;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private String pin;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private String fingerPrint;


    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
      private AccountDTO account;


 @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
      private CreditCardStatus status;



}
