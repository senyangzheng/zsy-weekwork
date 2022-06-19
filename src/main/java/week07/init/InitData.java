package week07.init;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Properties;

/**
 * @projectName: zsy-weekwork
 * @package: week07.init
 * @className: PreparedStatement
 * @author: senyang.zheng
 * @description:
 * @date: 2022/6/19 03:45
 */
@Component
@Slf4j
public class InitData {
    private Connection connection = getDataSource().getConnection();

    public InitData() throws Exception {
    }

    static DataSource getDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", "com.mysql.jdbc.Driver");
        props.put("url", "jdbc:mysql://localhost:3306/geek_test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
        props.put("username", "root");
        props.put("password", "123456");
        return DruidDataSourceFactory.createDataSource(props);
    }

    public void initData1() throws Exception {
        long start = System.currentTimeMillis();
        String sql = "load data local infile '/Users/yyyz/geek_test_orders.csv' into table orders FIELDS TERMINATED BY ','";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.execute();
        long end = System.currentTimeMillis();
        System.out.println("PreparedStatement load data插入100w条数据总花费的时间：" + (end - start) + "毫秒");
    }

    public void initData2() throws Exception {
        long start = System.currentTimeMillis();
        String sql = "insert into orders values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        for (int i = 1000001; i <= 2000000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, String.valueOf(i));
            preparedStatement.setInt(3, i);
            preparedStatement.setInt(4, i);
            preparedStatement.setString(5, String.valueOf(i));
            preparedStatement.setInt(6, 0);
            preparedStatement.setInt(7, 0);
            preparedStatement.setObject(8, new BigDecimal(i).setScale(2, BigDecimal.ROUND_HALF_UP));
            preparedStatement.setObject(9, new Date());
            preparedStatement.setObject(10, new Date());
            preparedStatement.setInt(11, 0);
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("PreparedStatement 依次插入100w条数据总花费的时间：" + (end - start) + "毫秒");
    }

    public void initData3() throws Exception {
        long start = System.currentTimeMillis();
        String sql = "insert into orders values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        for (int i = 2000001; i <= 3000000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, String.valueOf(i));
            preparedStatement.setInt(3, i);
            preparedStatement.setInt(4, i);
            preparedStatement.setString(5, String.valueOf(i));
            preparedStatement.setInt(6, 0);
            preparedStatement.setInt(7, 0);
            preparedStatement.setObject(8, new BigDecimal(i).setScale(2, BigDecimal.ROUND_HALF_UP));
            preparedStatement.setObject(9, new Date());
            preparedStatement.setObject(10, new Date());
            preparedStatement.setInt(11, 0);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        long end = System.currentTimeMillis();
        System.out.println("PreparedStatement 一次性插入100w条数据总花费的时间：" + (end - start) + "毫秒");
    }

    public void initData4() throws Exception {
        long start = System.currentTimeMillis();
        String sql = "insert into orders values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        for (int i = 3000001; i <= 4000000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, String.valueOf(i));
            preparedStatement.setInt(3, i);
            preparedStatement.setInt(4, i);
            preparedStatement.setString(5, String.valueOf(i));
            preparedStatement.setInt(6, 0);
            preparedStatement.setInt(7, 0);
            preparedStatement.setObject(8, new BigDecimal(i).setScale(2, BigDecimal.ROUND_HALF_UP));
            preparedStatement.setObject(9, new Date());
            preparedStatement.setObject(10, new Date());
            preparedStatement.setInt(11, 0);
            preparedStatement.addBatch();
            if (i % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("PreparedStatement 分批插入100w条数据总花费的时间：" + (end - start) + "毫秒");
    }

}
