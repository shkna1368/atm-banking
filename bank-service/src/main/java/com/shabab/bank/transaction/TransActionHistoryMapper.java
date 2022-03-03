package com.shabab.bank.transaction;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransActionHistoryMapper {
    TransactionHistory toTransactionHistory(TransactionHistoryDTO transactionHistoryDTO);

  //  @Named("mapWithoutCreditCard")
    @Mapping(target = "creditCard",ignore = true)
    TransactionHistoryDTO toTransactionHistoryDTO(TransactionHistory transactionHistory);


   // @IterableMapping(qualifiedByName = "mapWithoutCreditCard")
    List<TransactionHistoryDTO> toTransactionHistoryDTOs(List<TransactionHistory> transactionHistories);

}
