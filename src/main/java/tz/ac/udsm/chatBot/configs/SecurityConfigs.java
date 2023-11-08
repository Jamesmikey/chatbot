package tz.ac.udsm.chatBot.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author James S. Michael
 * @created 08-11-2023 17:19:38
 */
@Configuration
//@EnableWebSecurity
public class SecurityConfigs extends SecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder createEncoder(){
//        PasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        PasswordEncoder bCryptPasswordEncoder=  PasswordEncoderFactories.createDelegatingPasswordEncoder();

        //Change Default password encoder;

        return bCryptPasswordEncoder;
    }
}
