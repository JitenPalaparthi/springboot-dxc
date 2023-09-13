package io.akalabs.securitydemo2;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public String home() {
        return ("<h1>Hello User>");
    }


    @GetMapping("/admin")
    @Secured("ROLE_ADMIN")    
    public String admin() {
        return ("<h1>Hello Admin</h1>");
    }


}
