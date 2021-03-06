package org.identifiers.cloud.hq.ws.miridcontroller.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.PostConstruct;

/**
 * Project: mirid-controller
 * Package: org.identifiers.cloud.hq.ws.miridcontroller.configuration
 * Timestamp: 2019-04-24 11:06
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
@Configuration
@Slf4j
@Profile("authdisabled")
@EnableWebSecurity
public class NoAuthSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @PostConstruct
    private void postConstruct() {
        log.info("[CONFIG] NO AUTH configuration loaded");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Opening all requests, without authorization");
        http.authorizeRequests().anyRequest().permitAll();
    }
}
