package com.helicopter.dico.common.user.service;

import com.helicopter.dico.common.user.entity.User;
import com.helicopter.dico.common.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 13..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String userId) {
        //TODO : validation
        User user = userRepository.findByUserId(userId);

        return user;
    }

    @Override
    public User addUser(User user) {
        //TODO : validation

        user.setRegistYmdt(new Date());

        return userRepository.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
