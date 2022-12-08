package com.drugstore.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.drugstore.factory.ServiceSingleton;
import org.junit.Test;

import java.util.List;

/**
 * @author 周万宁
 * @className TestForJson
 * @create 2022/12/6-15:25
 * @description fastJson测试
 */
public class TestForJson {
    @Test
    public void testJson(){
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<CustomerInfo> allCustomerInfo = sev.getAllCustomerInfo();
        System.out.println(allCustomerInfo);
        String re = JSON.toJSONString(allCustomerInfo, SerializerFeature.WriteMapNullValue);

        System.out.println(re);
    }

}
