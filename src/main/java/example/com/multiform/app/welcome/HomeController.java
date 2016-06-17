package example.com.multiform.app.welcome;

import javafx.scene.Parent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Model model) {

        return "welcome/home";
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public String entry(@Validated ParentForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "welcome/home";
        }

        System.out.println("----------------------");
        System.out.println(form);
        System.out.println("----------------------");
        return "welcome/home";
    }

    @ModelAttribute
    public ParentForm setUpParentForm() {
        ParentForm parentForm = new ParentForm();
        parentForm.setUserFormList(Arrays.asList(new UserForm("初期値A", "初期値B"), new UserForm("初期値C", "初期値D")));
        return parentForm;
    }

}