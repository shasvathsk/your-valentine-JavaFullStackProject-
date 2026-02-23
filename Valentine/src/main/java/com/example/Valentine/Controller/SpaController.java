package com.example.Valentine.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaController {

    // This catches top-level paths and nested paths (like /countdown/123)
    // while ignoring static files like .js or .css
    @GetMapping(value = { "/{path:[^\\.]*}", "/*/{path:[^\\.]*}" })
    public String forward() {
        return "forward:/index.html";
    }
}