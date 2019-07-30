package com.aop.service;

public class UserServiceImpl implements IUserService{

    @Override
    public void addUser() {
        System.out.println("添加用户。。。。");
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户。。。。");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户。。。。");
    }

    @Override
    public int deleteUser(int id) {
        System.out.println("通过id删除用户");
        return 1;
    }
}
