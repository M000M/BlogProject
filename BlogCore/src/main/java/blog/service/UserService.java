package blog.service;

import blog.dao.UserMapper;
import blog.entity.User;
import blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public User getPwdByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    public boolean addUser(String username, String password) {
        User user = new User();

        user.setUsername(username);
        String password1 = MD5Utils.md5Code(password).toUpperCase();
        String password2 = MD5Utils.md5Code(password1).toUpperCase();
        user.setPassword(password2);
        user.setCreateTime(new Date());

        int res = userMapper.addUser(user);
        if (res > 0) {
            return true;
        } else {
            return false;
        }
    }
}
