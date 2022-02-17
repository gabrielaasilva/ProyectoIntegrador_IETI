package co.escuelaing.IETILab01.dto;

public class LoginDto{
    public static String email;
    public static String password;


    public LoginDto( String email, String password ){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
