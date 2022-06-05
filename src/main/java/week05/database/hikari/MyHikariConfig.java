package week05.database.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class MyHikariConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/zsy_test");
        config.setMaximumPoolSize(20);
        config.setUsername("root");
        config.setPassword("123456");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }
}
