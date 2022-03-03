package com.shabab.bank.transaction;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction-history/")

@AllArgsConstructor
public class TransActionHistoryController {
    ITransactionService transactionService;
TransActionHistoryMapper transActionHistoryMapper;




 @GetMapping(value = "/get-last-ten-transactions/{creditCardId}")
    public ResponseEntity<List<TransactionHistoryDTO>> getBalanceByCrediCardId(@PathVariable(value = "creditCardId") Long creditCardId){
      List<TransactionHistory> transactionHistories=transactionService.getTop10ByCreditCareditCardId(creditCardId);


      return  ResponseEntity.ok(transActionHistoryMapper.toTransactionHistoryDTOs(transactionHistories));

    }






}
