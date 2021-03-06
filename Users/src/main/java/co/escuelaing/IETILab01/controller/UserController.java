package co.escuelaing.IETILab01.controller;

import co.escuelaing.IETILab01.data.User;
import co.escuelaing.IETILab01.dto.UserDTO;
import co.escuelaing.IETILab01.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping ("/v1/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(@Autowired UserServiceImpl userService )
    {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> all()
    {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.findById( id ) );
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDTO userDto )
    {
        User user = new User(userDto);
        return ResponseEntity.ok(userService.create(user)) ;
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update(@RequestBody UserDTO userDto, @PathVariable String id )
    {
        return ResponseEntity.ok(userService.update(userDto, id ) );
    }

    @DeleteMapping( "/{id}" )
    @RolesAllowed("ADMIN")
    public ResponseEntity<Boolean> delete(@PathVariable String id )
    {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
