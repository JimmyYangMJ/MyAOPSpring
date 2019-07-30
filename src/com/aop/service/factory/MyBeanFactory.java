package com.aop.service.factory;

import com.aop.service.IUserService;
import com.aop.service.UserServiceImpl;
import com.aop.service.aspect.MyAspect2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
    /**
     * JDK实现代理
     * @return
     */
    public static IUserService createUserService(){
        //1.创建目标对象target
        final IUserService userService = new UserServiceImpl();

        //2.声明切面类对象
        final MyAspect2 aspect = new MyAspect2();

        //3.把切面类2个方法 应用 目标类
        //3.1 创建JDK代理,拦截方法
        /*newProxyInstance(
                ClassLoader loader, 类加载器，写当类
                Class<?>[] interfaces, 接口,接口的方法会被拦截
                InvocationHandler h) 处理
                */
        IUserService seriviceProxy = (IUserService) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /** 开启事务 */
                        //aspect.before();
                        aspect.before();

                        /** 方法返回值是 业务方法的返回值 */
                        Object retObj = method.invoke(userService, args);
                        //System.out.println("拦截返回值:" + retObj);

                        /** 提交事务 */
                        aspect.after();
                        return retObj;
                    }
                }
        );

        return seriviceProxy;
    }
}
