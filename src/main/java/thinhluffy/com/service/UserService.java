package thinhluffy.com.service;

import thinhluffy.com.model.User;

public interface UserService {
    Iterable<User> findAll();

    User findById(int id);

    void remove(int id);

    void save(User user);
}
