package com.example.evenements.security;

/*
import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled= true)
public class SecurityConfig {
	
	/*
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws
		Exception{
			http.sessionManagement( session ->
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			
			.csrf( csrf -> csrf.disable())
			
		//////ce code j'ai le fait en webconfig!!!!!!!
					/*
					 * 
					 * .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
					 * 
					 * @Override public CorsConfiguration getCorsConfiguration(HttpServletRequest
					 * request) { CorsConfiguration cors = new CorsConfiguration();
					 * 
					 * cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
					 * cors.setAllowedMethods(Collections.singletonList("*"));
					 * cors.setAllowedHeaders(Collections.singletonList("*"));
					 * cors.setExposedHeaders(Collections.singletonList("Authorization")); return
					 * cors; } }))
					 */
			
		/**	
			.authorizeHttpRequests( requests ->
			requests.requestMatchers(HttpMethod.GET, "api/all").hasAnyAuthority("ADMIN", "USER")
			

						.requestMatchers(HttpMethod.GET,"/api/getbyid/**").hasAnyAuthority("ADMIN", "USER")
						//.requestMatchers(HttpMethod.POST,"/api/addev/**").hasAnyAuthority("ADMIN")
						.requestMatchers(HttpMethod.PUT,"/api/updateev/**").hasAnyAuthority("ADMIN")
						.requestMatchers(HttpMethod.DELETE,"/api/deleteev/**").hasAnyAuthority("ADMIN")
						.requestMatchers("/api/image/**").permitAll()
						.requestMatchers("/themes/**").hasAnyAuthority("ADMIN", "USER")
						.requestMatchers("/themes/themes/**").hasAnyAuthority("ADMIN", "USER")
					.anyRequest().authenticated() )
			
			.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
			
					
			
		return http.build();
	}
}*/
/***
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/******************Permit all the users* correct one*////////////	
	
/*	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	        .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	        .cors().configurationSource(new CorsConfigurationSource() {
	            @Override
	            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
	                CorsConfiguration config = new CorsConfiguration();
	                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	                config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	                config.setAllowCredentials(true);
	                config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With", "Accept", "Origin"));
	                config.setExposedHeaders(Arrays.asList("Authorization"));
	                config.setMaxAge(3600L);
	                return config;
	            }
	        }).and()
	        .authorizeHttpRequests()
	            .anyRequest().permitAll()  // Permet l'accès à toutes les requêtes sans restriction
	            
	        .and()
	        .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}

}*/
////////////////*permit all*////////////////////////////




/********************** New*///
import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled= true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf( csrf -> csrf.disable()) 
        .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration cors = new CorsConfiguration();
                
                cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                cors.setAllowedMethods(Collections.singletonList("*"));
                cors.setAllowedHeaders(Collections.singletonList("*"));
                cors.setExposedHeaders(Collections.singletonList("Authorization"));
                
                return cors;
            }
        }))
        .authorizeHttpRequests( requests ->
		requests.requestMatchers(HttpMethod.GET, "api/all").hasAnyAuthority("ADMIN", "USER")
		
                .requestMatchers(HttpMethod.GET, "/api/getbyid/**").hasAnyAuthority("ADMIN", "USER")
               // .requestMatchers(HttpMethod.POST, "/api/addev/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/updateev/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/deleteev/**").hasAuthority("ADMIN")
                /*.requestMatchers("/gen/**").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers("/api/vetcgen/**").hasAnyAuthority("ADMIN", "USER")*/
                
                
                
             // Images endpoints
				.requestMatchers(HttpMethod.POST, "/api/image/uplaodImageEv/**")
				.hasAnyAuthority("ADMIN", "USER")
				.requestMatchers(HttpMethod.POST, "/api/image/upload")
				.hasAuthority("ADMIN")
               
        			
        				

        				// Images endpoints
				.requestMatchers(HttpMethod.POST, "/api/image/uplaodImageEv/**")
				.hasAnyAuthority("ADMIN", "USER")
				.requestMatchers(HttpMethod.POST, "/api/image/upload")
				.hasAuthority("ADMIN")
        				.requestMatchers(HttpMethod.GET, "/api/image/getImagesEv/**").hasAnyAuthority("ADMIN", "USER")
        				.requestMatchers(HttpMethod.GET, "/api/image/get/info/**")
        				.hasAnyAuthority("ADMIN", "USER")
        				.requestMatchers(HttpMethod.GET, "/api/image/load/**")
        				.hasAnyAuthority("ADMIN", "USER")
        				.requestMatchers(HttpMethod.DELETE, "/api/image/delete/**")
        				.hasAuthority("ADMIN")
        				.requestMatchers(HttpMethod.PUT, "/api/image/update")
        				.hasAuthority("ADMIN")

        				// Other requests
        				.anyRequest().authenticated())
        		.addFilterBefore(new JWTAuthorizationFilter(),
        				UsernamePasswordAuthenticationFilter.class);
        		return http.build();

        		

              /*  .anyRequest().authenticated())
            .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();*/
  
}
}





	


