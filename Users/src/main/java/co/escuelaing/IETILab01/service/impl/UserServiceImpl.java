package co.escuelaing.IETILab01.service.impl;

import co.escuelaing.IETILab01.data.User;
import co.escuelaing.IETILab01.dto.UserDTO;
import co.escuelaing.IETILab01.service.IUserService;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements IUserService {
    private final Map<String,User> usr = new ConcurrentHashMap<>();

    @Override
    public User create(User user) {
        User newUsr = usr.put(user.getId(),user); 
        return newUsr;
    }

    @Override
    public User findById(String id) {
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
    public void deleteById(String id) {
        usr.remove(id);
        
    }


    @Override
    public User update(UserDTO userDto, String userId) {
        // TODO Auto-generated method stub
        return null;
    }

    

}