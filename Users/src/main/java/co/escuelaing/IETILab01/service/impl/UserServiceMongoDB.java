package co.escuelaing.IETILab01.service.impl;

import co.escuelaing.IETILab01.data.User;
import co.escuelaing.IETILab01.dto.UserDTO;
import co.escuelaing.IETILab01.repository.UserRepository;
import co.escuelaing.IETILab01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceMongoDB implements IUserService {
    private final UserRepository userRepository;
    private final Map<String,User> usr = new ConcurrentHashMap<>();

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        User newUsr = usr.put(user.getId(),user);
        return newUsr;
    }

    @Override
    public User findById(String id) {
        if (usr.containsKey(id)){
            return usr.get(id);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for (String id : usr.keySet()){
            users.add(usr.get(id));
        }
        return users;
    }

    @Override
    public Boolean deleteById(String id) {
        usr.remove(id);
        return usr.containsKey(id);
    }

    @Override
    public User update(UserDTO userDto, String userId) {
        if (usr.containsKey(userId)){
            User user =usr.get(userDto);
            return user;
        }else {
            return null;
        }
    }
}
