package com.gow.beau.api.login;

import com.gow.beau.model.data.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lzn on 2019/2/27.
 */
public class JwtLogin {

    //token 有效时间
    private static Long TOKEN_MILLIS = 2*60*60*1000L;

   /**
    * lzn 2019/2/27 12:45
    * 用户登陆成功后生成的jwt
    * 使用hs256算法 私钥使用用户密码
    *
    * @param jwtMillis  jwt过期时间
    * @param user  登陆成功的user对象
    * @return
    */
   public static String createJWT(Long jwtMillis , User user){
       if(null == jwtMillis){
           jwtMillis = TOKEN_MILLIS;
       }
       //指定签名的时候签名的算法
       SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

       //生成jwt时间
       Long millis = System.currentTimeMillis();
       Date date = new Date(millis);

       //创建payload的私有声明
       Map<String,Object> claims = new HashMap<>();
       claims.put("id", user.getId());
       claims.put("username" , user.getUserName());
       claims.put("password" , user.getPassWord());

       //生成签名的时候使用的私钥secret
       String key = user.getPassWord();

       //生成签发人
       String subject = user.getUserName();

       //为payload添加各种标准声明和私有声明
       //这里其实就是new一个JwtBuilder，设置jwt的body
       JwtBuilder builder = Jwts.builder()
               .setClaims(claims)  //如果有私有声明，则先设置这个自己创建的私有声明，这个是给builder的claim赋值，一旦写在标准声明赋值之后，就是覆盖了那些标准的声明了
               .setId(UUID.randomUUID().toString()) // 设置jwt id ：是jwt的唯一标识
               .setIssuedAt(date)  //jwt的签发时间
               .setSubject(subject)  //代表这个jwt的主体
               .signWith(signatureAlgorithm , key);  //设置签名使用的签名算法和签名使用的密钥


       if(millis >= 0){
           Long expMillis = millis + jwtMillis;
           Date exp = new Date(expMillis);
           //设置过期时间
           builder.setExpiration(exp);
       }

       return builder.compact();
   }


   /**
    * lzn 2019/2/27 16:54
    * token的解密
    * @param token 加密后的token
    * @param user 用户对象
    * @return
    */
   public static Claims parseJWT(String token , User user){
       //签名密钥,和生成的签名的密钥一模一样
       String key = user.getPassWord();

       //得到defaultJwtParser
       Claims claims = Jwts.parser()
               //设置签名的密钥
               .setSigningKey(key)
               //设置需要解析的jwt
               .parseClaimsJws(token).getBody();

       return claims;
   }


   /**
    * lzn 2019/2/27 16:59
    * 校验token
    * 在这里可以使用官方的校验，这里的校验是token中携带的密码与数据库一致就校验通过
    * @param token
    * @param user
    * @return
    */
   public static Boolean isVerify(String token , User user){
       try {
           //签名密钥，和生成的签名密钥一模一样
           String key = user.getPassWord();

           //得到DefaultJwtParser
           Claims claims = Jwts.parser()
                   //设置签名的密钥
                   .setSigningKey(key)
                   //设置需要的解析jwt
                   .parseClaimsJws(token).getBody();

           if (claims.get("password").equals(user.getPassWord())) {
               return true;
           }
       }catch (Exception e){
           return false;
       }

       return false;
   }


}
