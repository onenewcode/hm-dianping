package com.hmdp.interceptor;


import com.hmdp.utils.UserHolder;


import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginInterceptor implements HandlerInterceptor {
//   private StringRedisTemplate stringRedisTemplate;
//
//    public LoginInterceptor(StringRedisTemplate stringRedisTemplate) {
//        this.stringRedisTemplate = stringRedisTemplate;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //1.获取请求头token
//        String token=request.getHeader("authorization");
////       //2.获取session中的用户
////        Object user = session.getAttribute("user");
//        //判断是否为空
//        if(StrUtil.isBlank(token)){
//            response.setStatus(401);
//            return false;
//        }
//        String key=RedisConstants.LOGIN_USER_KEY+token;
//        // 从redis获取用户
//        Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(key);
//         // 判断用户是否存在
//        if(userMap.isEmpty()){
//            response.setStatus(401);
//            return false;
//        }
//        UserDTO userDTO= BeanUtil.fillBeanWithMap(userMap,new UserDTO(),false);
////        //3.判断用户是否存在
////        if(user == null){
////            //4.不存在，拦截，返回401状态码
////            response.setStatus(401);
////            return false;
////        }
////        //5.存在，保存用户信息到Threadlocal
//        UserHolder.saveUser((UserDTO) userDTO);
//        //刷新token有效期
//        stringRedisTemplate.expire(key,RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
////            //6.放行
//        return true;
//    }
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // 1.判断是否需要拦截（ThreadLocal中是否有用户）
    if (UserHolder.getUser() == null) {
        // 没有，需要拦截，设置状态码
        response.setStatus(401);
        // 拦截
        return false;
    }
    // 有用户，则放行
    return true;
}


}

