package blog.controller;

import blog.entity.User;
import blog.service.UserService;
import blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "users/index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String loginIndex() {
        return "users/login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,
                        Model model, HttpServletRequest request) {
        User user = userService.getPwdByUsername(username);
        String pwd = user.getPassword();
        String password1 = MD5Utils.md5Code(password).toUpperCase();
        String password2 = MD5Utils.md5Code(password1).toUpperCase();
        if (pwd.equals(password2)) {
            model.addAttribute("user", user);
            request.getSession().setAttribute("user", user);
            return "users/index";
        } else {
            return "users/failed";
        }
    }

    @RequestMapping(value = {"/signon"}, method = RequestMethod.GET)
    public String signOnIndex() {
        return "users/signon";
    }

    @RequestMapping(value = {"/signon"}, method = RequestMethod.POST)
    public String signOn(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password) {
        if (username == null || password == null) {
            return "users/adduser_failed";
        }
        boolean res = false;
        try {
            res = userService.addUser(username, password);
            if (res) {
                return "users/adduser_success";
            } else {
                return "users/adduser_failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "users/adduser_failed";
        }
    }
}
