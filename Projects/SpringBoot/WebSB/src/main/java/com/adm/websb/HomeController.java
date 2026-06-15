package com.adm.websb;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    public ModelAndView home(Alien alien) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj",alien);
        mv.setViewName("home");
        return mv;
    }
}
