package week07.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @projectName: zsy-weekwork
 * @package: week07.datasource
 * @className: DataSourceCenter
 * @author: senyang.zheng
 * @description:
 * @date: 2022/6/19 22:00
 */
@Component
public class DataSourceCenter {
    @Autowired
    @Qualifier("master")
    private DataSource masterDataSource;
    @Autowired
    @Qualifier("slave1")
    private DataSource slave1DataSource;
    @Autowired
    @Qualifier("slave2")
    private DataSource slave2DataSource;

    int slaveIndex = 1;

    public DataSource getDefaultDataSource() {
        return this.masterDataSource;
    }

    /**
     * 这里就简单的模拟一下负载均衡
     */
    public DataSource getSlaveDataSource() {
        if (this.slaveIndex == 1) {
            this.slaveIndex = 2;
            return this.slave1DataSource;
        }
        this.slaveIndex = 1;
        return this.slave2DataSource;
    }
}
