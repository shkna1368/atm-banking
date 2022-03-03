package com.shabab.atm.transaction_history;

import com.shabab.atm.common.FeignConfig;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "transaction-history", url="http://localhost:8080/bservice/transaction-history/", configuration = FeignConfig.class, fallbackFactory = TransactionHistoryClient.HystrixClientFallbackFactory.class)

public interface TransactionHistoryClient {

    @GetMapping(value = "/get-last-ten-transactions/{creditCardId}")
    String getTop10ByCreditCareditCardId(@PathVariable(value = "creditCardId") Long creditCardId);



    @Component
    static class HystrixClientFallbackFactory implements FallbackFactory<TransactionHistoryClient> {


        @Override
        public TransactionHistoryClient create(Throwable cause) {
            return new TransactionHistoryClient() {
                @Override
                public String getTop10ByCreditCareditCardId(Long creditCardId) {
                    return "Not Available";
                }
            };
        }
    }

}

