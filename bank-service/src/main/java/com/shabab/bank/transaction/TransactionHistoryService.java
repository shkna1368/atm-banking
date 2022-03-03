package com.shabab.bank.transaction;


import com.shabab.bank.account.Account;
import com.shabab.bank.credit_card.CreditCard;
import com.shabab.bank.credit_card.ICrediCardService;
import com.shabab.bank.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class TransactionHistoryService implements ITransactionService {

    ICrediCardService crediCardService;
    TransactionHistoryRepository repository;


    @Override
    public TransactionHistory save(TransactionHistory transactionHistory) {
        CreditCard creditCard = crediCardService.getById(transactionHistory.getCreditCard().getId());
        Account account = creditCard.getAccount();
        transactionHistory.setCreditCard(creditCard);
        transactionHistory.setAccount(account);


        return repository.save(transactionHistory);
    }

    @Override
    public TransactionHistory getById(Long id) {
        Optional<TransactionHistory> optionalTransactionHistory=repository.findById(id);
        if (!optionalTransactionHistory.isPresent()){
            throw new NotFoundException("This transaction history is not exist");
        }
        return optionalTransactionHistory.get();

    }

    @Override
    public List<TransactionHistory> getTop10ByCreditCardNumber(String creditCardNumber) {

        CreditCard creditCard=crediCardService.getByCardNumber(creditCardNumber);
        List<TransactionHistory> transactionHistories= repository.findAllByCreditCard(creditCard, PageRequest.of(0,10, Sort.by("id")));
   log.info("Successfully get last 10 transacrion history "+creditCardNumber);
   return transactionHistories;
    }

    @Override
    public List<TransactionHistory> getTop10ByCreditCareditCardId(Long creditCardId) {

        CreditCard creditCard=crediCardService.getById(creditCardId);
        List<TransactionHistory> transactionHistories= repository.findAllByCreditCard(creditCard, PageRequest.of(0,10, Sort.by("id")));
        log.info("Successfully get last 10 transacrion history "+creditCardId);

        return transactionHistories;
    }

    @Override
    public List<TransactionHistory> getTransactionHistoryBetweenTwoDate(String cardNumber,Long from, Long to) {
        CreditCard creditCard=crediCardService.getByCardNumber(cardNumber);




        return repository.findByCreditCardAndCreatedDateBetween(creditCard, new Date(from),new Date(to));
    }
}
