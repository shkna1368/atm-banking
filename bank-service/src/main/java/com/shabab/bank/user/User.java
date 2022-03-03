package com.shabab.bank.user;

import com.shabab.bank.common.BaseEntity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "T_USERS")
@Data
public class User  extends BaseEntity {


    @NotNull
    @Column(name = "NAME")
    private String name;

    /**
     * The family of a user account
     */
    @NotNull
    @Column(name = "FAMILY")
    private String family;

    @NotNull
    @Column(name = "GENDER")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    /**
     * The national code of a user account
     */

    @NotNull
    @Column(name = "NATIONAL_CODE",unique = true)
    private String nationalCode;


    @NotNull
    @Column(name = "BIRTH_DATE")

    @Temporal(TemporalType.TIMESTAMP)
    private Date birhtDate;


    @NotNull
    @Column(name = "MOBILE_PHONE",unique = true)
    private String mobilePhone;




}
