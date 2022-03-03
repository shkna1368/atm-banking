package com.shabab.bank.credit_card;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
/**
 *
 * @author Shabab
 */
@RestController
@RequestMapping(value = "/credit-card/")
@AllArgsConstructor
public class CreditCardController {
    ICrediCardService crediCardService;
CreditCardMapper creditCardMapper;



    @ApiOperation(value = "login by finger print")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully login"),
            @ApiResponse(code = 404, message = " incorrect user"),
    })
    @GetMapping(value = "login-by-pin/{cardNumber}/{pin}")
    public ResponseEntity<CreditCardDTO> loginByPin(@PathVariable(value = "cardNumber") String cardNumber,@PathVariable(value = "pin") String pin){
CreditCard creditCard=crediCardService.isValidByPin(cardNumber,pin);

return  ResponseEntity.ok(creditCardMapper.toCreditDTO(creditCard));


    }


    @ApiOperation(value = "login by finger print")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully login"),
            @ApiResponse(code = 404, message = " incorrect user"),
    })
    @GetMapping(value = "login-by-fingerprint/{cardNumber}/{fingerprint}")
    public ResponseEntity<CreditCardDTO> loginByFingerPring(@PathVariable(value = "cardNumber") String cardNumber,@PathVariable(value = "fingerprint") String fingerprint){
      CreditCard creditCard=crediCardService.isValidByfingerPring(cardNumber,fingerprint);

      return  ResponseEntity.ok(creditCardMapper.toCreditDTO(creditCard));

    }




    @ApiOperation(value = "Get Balance")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully get balance"),
            @ApiResponse(code = 404, message = " not found"),
    })
    @GetMapping(value = "get-balance-by-cardNumber/{cardNumber}")
    public ResponseEntity<BigDecimal> getBalanceByCardNumber(@PathVariable(value = "cardNumber") String cardNumber){
      BigDecimal balance=crediCardService.getBalanceByCardNumber(cardNumber);
      return  ResponseEntity.ok(balance);

    }

    @GetMapping(value = "get-balance-by-crediCardId/{creditCardId}")
    public ResponseEntity<BigDecimal> getBalanceByCrediCardId(@PathVariable(value = "creditCardId") Long creditCardId){
      BigDecimal balance=crediCardService.getBalanceByCardId(creditCardId);
      return  ResponseEntity.ok(balance);

    }

     @ApiOperation(value = "")
     @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully get balance"),
            @ApiResponse(code = 404, message = " not found"),
    })
    @GetMapping(value = "withdrawal/{creditCardId}/{amount}")
    public ResponseEntity<BigDecimal> withdrawal(@PathVariable(value = "creditCardId") Long creditCardId,@PathVariable(value = "amount") BigDecimal amount){
     BigDecimal balance=crediCardService.withdrawal(creditCardId,amount);
     return  ResponseEntity.ok(balance);
    }

 @GetMapping(value = "deposit/{creditCardId}/{amount}")
    public ResponseEntity<BigDecimal> deposit(@PathVariable(value = "creditCardId") Long creditCardId,@PathVariable(value = "amount") BigDecimal amount){
     BigDecimal balance=crediCardService.deposit(creditCardId,amount);
     return  ResponseEntity.ok(balance);
    }






}
