package com.shabab.bank.transaction;

import com.shabab.bank.credit_card.CreditCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionHistoryRepository extends PagingAndSortingRepository<TransactionHistory, Long> {


    List<TransactionHistory> findByCreditCardAndCreatedDateBetween(CreditCard creditCard,Date from,Date to);
    List<TransactionHistory> findAllByCreditCard(CreditCard creditCard, Pageable pageable);





}
