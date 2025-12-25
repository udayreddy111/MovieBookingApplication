
// src/main/java/com/jaswin/config/GlobalCorsFilter.java
package com.jaswin.theatreregistration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.*;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class GlobalCorsFilter {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistration() {
        CorsConfiguration config = new CorsConfiguration();

        // List explicit dev origins that will call your backend
        config.setAllowedOrigins(List.of(
                "http://localhost:5500",  // python -m http.server
                "http://localhost:5173",  // Vite dev server (if you use it later)
                "http://localhost:3000"   // other dev servers
        ));
        // If you might access via 127.0.0.1 as well:
        // config.setAllowedOrigins(List.of("http://127.0.0.1:5500", ...));

        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setExposedHeaders(List.of("Location")); // optional
        config.setAllowCredentials(false);             // set true only if using cookies/sessions
        config.setMaxAge(3600L);                       // cache preflight for 1 hour

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Apply to ALL paths (including /api/**)
        source.registerCorsConfiguration("/**", config);

        CorsFilter corsFilter = new CorsFilter(source);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(corsFilter);
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE); // run before other filters
        return bean;
    }
}