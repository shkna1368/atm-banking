package com.shabab.bank.credit_card;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Shabab
 */
@Repository
public interface CreditCardRepository extends PagingAndSortingRepository<CreditCard, Long> {


    List<CreditCard> findAllByAccount_Id(Long accoundId);
    Optional<CreditCard> findByCardNumberAndPin(String cardNumber,String pin);
    Optional<CreditCard> findByCardNumber(String cardNumber);
    Optional<CreditCard> findByCardNumberAndFingerPrint(String cardNumber,String fingerPrint);




}
