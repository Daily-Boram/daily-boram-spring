package com.example.dailyboramspring.global.config;

import com.example.dailyboramspring.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final ObjectMapper objectMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/login/oauth2/code/naver").permitAll()

                .antMatchers(HttpMethod.GET, "/main").permitAll()

                .antMatchers(HttpMethod.POST, "/series").authenticated()
                .antMatchers(HttpMethod.GET, "/series/{series-id").authenticated()

                .antMatchers(HttpMethod.GET, "/search").permitAll()

                .antMatchers(HttpMethod.POST, "/episode/{series-id}").permitAll()
                .antMatchers(HttpMethod.POST, "/episode/{episode-id}").authenticated()

                .antMatchers(HttpMethod.POST, "/content/{episode-id}/{character-id}").permitAll()

                .antMatchers(HttpMethod.GET, "/profile/other/{user-id}").permitAll()
                .antMatchers(HttpMethod.GET, "/profile/me").permitAll()
                .antMatchers(HttpMethod.PATCH, "/profile").permitAll()

                .antMatchers(HttpMethod.POST, "/like/episode/{episode-id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/like/episode/{episode-id}").permitAll()
                .antMatchers(HttpMethod.POST, "/like/series/{series-id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/like/series/{episode-id}").permitAll()

                .antMatchers(HttpMethod.POST, "/character/{series-id}").permitAll()

                .antMatchers(HttpMethod.POST, "/comment/{episode-id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/comment/{episode-id}").permitAll()
                .antMatchers(HttpMethod.GET, "/comment/{episode-id}").permitAll()

                .anyRequest().authenticated()
                .and()
                .apply(new FilterConfig(objectMapper, jwtTokenProvider));

        return http.build();
    }
}