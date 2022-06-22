package com.projeto.videoaula;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomerController {
    
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";
    }
}
