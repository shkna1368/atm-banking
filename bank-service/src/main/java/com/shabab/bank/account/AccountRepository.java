package com.shabab.bank.account;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Shabab
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {


    Account findByUser_Id(Long userId);



}
