package co.escuelaing.IETILab01.service.impl;

import co.escuelaing.IETILab01.data.User;
import co.escuelaing.IETILab01.dto.UserDTO;
import co.escuelaing.IETILab01.repository.UserRepository;
import co.escuelaing.IETILab01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements IUserService {
    private final UserRepository userRepository;


    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        User newUsr = userRepository.save(user);
        return newUsr;
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
       return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean deleteById(String id) {
        userRepository.deleteById(id);
        if (userRepository.findById(id) == null){return true;}
        return false;
    }

    @Override
    public User update(UserDTO userDto, String userId) {
        User u = findById(userId);
        u.update(userDto);
        return userRepository.save(u);
        if (userDto.getPassword() != null) {
            passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());}
        else {
            return null;
        }
    }
}
