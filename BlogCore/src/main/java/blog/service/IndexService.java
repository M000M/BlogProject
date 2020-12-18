package blog.service;

import blog.dao.UserMapper;
import blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public String getPwdByUsername(String username) {
        return userMapper.getPwdByUsername(username);
    }
}
