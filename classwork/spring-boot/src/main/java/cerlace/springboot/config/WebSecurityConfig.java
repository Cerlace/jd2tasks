package cerlace.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationConverter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/addCity").hasRole("ADMIN")      // Только для ADMIN
                        .requestMatchers("/addCity").hasAuthority("ADMIN")      // Только для ADMIN
                        .requestMatchers("/getCity", "/cities/*").hasAnyAuthority("USER", "ADMIN") // Для USER и ADMIN
                        .requestMatchers("/index").permitAll() // Разрешить без аутентификации
                        .anyRequest().authenticated()            // Все остальные требуют аутентификации
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/getCity", true)
                        .permitAll()// Перенаправление после успешного входа
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .permitAll()
                        // Перенаправление после выхода
                );
        return httpSecurity.build();
    }
}

//        httpSecurity
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/public/**", "/login").permitAll() // Разрешить без аутентификации
//                        .requestMatchers("/admin/**").hasRole("ADMIN")      // Только для ADMIN
//                        .anyRequest().authenticated()                        // Все остальные требуют аутентификации
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")                                 // Кастомная страница входа
//                        .defaultSuccessUrl("/home", true)                   // Перенаправление после успешного входа
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")                                // URL для выхода
//                        .logoutSuccessUrl("/login?logout")                   // Перенаправление после выхода
//                );