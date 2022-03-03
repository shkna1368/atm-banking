package com.shabab.bank.account;

import java.math.BigDecimal;
/**
 *
 * @author Shabab
 */
public interface IAccountService {
     Account save(Account account);

     BigDecimal getBalance(Long accountId);
     BigDecimal deposit(Long accountId,BigDecimal amount);
     BigDecimal withdrawal(Long accountId,BigDecimal amount);
     Account getById(Long id);
     Account getByUserId(Long userId );
     Long accountCount();


}
