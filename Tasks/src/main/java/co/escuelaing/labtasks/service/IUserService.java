public interface IUserService {
    User create( User user );
    User findById( String id );
    List<User> getAll();
    void deleteById( String id );
    User update( UserDto userDto, String userId );
}
 