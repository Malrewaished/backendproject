package com.example.backendproject.configuration;
import com.example.backendproject.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/register").permitAll()
                .antMatchers("/api/v1/users").hasAuthority("Admin")
                .antMatchers("/api/v1/update/{id}").hasAuthority("Admin")
                .antMatchers("/api/v1/delete/{id}").hasAuthority("Admin")
                .antMatchers("/api/v1/admin").hasAuthority("Admin")
                .antMatchers("/api/v1/login").hasAuthority("Admin")
                .antMatchers("/api/v1/doctors").permitAll()
                .antMatchers("/api/v1/doctors/{id}").permitAll()
                .antMatchers("/api/v1/patients").permitAll()
                .antMatchers("/api/v1/app").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/auth/logout")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .and()
                .httpBasic();
    }
}
