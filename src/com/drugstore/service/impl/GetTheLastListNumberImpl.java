package com.drugstore.service.impl;

import com.drugstore.bean.*;
import com.drugstore.dao.*;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.GetTheLastListNumber;
import com.drugstore.utils.JDBCUtils;
import netscape.javascript.JSException;

import java.sql.Connection;
import java.util.List;
/**
 * @Author 卢明德,获取最后一条ID
 * @Description TODO
 * @Date 13:23 2022/12/9
 **/

public class GetTheLastListNumberImpl implements GetTheLastListNumber {

    public int GetTheLastMarketingInfoListNumber() {
        Connection conn = null;
        int num = 0;
        try {
            conn = JDBCUtils.getConnection();
            MarketingInfoDAO dao = DAOSingleton.getMarketingInfoDAO();
            num = dao.getTheLastListNumber(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return num;
    }


}
