package com.shabab.atm.transaction_history;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 *
 * @author Yash
 */


@RestController
@RequestMapping(value = "/atm-transaction-history/")

public class TransActionHistoryController {
    TransactionHistoryClient transactionHistoryClient;

    public TransActionHistoryController(TransactionHistoryClient transactionHistoryClient) {
        this.transactionHistoryClient = transactionHistoryClient;
    }

    @GetMapping(value = "/get-last-ten-transactions/{creditCardId}")
    public ResponseEntity<String> getBalanceByCrediCardId(@PathVariable(value = "creditCardId") Long creditCardId){

      return  ResponseEntity.ok(transactionHistoryClient.getTop10ByCreditCareditCardId(creditCardId));

    }






}
