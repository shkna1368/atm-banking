package com.shabab.bank.user;


import com.shabab.bank.exception.NotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 *
 * @author Shabab
 */


@Service
@AllArgsConstructor

public class UserService implements  IUserService{

    UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }


    /**

     * @param id the id of saved user
     * @return the saved user
     * @since 1.0
     */
    @Override
    public User getById(Long id ) {

        Optional<User> optionalUser=repository.findById(id);
        if (!optionalUser.isPresent()){
            throw new NotFoundException("This user id is not exist");
        }
        return optionalUser.get();
    }

    @Override
    public User getByNationalCode(String nationalCode) {
        Optional<User> optionalUser=repository.findByNationalCode(nationalCode);
        if (!optionalUser.isPresent()){
            throw new NotFoundException("This user with this national code is not exist");
        }
        return optionalUser.get();
    }

    @Override
    public User getByMobilePhone(String mobilePhone) {
        Optional<User> optionalUser=repository.findByMobilePhone(mobilePhone);
        if (!optionalUser.isPresent()){
            throw new NotFoundException("This user with this mobile phone  is not exist");
        }
        return optionalUser.get();
    }

    @Override
    public Long userCount() {
        return repository.count();
    }
}
