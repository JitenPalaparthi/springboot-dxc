package io.akalabs.securitydemo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

// bcrypt-generator.com
    @Bean
    public UserDetailsService user(){
        //UserBuilder users = User.withDefaultPasswordEncoder();

        //UserDetails user = users.username("user1").password("password1").roles("USER").build();
        //UserDetails admin = users.username("admin").password("admin123").roles("ADMIN").build();
        UserDetails user = User.builder().username("user1").password("{bcrypt}$2a$12$6vQZNaAfd9zg3utyE0BIe.XuIHQR8x0C99x1ygz.0gSFT/0t89zJW").roles("USER").build();
        UserDetails admin =User.builder().username("admin").password("{bcrypt}$2a$12$fkCvYf3s5v2p2duyAcsfiu.YvU8aesFKzhvcpyHeO/y2bgHv/e5LW").roles("ADMIN").build();
        // UserDetails dummyuser = users.build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
