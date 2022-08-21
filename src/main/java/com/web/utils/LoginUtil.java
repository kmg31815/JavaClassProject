package com.web.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.AuthException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.User;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * 參考資料：
 * https://medium.com/%E9%BA%A5%E5%85%8B%E7%9A%84%E5%8D%8A%E8%B7%AF%E5%87%BA%E5%AE%B6%E7%AD%86%E8%A8%98/%E7%AD%86%E8%A8%98-%E9%80%8F%E9%81%8E-jwt-%E5%AF%A6%E4%BD%9C%E9%A9%97%E8%AD%89%E6%A9%9F%E5%88%B6-2e64d72594f8
 * https://ithelp.ithome.com.tw/articles/10250968
 * https://www.delftstack.com/zh-tw/howto/java/how-to-convert-hashmap-to-json-object-in-java/
 * https://www.baeldung.com/jackson-linkedhashmap-cannot-be-cast
 */
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
		// io.jsonwebtoken.Claims extends java.util.Map<String, Object>
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
	 * @return user
	 * @throws AuthException
	 */
	public User validateJsonWebToken(String token) throws Throwable {
		User user = null;

		try {
			/*
			 * parseClaimsJwt() 解析沒有簽章的 token
			 * parseClaimsJws() 解析有簽章的 token
			 */
			Map<String, Object> body = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//			System.out.println(body.get("user")); // LinkedHashMap

			ObjectMapper objectMapper = new ObjectMapper();
			String stringUser = objectMapper.writeValueAsString(body.get("user")); // Object to String(JSON)
//			System.out.println(stringUser); // {"userId":0,"userName":"sherry","password":"123456"}

			user = objectMapper.readValue(stringUser, User.class); // String(JSON) to User
//			System.out.println(user);
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

//		return (User) body.get("user"); // class java.util.LinkedHashMap cannot be cast to class com.web.model.User
		return user;
	}

}
