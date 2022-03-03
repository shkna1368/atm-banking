package com.shabab.atm.credit_card_client;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
/**
 *
 * @author Yash
 */
@RestController
@RequestMapping(value = "/atm-credit-card/")

public class CreditCardController {
  CreditCardClient creditCardClient;


    public CreditCardController(CreditCardClient creditCardClient) {
        this.creditCardClient = creditCardClient;
    }





    @ApiOperation(value = "login by finger print")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully login"),
            @ApiResponse(code = 404, message = " incorrect user"),
    })
    @GetMapping(value = "login-by-pin/{cardNumber}/{pin}")
    public ResponseEntity<String> loginByPin(@PathVariable(value = "cardNumber") String cardNumber,@PathVariable(value = "pin") String pin){

return  ResponseEntity.ok(creditCardClient.loginByPin(cardNumber,pin));


    }


    @ApiOperation(value = "login by finger print")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully login"),
            @ApiResponse(code = 404, message = " incorrect user"),
    })
    @GetMapping(value = "login-by-fingerprint/{cardNumber}/{fingerprint}")
    public ResponseEntity<String> loginByFingerPring(@PathVariable(value = "cardNumber") String cardNumber,@PathVariable(value = "fingerprint") String fingerprint){


      return  ResponseEntity.ok(creditCardClient.loginByFingerPring(cardNumber,fingerprint));

    }

    @ApiOperation(value = "Get Balance")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully get balance"),
            @ApiResponse(code = 404, message = " not found"),
    })
    @GetMapping(value = "get-balance-by-cardNumber/{cardNumber}")
    public ResponseEntity<String> getBalanceByCardNumber(@PathVariable(value = "cardNumber") String cardNumber){

      return  ResponseEntity.ok(creditCardClient.getBalanceByCardNumber(cardNumber));

    }
 @GetMapping(value = "get-balance-by-crediCardId/{creditCardId}")
    public ResponseEntity<String> getBalanceByCrediCardId(@PathVariable(value = "creditCardId") Long creditCardId){
      return  ResponseEntity.ok(creditCardClient.getBalanceByCrediCardId(creditCardId));

    }

     @ApiOperation(value = "")
     @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully get balance"),
            @ApiResponse(code = 404, message = " not found"),
    })
    @GetMapping(value = "withdrawal/{creditCardId}/{amount}")
    public ResponseEntity<String> withdrawal(@PathVariable(value = "creditCardId") Long creditCardId,@PathVariable(value = "amount") BigDecimal amount){
     return  ResponseEntity.ok(creditCardClient.withdrawal(creditCardId,amount));
    }

 @GetMapping(value = "deposit/{creditCardId}/{amount}")
    public ResponseEntity<String> deposit(@PathVariable(value = "creditCardId") Long creditCardId,@PathVariable(value = "amount") BigDecimal amount){

     return  ResponseEntity.ok(creditCardClient.deposit(creditCardId,amount));
    }






}
