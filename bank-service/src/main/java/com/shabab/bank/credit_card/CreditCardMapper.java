package com.shabab.bank.credit_card;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
/**
 *
 * @author Shabab
 */
@Mapper(componentModel = "spring")
public interface CreditCardMapper {
    CreditCard toCredit(CreditCardDTO creditCardDTO);

    @Mapping(target = "account",ignore = true)
    @Mapping(target = "pin",ignore = true)
    @Mapping(target = "fingerPrint",ignore = true)
    CreditCardDTO toCreditDTO(CreditCard creditCard);

    List<CreditCardDTO> toCreditDTOs(List<CreditCard> creditCards);

}
