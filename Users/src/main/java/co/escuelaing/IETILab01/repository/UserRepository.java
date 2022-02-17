package co.escuelaing.IETILab01.repository;

import co.escuelaing.IETILab01.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String e);
}