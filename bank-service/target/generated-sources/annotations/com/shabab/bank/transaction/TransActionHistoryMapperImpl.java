package com.shabab.bank.transaction;

import com.shabab.bank.account.Account;
import com.shabab.bank.account.AccountDTO;
import com.shabab.bank.credit_card.CreditCard;
import com.shabab.bank.credit_card.CreditCardDTO;
import com.shabab.bank.user.User;
import com.shabab.bank.user.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-04T01:35:24+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TransActionHistoryMapperImpl implements TransActionHistoryMapper {

    @Override
    public TransactionHistory toTransactionHistory(TransactionHistoryDTO transactionHistoryDTO) {
        if ( transactionHistoryDTO == null ) {
            return null;
        }

        TransactionHistory transactionHistory = new TransactionHistory();

        transactionHistory.setId( transactionHistoryDTO.getId() );
        transactionHistory.setVersion( transactionHistoryDTO.getVersion() );
        transactionHistory.setCreatedDate( transactionHistoryDTO.getCreatedDate() );
        transactionHistory.setCreatedBy( transactionHistoryDTO.getCreatedBy() );
        transactionHistory.setLastModifiedDate( transactionHistoryDTO.getLastModifiedDate() );
        transactionHistory.setLastModifiedBy( transactionHistoryDTO.getLastModifiedBy() );
        transactionHistory.setTransactionType( transactionHistoryDTO.getTransactionType() );
        transactionHistory.setTransactionSource( transactionHistoryDTO.getTransactionSource() );
        transactionHistory.setAmount( transactionHistoryDTO.getAmount() );
        transactionHistory.setCreditCard( creditCardDTOToCreditCard( transactionHistoryDTO.getCreditCard() ) );

        return transactionHistory;
    }

    @Override
    public TransactionHistoryDTO toTransactionHistoryDTO(TransactionHistory transactionHistory) {
        if ( transactionHistory == null ) {
            return null;
        }

        TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO();

        transactionHistoryDTO.setId( transactionHistory.getId() );
        transactionHistoryDTO.setVersion( transactionHistory.getVersion() );
        transactionHistoryDTO.setCreatedDate( transactionHistory.getCreatedDate() );
        transactionHistoryDTO.setCreatedBy( transactionHistory.getCreatedBy() );
        transactionHistoryDTO.setLastModifiedDate( transactionHistory.getLastModifiedDate() );
        transactionHistoryDTO.setLastModifiedBy( transactionHistory.getLastModifiedBy() );
        transactionHistoryDTO.setTransactionType( transactionHistory.getTransactionType() );
        transactionHistoryDTO.setTransactionSource( transactionHistory.getTransactionSource() );
        transactionHistoryDTO.setAmount( transactionHistory.getAmount() );

        return transactionHistoryDTO;
    }

    @Override
    public List<TransactionHistoryDTO> toTransactionHistoryDTOs(List<TransactionHistory> transactionHistories) {
        if ( transactionHistories == null ) {
            return null;
        }

        List<TransactionHistoryDTO> list = new ArrayList<TransactionHistoryDTO>( transactionHistories.size() );
        for ( TransactionHistory transactionHistory : transactionHistories ) {
            list.add( toTransactionHistoryDTO( transactionHistory ) );
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

    protected CreditCard creditCardDTOToCreditCard(CreditCardDTO creditCardDTO) {
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
}
