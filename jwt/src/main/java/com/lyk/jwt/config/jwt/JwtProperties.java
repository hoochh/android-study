package com.lyk.jwt.config.jwt;

public class JwtProperties {
	String SECRET = "빅데이터 5기"; // 우리 서버만 알고 있는 비밀값
	int EXPIRATION_TIME = 864000000; //(1일)
	String TOKEN_PREFIX = "Bearer";
	String HEADER_STRING = "Authorization"; // 토큰 받을 때 어떤 문자열을 받을 것인가
}
