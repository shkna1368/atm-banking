package com.shabab.bank.account;

import com.shabab.bank.exception.BadRequestException;
import com.shabab.bank.exception.NotFoundException;
import com.shabab.bank.user.IUserService;
import com.shabab.bank.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;
/**
 *
 * @author Shabab
 */
@Slf4j
@Service
@AllArgsConstructor
public class AccountService implements  IAccountService{

    AccountRepository repository;
    IUserService userService;

    @Override
    public Account save(Account account) {
        User user=userService.getById(account.getUser().getId());
        account.setUser(user);
        return repository.save(account);
    }

    @Override
    public BigDecimal getBalance(Long accountId) {
        Account account = getById(accountId);
        return account.getBalance();
    }

    @Override
    @Transactional
    public BigDecimal deposit(Long accountId, BigDecimal amount) {

        Account account=getById(accountId);
        account.setBalance(account.getBalance().add(amount));
        Account updateAccount=  save(account);

        return updateAccount.getBalance();
    }

    @Override
    @Transactional
    public BigDecimal withdrawal(Long accountId, BigDecimal amount) {

        Account account=getById(accountId);

        if (account.getBalance().compareTo(amount)== -1){
            log.warn(accountId+ " has insufficient balance "+amount);

            throw new BadRequestException("Insufficient balance");
        }
      account.setBalance(  account.getBalance().subtract(amount));

        Account updateAccount=  save(account);
        return updateAccount.getBalance();
    }

    @Override
    public Account getById(Long id) {

        Optional<Account> optionalAccount=repository.findById(id);
        if (!optionalAccount.isPresent()){
            throw new NotFoundException("This account is not exist");
        }
        return optionalAccount.get();

    }

    @Override
    public Account getByUserId(Long userId) {
        userService.getById(userId);
        return repository.findByUser_Id(userId);
    }

    @Override
    public Long accountCount() {
        return repository.count();
    }
}
