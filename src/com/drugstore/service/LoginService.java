package com.drugstore.service;

/**
 * @author 李建昌
 * @className LoginService
 * @create 2022/12/3-14:03
 * @description 用户登录服务接口
 */
public interface LoginService {
     /**
      * @MethodName userPosition
      * @Author 李建昌
      * @Description 用于获取用户职位
      * @Date 10:57 2022/12/9
      * @Param [id, password]
      * @return java.lang.String
      **/
     String userPosition(String id,String password);
}
