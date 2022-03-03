package com.shabab.bank.account;

import com.shabab.bank.common.BaseDTO;
import com.shabab.bank.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 *
 * @author Shabab
 */
@Data
public class AccountDTO extends BaseDTO {

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private BigDecimal balance;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private AccountType accountType;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private UserDTO user;



}
