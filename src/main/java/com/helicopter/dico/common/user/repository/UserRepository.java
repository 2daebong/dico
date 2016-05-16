package com.helicopter.dico.common.user.repository;

import com.helicopter.dico.common.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 13..
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);
}
