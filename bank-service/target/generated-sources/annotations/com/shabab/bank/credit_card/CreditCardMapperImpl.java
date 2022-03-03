package com.shabab.bank.credit_card;

import com.shabab.bank.account.Account;
import com.shabab.bank.account.AccountDTO;
import com.shabab.bank.user.User;
import com.shabab.bank.user.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-03T19:02:19+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CreditCardMapperImpl implements CreditCardMapper {

    @Override
    public CreditCard toCredit(CreditCardDTO creditCardDTO) {
        if ( creditCardDTO == null ) {
            return null;
        }

        CreditCard creditCard = new CreditCard();

        creditCard.setId( creditCardDTO.getId() );
        creditCard.setVersion( creditCardDTO.getVersion() );
        creditCard.setCreatedDate( creditCardDTO.getCreatedDate() );
        creditCard.setCreatedBy( creditCardDTO.getCreatedBy() );
        creditCard.setLastModifiedDate( creditCardDTO.getLastModifiedDate() );
        creditCard.setLastModifiedBy( creditCardDTO.getLastModifiedBy() );
        creditCard.setCardNumber( creditCardDTO.getCardNumber() );
        creditCard.setPin( creditCardDTO.getPin() );
        creditCard.setFingerPrint( creditCardDTO.getFingerPrint() );
        creditCard.setStatus( creditCardDTO.getStatus() );
        creditCard.setAccount( accountDTOToAccount( creditCardDTO.getAccount() ) );

        return creditCard;
    }

    @Override
    public CreditCardDTO toCreditDTO(CreditCard creditCard) {
        if ( creditCard == null ) {
            return null;
        }

        CreditCardDTO creditCardDTO = new CreditCardDTO();

        creditCardDTO.setId( creditCard.getId() );
        creditCardDTO.setVersion( creditCard.getVersion() );
        creditCardDTO.setCreatedDate( creditCard.getCreatedDate() );
        creditCardDTO.setCreatedBy( creditCard.getCreatedBy() );
        creditCardDTO.setLastModifiedDate( creditCard.getLastModifiedDate() );
        creditCardDTO.setLastModifiedBy( creditCard.getLastModifiedBy() );
        creditCardDTO.setCardNumber( creditCard.getCardNumber() );
        creditCardDTO.setStatus( creditCard.getStatus() );

        return creditCardDTO;
    }

    @Override
    public List<CreditCardDTO> toCreditDTOs(List<CreditCard> creditCards) {
        if ( creditCards == null ) {
            return null;
        }

        List<CreditCardDTO> list = new ArrayList<CreditCardDTO>( creditCards.size() );
        for ( CreditCard creditCard : creditCards ) {
            list.add( toCreditDTO( creditCard ) );
        }

        return list;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setVersion( userDTO.getVersion() );
        user.setCreatedDate( userDTO.getCreatedDate() );
        user.setCreatedBy( userDTO.getCreatedBy() );
        user.setLastModifiedDate( userDTO.getLastModifiedDate() );
        user.setLastModifiedBy( userDTO.getLastModifiedBy() );
        user.setName( userDTO.getName() );
        user.setFamily( userDTO.getFamily() );
        user.setGender( userDTO.getGender() );
        user.setNationalCode( userDTO.getNationalCode() );
        user.setMobilePhone( userDTO.getMobilePhone() );

        return user;
    }

    protected Account accountDTOToAccount(AccountDTO accountDTO) {
        if ( accountDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountDTO.getId() );
        account.setVersion( accountDTO.getVersion() );
        account.setCreatedDate( accountDTO.getCreatedDate() );
        account.setCreatedBy( accountDTO.getCreatedBy() );
        account.setLastModifiedDate( accountDTO.getLastModifiedDate() );
        account.setLastModifiedBy( accountDTO.getLastModifiedBy() );
        account.setBalance( accountDTO.getBalance() );
        account.setAccountType( accountDTO.getAccountType() );
        account.setUser( userDTOToUser( accountDTO.getUser() ) );

        return account;
    }
}
