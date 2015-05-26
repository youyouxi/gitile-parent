package com.gitile.core.auth.cache;

import com.gitile.core.cache.CacheFactory;

/**
 * 简单的demo
 */
public class Test {

    public static void main(String args[]) throws InterruptedException {
        UserDao dao = CacheFactory.get(UserDao.class);
        User user = dao.getUser();
        System.out.println(user);
        User user2 = dao.getUser();
        System.out.println(user2);
        dao.deleteUser();
        User user3 = dao.getUser();
        System.out.println(user3);
    }
}
