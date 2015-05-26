package com.gitile.core.auth.cache;

import java.util.ArrayList;
import java.util.List;
import com.gitile.core.cache.annotation.ClearCache;
import com.gitile.core.cache.annotation.UseCache;

public class UserDao {

    @UseCache(cacheName = "user")
    public User getUser() {
        return new User("hello");
    }

    @ClearCache(cacheName = "users")
    public List<User> getUsers() {
        return new ArrayList<User>();
    }

    @ClearCache(cacheName = {"user","users"})
    public void deleteUser() {
    	
    }
}
