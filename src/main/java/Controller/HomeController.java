package Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HomeController {

    @RequestMapping("/testing")
    public String Test(){
        return "index";
    }
}
