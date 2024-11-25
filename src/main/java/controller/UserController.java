package controller;


import model.User;
//import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

//    @Autowired
//    UserService userService;

    @RequestMapping(value = "save", method = RequestMethod.GET)
    public String add(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/new";

    }
//
//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public void add(@ModelAttribute("user") User user){
//        System.out.println(user);
//        userService.save(user);
//
//
//    }
}
