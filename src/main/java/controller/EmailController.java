package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.EmailService;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/mail/send")
    public String sendMail(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            Model model) {
        try {
            emailService.sendEmail(to, subject, message);
            model.addAttribute("success", "Email sent successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Error sending email: " + e.getMessage());
        }
        return "mail/mailResult";
    }

    @RequestMapping("/mail/sendMail")
    public String mail(){
        return "mail/sendMailForm";
    }
}
