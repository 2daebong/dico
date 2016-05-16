package com.helicopter.dico.common.user.service;

import com.helicopter.dico.common.user.entity.User;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 13..
 */
public interface UserService {
    User getUser(String userId);
    User addUser(User user);

    List<User> getUserList();
}
