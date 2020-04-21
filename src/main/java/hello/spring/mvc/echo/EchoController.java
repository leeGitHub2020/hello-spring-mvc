package hello.spring.mvc.echo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EchoController {

    @ModelAttribute //test12
    public EchoForm setUpEchoForm() {
        EchoForm form = new EchoForm();
        return form;
    }

    @RequestMapping
    public String index(Model model) {
        return "echo/input";
    }

    @RequestMapping(value = "echo/echo", method = RequestMethod.POST)
    public String echo(@Validated EchoForm form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "echo/input";
        }

        model.addAttribute("name", form.getName());
        return "echo/echo";
    }

}