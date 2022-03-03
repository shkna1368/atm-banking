package com.shabab.bank.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Shabab
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {


    Optional<User> findByNationalCode(String nationalCode);
    Optional<User> findByMobilePhone(String mobilePhone);
    Page<User> findAll(Pageable pageable);

    List<User> findAll();

}
