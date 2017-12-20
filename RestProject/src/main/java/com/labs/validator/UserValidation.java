package com.labs.validator;

import com.labs.com.labs.common.Messages;
import com.labs.repository.UserRepository;
import com.labs.model.User;
import com.labs.rest.exception.UnprocessedEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserValidation {

    @Autowired
    public UserRepository userRepository;

    public void validateUser(User user){

        Optional<User> userOp = userRepository.findByFirstname(user.getFirstname());
        Validator.of(userOp).validateIf(Optional::isPresent, () -> new UnprocessedEntityException(Messages.user_exists.getKey())).execute();
    }
}
