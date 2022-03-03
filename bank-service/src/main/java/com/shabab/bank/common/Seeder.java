package com.shabab.bank.common;


import com.shabab.bank.account.Account;
import com.shabab.bank.account.AccountType;
import com.shabab.bank.account.IAccountService;
import com.shabab.bank.credit_card.CreditCard;
import com.shabab.bank.credit_card.CreditCardStatus;
import com.shabab.bank.credit_card.ICrediCardService;
import com.shabab.bank.transaction.ITransactionService;
import com.shabab.bank.user.Gender;
import com.shabab.bank.user.IUserService;
import com.shabab.bank.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@AllArgsConstructor
public class Seeder {

    IUserService userService;
    IAccountService accountService;
    ICrediCardService crediCardService;

    ITransactionService transactionService;

    public void seed(){

        /**
         * This is the seed method
         * which is very important for
         * seed data for a test program.
         */

        //make user
        System.out.println("----------User seed data started------------");

        User userArpine=new User();
        userArpine.setName("ARPINE");
        userArpine.setFamily("TUMANIAN");
        userArpine.setBirhtDate(new Date(1988,6,23));
        userArpine.setGender(Gender.FEMALE);
        userArpine.setMobilePhone("09125879669");
        userArpine.setNationalCode("3896225");

        User userShabab=new User();
        userShabab.setName("SHABAB");
        userShabab.setFamily("KOOHI");
        userShabab.setBirhtDate(new Date(1989,5,25));
        userShabab.setGender(Gender.MALE);
        userShabab.setMobilePhone("09148875059");
        userShabab.setNationalCode("2235565");
        User savedUserArpine=null;
        User savedUserShabab=null;

        if(userService.userCount()==0) {
            savedUserArpine = seedUser(userArpine);
            savedUserShabab = seedUser(userShabab);
            System.out.println("user saved count:" +userService.userCount());
            System.out.println("user1:"+savedUserArpine.toString());
            System.out.println("user2:"+savedUserShabab.toString().toString());
            System.out.println("----------User seed data finished------------");
        }



       //seed account
        System.out.println("----------Account seed data started------------");
        Account accountArpine=new Account();
        accountArpine.setUser(savedUserArpine);
        accountArpine.setAccountType(AccountType.SAVING_ACCOUNT);
        accountArpine.setBalance(new BigDecimal(2000));

         Account accountShabab=new Account();
        accountShabab.setUser(savedUserShabab);
        accountShabab.setAccountType(AccountType.SALARY_ACCOUNT);
        accountShabab.setBalance(new BigDecimal(2500));

        Account savedAccountArpine=null;
        Account savedAccountShabab=null;
        if(accountService.accountCount()==0){
         savedAccountArpine=accountService.save(accountArpine);
         savedAccountShabab=accountService.save(accountShabab);

            System.out.println("account saved count:" +accountService.accountCount());
            System.out.println("account1:"+savedAccountArpine.toString());
            System.out.println("account2:"+savedAccountShabab.toString());
            System.out.println("----------account seed data finished------------");
            System.out.println("----------test deposit withdrawal data start------------");
            System.out.println("arpine deposit:"+accountService.deposit(savedAccountArpine.getId(),new BigDecimal(200)));
            System.out.println("arpine withdrawal:"+accountService.withdrawal(savedAccountArpine.getId(),new BigDecimal(150)));
            System.out.println("----------Account test deposit withdrawal data finished------------");

        }




        System.out.println("----------CreditCard seed data started------------");

        CreditCard creditCardArpine=new CreditCard();
        creditCardArpine.setAccount(savedAccountArpine);
        creditCardArpine.setCardNumber("1111111111111111");
        creditCardArpine.setPin("1111");
        creditCardArpine.setFingerPrint("1111111111");
        creditCardArpine.setStatus(CreditCardStatus.ACTIVE);

         CreditCard creditCardShabab=new CreditCard();
        creditCardShabab.setAccount(savedAccountShabab);
        creditCardShabab.setCardNumber("2222222222222222");
        creditCardShabab.setPin("2222");
        creditCardShabab.setFingerPrint("2222222222");
        creditCardShabab.setStatus(CreditCardStatus.ACTIVE);


        CreditCard savedCrditCardArpine=null;
        CreditCard savedCrediCardShabab=null;

        if(crediCardService.creditCardCount()==0){
        savedCrditCardArpine=crediCardService.save(creditCardArpine);
         savedCrediCardShabab=crediCardService.save(creditCardShabab);
            System.out.println("credicard saved count:" +crediCardService.creditCardCount());
            System.out.println("credicard1:"+savedCrditCardArpine.toString());
            System.out.println("creditcard2:"+savedCrediCardShabab.toString());
            System.out.println("----------creditcard seed data finished------------");

            System.out.println("----------Creditcard  deposit withdrawal data start------------");
            System.out.println(" credit card arpine deposit:"+crediCardService.deposit(savedCrditCardArpine.getId(),new BigDecimal(2)));
            System.out.println("credit card arpine withdrawal:"+crediCardService.withdrawal(savedCrditCardArpine.getId(),new BigDecimal(1)));
            System.out.println("----------Creditcard test deposit withdrawal data finished------------");

            System.out.println("----------Transaction seed data test start------------");


            System.out.println("tranaction credit card arpine deposit:"+(transactionService.getTop10ByCreditCardNumber(savedCrditCardArpine.getCardNumber())).toString());



            System.out.println("----------Transaction seed data test finished------------");




        }




    }

    public User seedUser(User user){


        return userService.save(user);


    }

 public Account seedAccount(Account account){
        return accountService.save(account);


    }



}
