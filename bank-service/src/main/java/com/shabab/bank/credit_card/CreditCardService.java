package com.shabab.bank.credit_card;

import com.shabab.bank.account.Account;
import com.shabab.bank.account.IAccountService;
import com.shabab.bank.exception.NotFoundException;
import com.shabab.bank.transaction.ITransactionService;
import com.shabab.bank.transaction.TransactionHistory;
import com.shabab.bank.transaction.TransactionSource;
import com.shabab.bank.transaction.TransactionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Shabab
 */

@Slf4j
@Service
public class CreditCardService implements  ICrediCardService{

    CreditCardRepository repository;
    IAccountService accountService;


    ITransactionService transactionService;

    public CreditCardService(CreditCardRepository repository, IAccountService accountService,  @Lazy ITransactionService transactionService) {
        this.repository = repository;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @Override
    public CreditCard save(CreditCard creditCard) {
        Account account=accountService.getById(creditCard.getAccount().getId());
        creditCard.setAccount(account);
        return repository.save(creditCard);
    }

    @Override
    public CreditCard isValidByPin(String cardNumber, String pin) {
        Optional<CreditCard> optionalCreditCard=repository.findByCardNumberAndPin(cardNumber,pin);
        if (!optionalCreditCard.isPresent()){
            log.warn(cardNumber +"with pin "+pin+" is incorrect");
            throw new NotFoundException("Pin is incorrect");
        }
        log.info(cardNumber +"with pin "+pin+" successfully login");

        return optionalCreditCard.get();



    }

    @Override
    public CreditCard isValidByfingerPring(String  cardNumber, String fingerPrint) {
        Optional<CreditCard> optionalCreditCard=repository.findByCardNumberAndFingerPrint(cardNumber,fingerPrint);
        if (!optionalCreditCard.isPresent()){
            throw new NotFoundException("Pin is incorrect");
        }
        return optionalCreditCard.get();
    }

    @Override
    public CreditCard getByCardNumber(String cardNumber) {
        Optional<CreditCard> optionalCreditCard=repository.findByCardNumber(cardNumber);
        if (!optionalCreditCard.isPresent()){
            throw new NotFoundException("This credit card number  not exist");
        }
        return optionalCreditCard.get();
    }

 @Override
    public BigDecimal getBalanceByCardId(Long cardId) {
     CreditCard creditCard= getById(cardId);
     return creditCard.getAccount().getBalance();
    }

    @Override
    public BigDecimal getBalanceByCardNumber(String cardNumber) {
       CreditCard creditCard= getByCardNumber(cardNumber);
        return creditCard.getAccount().getBalance();
    }

    @Override
    @Transactional
    public BigDecimal deposit(Long creditCardId, BigDecimal amount) {

        CreditCard creditCard=getById(creditCardId);

      Long accountId=  creditCard.getAccount().getId();

   BigDecimal balance=   accountService.deposit(accountId,amount);


      saveTransAction(TransactionType.DEPOSIT, TransactionSource.CREDIT_CARD,amount,creditCard);

log.info(creditCard.getCardNumber()+ " successfully deposit "+amount);

        return balance;
    }

    @Override
    @Transactional
    public BigDecimal withdrawal(Long creditCardId, BigDecimal amount) {

        CreditCard creditCard=getById(creditCardId);

        Long accountId=  creditCard.getAccount().getId();

        BigDecimal balance=   accountService.withdrawal(accountId,amount);
        saveTransAction(TransactionType.WITHDRAWAL,TransactionSource.CREDIT_CARD,amount,creditCard);
        log.info(creditCard.getCardNumber()+ " successfully deposit "+amount);

        return balance;
    }

    @Override
    public CreditCard getById(Long id) {

        Optional<CreditCard> optionalCreditCard=repository.findById(id);
        if (!optionalCreditCard.isPresent()){
            throw new NotFoundException("This credit card is not exist");
        }
        return optionalCreditCard.get();

    }

    @Override
    public List<CreditCard> getByAccountId(Long accountId) {
        accountService.getById(accountId);
        return repository.findAllByAccount_Id(accountId);
    }

    @Override
    public Long creditCardCount() {
        return repository.count();
    }


    private void saveTransAction(TransactionType transactionType, TransactionSource source, BigDecimal amount, CreditCard creditCard){


        TransactionHistory transactionHistory=new TransactionHistory();
        transactionHistory.setTransactionType(transactionType);
        transactionHistory.setAccount(creditCard.getAccount());
        transactionHistory.setAmount(amount);
        transactionHistory.setCreditCard(creditCard);
        transactionHistory.setTransactionSource(source);
        transactionService.save(transactionHistory);

    }
}
