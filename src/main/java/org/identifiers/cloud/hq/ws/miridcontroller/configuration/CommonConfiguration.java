package org.identifiers.cloud.hq.ws.miridcontroller.configuration;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.http11.Http11AprProtocol;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Project: mirid-controller
 * Package: org.identifiers.cloud.hq.ws.miridcontroller.configuration
 * Timestamp: 2019-02-19 14:09
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 *
 * Common configuration
 */
@Configuration
@EnableJpaAuditing
@EnableRetry
public class CommonConfiguration {
    // TODO
    // Redis configuration
    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress(String.format("redis://%s:%d", redisHost, redisPort));
        return Redisson.create(config);
    }

    @Bean
    public TomcatServletWebServerFactory servletContainerFactoryProd() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(); // {
//            @Override
//            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
//                // to create new directories and files and add them to Context
//                return super.getTomcatWebServer(tomcat);
//            }
//        };
        tomcat.setProtocol("org.apache.coyote.http11.Http11AprProtocol");
//        Connector connector = new Connector("org.apache.coyote.http11.Http11AprProtocol");
//        Http11AprProtocol protocol = (Http11AprProtocol) connector.getProtocolHandler();
//        connector.setProperty("compression", "on");
//        connector.setProperty("compressableMimeType", "text/html,text/xml,text/plain,application/json,application/xml");
//        // can also enable ssl and provide certificate details
//        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }

}
