package com.shabab.bank.user;



import com.shabab.bank.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class UserDTO extends BaseDTO {

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private String family;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private String nationalCode;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private Gender gender;


    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private Long birthDate;


    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private String mobilePhone;

}
