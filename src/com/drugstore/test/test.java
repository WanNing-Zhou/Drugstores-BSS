

import com.drugstore.bean.CustomerInfo;
import com.drugstore.dao.CustomerInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author 周万宁
 * @className test
 * @create 2022/12/5-13:13
 * @description 测试
 */
public class test {

//    public static void main(String[] args) throws Exception {
//        //获取数据库连接
//        Connection conn = JDBCUtils.getConnection();
//        System.out.println(conn);
//        //创建CustomerInfo类
//        CustomerInfo cust = new CustomerInfo("zhouzhou","12345671");
//        //通过单例工厂获取dao实例
//        CustomerInfoDAO dao = DAOSingleton.getCustomerInfoDAO();
//        //添加
//        dao.insert(conn,cust);
//
//        //断开数据库连接
//        JDBCUtils.closeResource(conn,null);
//
//    }
//    @Test
//    public void test(){
//
//        System.out.println("你好");
//    }

}
