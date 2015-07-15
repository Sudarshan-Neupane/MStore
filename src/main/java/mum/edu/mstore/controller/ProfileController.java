package mum.edu.mstore.controller;

import javax.validation.Valid;
import mum.edu.mstore.domain.Profile;
import mum.edu.mstore.domain.User;
import mum.edu.mstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.logging.Logger;
import mum.edu.mstore.domain.Product;
import mum.edu.mstore.service.CategoryService;
import mum.edu.mstore.utils.SpringUtils;

/**
 *
 * @author sudarshan
 */
@Controller
@RequestMapping("/secure")
public class ProfileController {

    @Autowired
    private UserService userService;
      @Autowired
    private CategoryService categoryService;
//    @Autowired
//    private EmailMail emailsend;
    private static final Logger logger = Logger.getLogger(ProfileController.class.getName());

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profileCreate(Model model) {
        User user = this.userService.findByUserName(SpringUtils.getUserName());
        if (user == null) {
            user = new User();
        }
        Profile profile = new Profile();
        model.addAttribute("user", user);
        model.addAttribute("gender", Profile.Gender.values());
        model.addAttribute("profile", profile);
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String updateProfile(@Valid @ModelAttribute Profile profile, BindingResult result, Model model, Product product) {
        model.addAttribute("gender", Profile.Gender.values());
        if (result.hasErrors()) {
            System.out.println("inside has error");
            return "profile";
        }
        User user = this.userService.findByUserName(SpringUtils.getUserName());
//        emailsend.sendmail(user.getUserName());
        model.addAttribute("categories", categoryService.findAll());
        user.setProfile(profile);
        try {
            this.userService.updateProfile(user);
        } catch (IllegalArgumentException ex) {
            logger.info("exception occured in profile update");
            System.out.println(ex.getMessage());
            model.addAttribute("errors", ex.getMessage());
            return "profile";
        }
        return "redirect:home";
    }

}
