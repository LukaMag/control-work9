package controlwork9.demo.repositories;

import controlwork9.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findUserByEmail(String email);
}
