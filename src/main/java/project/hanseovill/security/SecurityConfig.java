package project.hanseovill.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){

        return (web) -> web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .authorizeHttpRequests()
                .antMatchers("/api/signup").permitAll()
                .antMatchers("/api/hello").permitAll()
                .anyRequest().authenticated();

        return httpSecurity.build();
    }


}
