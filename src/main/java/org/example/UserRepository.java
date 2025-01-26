package org.example;

import java.util.List;

public interface UserRepository {
    boolean addUser(User user);
    List<User> findUser(String email);
}
