package week07.shardingsphere;

import com.zaxxer.hikari.HikariDataSource;
import io.shardingsphere.api.config.MasterSlaveRuleConfiguration;
import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * @projectName: zsy-weekwork
 * @package: week07.shardingsphere
 * @className: ShardingMasterSlaveDataSource
 * @author: senyang.zheng
 * @description:
 * @date: 2022/6/19 23:31
 */
@Slf4j
@Component
public class ShardingMasterSlaveDataSource {


    @Resource
    private Environment environment;

    DataSource createDataSource() throws SQLException {
        // 获取数据库列表
        String[] dbs = Objects.requireNonNull(this.environment.getProperty("sharding.jdbc.datasource.names")).split(",");
        log.info("dbs::" + Arrays.toString(dbs));

        // 设置主从，约定第一个为主，其他为从
        MasterSlaveRuleConfiguration configuration = new MasterSlaveRuleConfiguration(dbs[0], dbs[0],
                Arrays.asList(Arrays.copyOfRange(dbs, 1, dbs.length)));
        log.info("ShardingMasterSlaveDataSource master :: " + configuration.getMasterDataSourceName());
        log.info("ShardingMasterSlaveDataSource slave :: " + configuration.getSlaveDataSourceNames());

        // 设置打印SQL语句，查看主从配置和切换是否成功
        Properties properties = new Properties();
        properties.setProperty("sql.show", "true");

        return MasterSlaveDataSourceFactory.createDataSource(this.createDataSourceMap(dbs), configuration, new HashMap<>(0),
                properties);
    }

    private Map<String, DataSource> createDataSourceMap(String[] dbs) {
        Map<String, DataSource> result = new HashMap<>(dbs.length);
        for (String db : dbs) {
            log.info("Create data source ::" + db);
            result.put(db, this.createDataSource("sharding.jdbc.datasource." + db));
        }
        return result;
    }

    private DataSource createDataSource(String prefix) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(this.environment.getProperty(prefix + ".driver-class-name"));
        dataSource.setJdbcUrl(this.environment.getProperty(prefix + ".url"));
        dataSource.setUsername(this.environment.getProperty(prefix + ".username"));
        dataSource.setPassword(this.environment.getProperty(prefix + ".password"));
        return dataSource;
    }
}
