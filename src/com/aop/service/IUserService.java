package com.aop.service;


public interface IUserService {

    /** 切面编程 */
    public void addUser();
    public void updateUser();
    public void deleteUser();
    public int deleteUser(int id);
}
