package blog.controller;

import blog.entity.User;
import blog.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/management")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        List<User> users = indexService.getUserList();
        return "management/index";
    }
}
