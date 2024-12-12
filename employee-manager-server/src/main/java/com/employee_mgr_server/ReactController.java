package com.employee_mgr_server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReactController {

    @GetMapping(value = {"/"})
    public String redirectToReact() {
        // Return the React app's index.html
        return "forward:/index.html";
    }
}
