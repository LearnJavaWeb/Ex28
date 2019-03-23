package thinhluffy.com.repository;

import org.springframework.data.repository.CrudRepository;
import thinhluffy.com.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
