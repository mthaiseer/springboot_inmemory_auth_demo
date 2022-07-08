package io.code.inmemoryauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {

    private static final String DEVELOPER_AUTHORITY = "developer";
    private static final String DEVOPS_AUTHORITY = "devops";


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("jim")
                .password("$2a$10$KmK9TbNee7haKdIzctS6jOxYaAMgSx6jknRt7BsmmFWDhxERz3/rq")//("jim123")
                .authorities(DEVELOPER_AUTHORITY)
                .and()
                .withUser("peter")
                .password("$2a$10$J6TKtJWW6uZ3oFo/W/OFnu.11F4tkfqtFRUjS1PmCztHaLYQw91Nq")//("peter123")
                .authorities(DEVOPS_AUTHORITY)
                .and()
                .withUser("catalina")
                .password("$2a$10$54R/0iWJoNLifcifEhZOOukzrvUnbzDXca0aUbyKL91zyDMiulzf.")//("catalina123")
                .authorities(DEVOPS_AUTHORITY,DEVELOPER_AUTHORITY);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.httpBasic()
               .and()
               .authorizeHttpRequests()
               .antMatchers("/developer/**").hasAnyAuthority(DEVELOPER_AUTHORITY)
               .antMatchers("/devops/**").hasAnyAuthority(DEVOPS_AUTHORITY)
               .antMatchers("/**").permitAll()
               .and()
               .formLogin();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
