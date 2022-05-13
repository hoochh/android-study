package com.lyk.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration //설정 파일
public class CorsConfig { //Cors : Cross-Origin Resource Sharing Policy(서로 다른 플랫폼(spring, android)에서 share 하는 정책

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*"); //e.g. http://domain1.com
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		
		source.registerCorsConfiguration("/api/**", config); // 외부에서 접근시 api/...로만 접근 가능
		return new CorsFilter(source);
	}
}
