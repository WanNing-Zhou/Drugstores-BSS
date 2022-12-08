package com.drugstore.service.impl;

import com.drugstore.bean.*;
import com.drugstore.dao.*;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.GetTheLastListCurrentAmount;
import com.drugstore.service.GetTheLastListNumber;
import com.drugstore.utils.JDBCUtils;
import netscape.javascript.JSException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class GetTheLstListCurrentAmountImpl implements GetTheLastListCurrentAmount {

    @Override
    public BigDecimal GetTheLastFinancialRevenueAndExpenditureListCurrentAmount() {
        Connection conn = null;

        return null;
    }
}
