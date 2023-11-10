package tz.ac.udsm.chatBot.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author James S. Michael
 * @created 08-11-2023 17:19:38
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigs{




    @Bean
    public SecurityFilterChain conf(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(rq ->{
            rq.requestMatchers("/assets/**","/web","/register").permitAll();
            rq.requestMatchers("/users","/roles").hasAnyRole("ADMIN");
            rq.requestMatchers("/messages","/addresses").hasAnyRole("USER","ADMIN");

            rq.anyRequest().authenticated();
        });

        http.formLogin(form->{
            form.loginPage("/login").permitAll();
        });

        http.logout(logout->{
            logout.logoutUrl("/logout").permitAll();
        });

        return http.build();

    }



    //Manages users in memory
//    @Bean
//    public UserDetailsService userService1(){
//
//        User.UserBuilder userBuilder=User.builder().passwordEncoder(plaintText -> {
//            PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
//            return passwordEncoder.encode(plaintText);
//        } );
//
//        UserDetails user1=userBuilder.username("james").password("123").roles("USER").build();
//        UserDetails user2=userBuilder.username("james1").password("123").roles("ADMIN","USER").build();
//
//
//        UserDetailsService userDetailsService=new InMemoryUserDetailsManager(user1,user2);
//
//        return userDetailsService;
//    }



//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(rq ->{
//            rq.antMatchers("/web","/users/**").permitAll();
//            rq.anyRequest().authenticated();
//        });
//    }





    @Bean
    public PasswordEncoder createEncoder(){

        PasswordEncoder encoder=  new BCryptPasswordEncoder();

        //Change Default password encoder;

        return encoder;
    }
}
