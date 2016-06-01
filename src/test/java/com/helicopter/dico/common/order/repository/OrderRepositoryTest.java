package com.helicopter.dico.common.order.repository;

import com.helicopter.DicoApiApplication;
import com.helicopter.dico.common.order.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by LeeDaebeom-Mac on 2016. 6. 2..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DicoApiApplication.class)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void test_findoneWithJoin() {
        Order order = orderRepository.findOne(1l);
    }
}
