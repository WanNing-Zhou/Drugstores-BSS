package com.drugstore.factory;

import com.drugstore.service.*;
import com.drugstore.service.impl.*;

/**
 * @author 周万宁
 * @className ServiceSingleton
 * @create 2022/12/5-11:52
 * @description 单例模式获取service单例
 */
public class ServiceSingleton {

    private static LoginService loginService= new LoginServiceImpl();
    private static AddInfoService addInfoService = new AddInfoServiceImpl();
    private static DeleteService deleteService = new DeleteServiceImpl();
    private static GetInstanceService getInstanceService = new GetInstanceServiceImpl();
    private static GetForListService getForListService = new GetForListServiceImpl();


    //私有化构造方法
    private  ServiceSingleton(){};


    public static LoginService getLoginService() {
        return loginService;
    }

    public static AddInfoService getAddInfoService() {
        return addInfoService;
    }

    public static DeleteService getDeleteService() {
        return deleteService;
    }

    public static GetInstanceService getGetInstanceService() {
        return getInstanceService;
    }

    public static GetForListService getGetForListService() {
        return getForListService;
    }


}
