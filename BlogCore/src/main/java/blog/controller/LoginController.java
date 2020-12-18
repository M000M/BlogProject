package blog.controller;

import blog.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = {"", "/", "/index", "/login"}, method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,
                        Model model, HttpServletRequest request) {

        System.out.println(username);
        System.out.println(password);
        String pwd = indexService.getPwdByUsername((String)username);
        return "index";
    }
}
