package com.shabab.bank.credit_card;


import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author Shabab
 */
public interface ICrediCardService {
     CreditCard save(CreditCard creditCard);
     CreditCard isValidByPin(String cardNumber ,String pin);
     CreditCard isValidByfingerPring(String cardNumber ,String fingerPrint);
     CreditCard getByCardNumber(String cardNumber);

    BigDecimal getBalanceByCardId(Long cardId);

    BigDecimal getBalanceByCardNumber(String cardNumber);

     BigDecimal deposit(Long creditCardId, BigDecimal amount);
     BigDecimal withdrawal(Long creditCard, BigDecimal amount);
     CreditCard getById(Long id);
    List<CreditCard> getByAccountId(Long accountId);
     Long creditCardCount();


}
