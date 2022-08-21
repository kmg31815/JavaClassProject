package com.web.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.AuthException;

import com.web.model.User;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class LoginUtil {

	private static final long EXPIRATION_TIME = 30 * 60 * 1000; // 1800000ms = 1800s = 30min
	private static final String SECRET_KEY = "my secret key";

	/**
	 * 產生 JWT
	 * 
	 * @param user 使用者資訊
	 * @return token
	 */
	public String generateJsonWebToken(User user) {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("user", user);

		return Jwts.builder().setClaims(body) // 設定要包進token的資訊
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 設定token到期時間
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 指定加密演算法、key 進行簽章
				.compact(); // 實際構建 JWT
	}

	/**
	 * 驗證 JWT
	 * 
	 * @param token
	 * @return username
	 * @throws AuthException
	 */
	public User validateJsonWebToken(String token) throws Throwable {
		System.out.println(token);
		Map<String, Object> body = null;

		try {
			/*
			 * parseClaimsJwt() 解析沒有簽章的 token parseClaimsJws() 解析有簽章的 token
			 */
			body = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
			System.out.println(body);
		} catch (SignatureException e) {
			throw new AuthException("Invalid JWT signature.");
		} catch (MalformedJwtException e) {
			throw new AuthException("Invalid JWT token.");
		} catch (ExpiredJwtException e) {
			throw new AuthException("Expired JWT token (token 過期)");
		} catch (UnsupportedJwtException e) {
			throw new AuthException("Unsupported JWT token");
		} catch (IllegalArgumentException e) {
			throw new AuthException("JWT token compact of handler are invalid");
		}

		return (User) body.get("user");
	}

}
