package co.escuelaing.IETILab01.service;

import java.util.List;

import co.escuelaing.IETILab01.data.User;
import co.escuelaing.IETILab01.dto.UserDTO;

public interface IUserService{
    
    User create( User user );
    User findById( String id );
    User findByEmail (String email);
    List<User> getAll();
    Boolean deleteById( String id );
    User update( UserDTO userDto, String userId );
}  
