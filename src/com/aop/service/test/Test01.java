package com.aop.service.test;

import com.aop.service.IUserService;
import com.aop.service.factory.MyBeanFactory;
import org.junit.Test;

public class Test01 {

    @Test
    public void test04(){

        //自己实现AOP编程，使用JDK代理来实现

        IUserService userService = MyBeanFactory.createUserService();

        userService.deleteUser(10);
        userService.addUser();
        userService.updateUser();
    }
}
