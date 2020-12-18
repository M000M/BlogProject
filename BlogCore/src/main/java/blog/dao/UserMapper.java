package blog.dao;

import blog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> getUserList();

    String getPwdByUsername(String username);
}
