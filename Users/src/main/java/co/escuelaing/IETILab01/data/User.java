package co.escuelaing.IETILab01.data;

import co.escuelaing.IETILab01.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;
import java.util.List;

@Document
public class User {
    @Id
    private String id;
    private String name;

    @Indexed(unique = true)
    private String email;
    private String lastName;
    private String createdAt;
    private String passwordHash;
    private List<RoleEnum> roles;

    public User(UserDTO userDto){
        this.email = userDto.getEmail();
        this.lastName = userDto.getLastName();
        this.createdAt = new Date().toString();
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public List<RoleEnum> getRoles() { return roles;}
    public void setRoles(List<RoleEnum> roles) {this.roles = roles;}
    public String getPasswordHash() { return passwordHash;}
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash;}

}
