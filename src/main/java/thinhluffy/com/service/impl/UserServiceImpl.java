package thinhluffy.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thinhluffy.com.model.User;
import thinhluffy.com.repository.UserRepository;
import thinhluffy.com.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public void remove(int id) {
        userRepository.delete(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
