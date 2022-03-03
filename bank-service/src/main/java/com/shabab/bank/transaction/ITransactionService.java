package com.shabab.bank.transaction;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ITransactionService {
     TransactionHistory save(TransactionHistory transactionHistory);


     TransactionHistory getById(Long id);
    List<TransactionHistory> getTop10ByCreditCardNumber(String creditCardNumber);
    List<TransactionHistory> getTop10ByCreditCareditCardId(Long creditCardId);
    List<TransactionHistory> getTransactionHistoryBetweenTwoDate(String creditCardNumber,Long from,Long to);

}
