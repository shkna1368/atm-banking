package com.shabab.bank.user;
/**
 *
 * @author Shabab
 */
public interface IUserService {

     User save(User user);
     User getById(Long userId);
     User getByNationalCode(String nationalCode);
     User getByMobilePhone(String user);
     Long userCount();


}
