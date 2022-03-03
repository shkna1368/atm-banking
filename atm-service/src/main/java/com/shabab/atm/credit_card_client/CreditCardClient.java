package com.shabab.atm.credit_card_client;

import com.shabab.atm.common.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
@FeignClient(name = "credit-card", url="http://localhost:8080/bservice/credit-card", configuration = FeignConfig.class)

public interface CreditCardClient {


    /**

     * @param cardNumber the card number of credit card
     * @param pin the  pin of credit card
     * @return the credit card
     * @since 1.0
     */
    @GetMapping(value = "/login-by-pin/{cardNumber}/{pin}")
    String loginByPin(@PathVariable(value = "cardNumber") String cardNumber, @PathVariable(value = "pin") String pin);


    @GetMapping(value = "/login-by-fingerprint/{cardNumber}/{fingerprint}")
    String loginByFingerPring(@PathVariable(value = "cardNumber") String cardNumber,@PathVariable(value = "fingerprint") String fingerprint);

    @GetMapping(value = "/get-balance-by-cardNumber/{cardNumber}")
   String getBalanceByCardNumber(@PathVariable(value = "cardNumber") String cardNumber);

    @GetMapping(value = "/get-balance-by-crediCardId/{creditCardId}")
    String getBalanceByCrediCardId(@PathVariable(value = "creditCardId") Long creditCardId);

    @GetMapping(value = "/withdrawal/{creditCardId}/{amount}")
   String withdrawal(@PathVariable(value = "creditCardId") Long creditCardId,@PathVariable(value = "amount") BigDecimal amount);

    /**
     * @param creditCardId the id of credit card
     * @param amount the  amount of deposit
     * @return the credit card
     * @since 1.0
     */
    @GetMapping(value = "/deposit/{creditCardId}/{amount}")
    String deposit(@PathVariable(value = "creditCardId") Long creditCardId,@PathVariable(value = "amount") BigDecimal amount);


}
