package week07.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @projectName: zsy-weekwork
 * @package: week07.datasource
 * @className: DataSourceConfig
 * @author: senyang.zheng
 * @description:
 * @date: 2022/6/19 21:44
 */
@Configuration
public class DataSourceConfig {
    @Resource
    private Environment environment;

    @Primary
    @Bean(name = "master")
    public DataSource masterDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.environment.getProperty("master.datasource.driver-class-name"));
        dataSource.setUrl(this.environment.getProperty("master.datasource.url"));
        dataSource.setUsername(this.environment.getProperty("master.datasource.username"));
        dataSource.setPassword(this.environment.getProperty("master.datasource.password"));
        return dataSource;

    }

    @Bean(name = "slave1")
    public DataSource slave1DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.environment.getProperty("slave1.datasource.driver-class-name"));
        dataSource.setUrl(this.environment.getProperty("slave1.datasource.url"));
        dataSource.setUsername(this.environment.getProperty("slave1.datasource.username"));
        dataSource.setPassword(this.environment.getProperty("slave1.datasource.password"));
        return dataSource;
    }

    @Bean(name = "slave2")
    public DataSource slave2DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.environment.getProperty("slave2.datasource.driver-class-name"));
        dataSource.setUrl(this.environment.getProperty("slave2.datasource.url"));
        dataSource.setUsername(this.environment.getProperty("slave2.datasource.username"));
        dataSource.setPassword(this.environment.getProperty("slave2.datasource.password"));
        return dataSource;
    }
}
