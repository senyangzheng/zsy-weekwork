/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package week08.sharding;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Order service.
 */
class XAOrderService {

    private final DataSource dataSource;

    XAOrderService(final String yamlConfigFile) throws IOException, SQLException {
        this.dataSource = YamlShardingSphereDataSourceFactory.createDataSource(this.getFile(yamlConfigFile));
    }

    private File getFile(final String fileName) {
        return new File(fileName);
    }

    /**
     * Init.
     */
    void init() throws SQLException {
        try (Connection connection = this.dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS t_order");
            statement.execute("CREATE TABLE t_order (order_id BIGINT AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id))");
            // for PostgreSQL
//            statement.execute("CREATE TABLE IF NOT EXISTS t_order (order_id BIGINT PRIMARY KEY NOT NULL, user_id INT NOT NULL, status VARCHAR(50))");
        }
    }

    /**
     * Clean up.
     */
    void cleanup() throws SQLException {
        try (Connection connection = this.dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS t_order");
        }
    }

    /**
     * Execute XA.
     *
     * @throws SQLException SQL exception
     */
    void insert() throws SQLException {
        TransactionTypeHolder.set(TransactionType.XA);
        try (Connection connection = this.dataSource.getConnection()) {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO t_order (order_id, user_id, logistics_id, commodity_ids, order_status, refund_status, order_price, create_time, update_time, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            this.doInsert(preparedStatement);
            connection.commit();
        } finally {
            TransactionTypeHolder.clear();
        }
    }

    /**
     * Execute XA with exception.
     *
     * @throws SQLException SQL exception
     */
    void insertFailed() throws SQLException {
        TransactionTypeHolder.set(TransactionType.XA);
        try (Connection connection = this.dataSource.getConnection()) {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO t_order (order_id, user_id, logistics_id, commodity_ids, order_status, refund_status, order_price, create_time, update_time, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            this.doInsert(preparedStatement);
            connection.rollback();
        } finally {
            TransactionTypeHolder.clear();
        }
    }

    private void doInsert(final PreparedStatement preparedStatement) throws SQLException {
        for (int i = 1; i <= 64; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setInt(2, i);
            preparedStatement.setInt(3, i);
            preparedStatement.setString(4, String.valueOf(i));
            preparedStatement.setInt(5, 0);
            preparedStatement.setInt(6, 0);
            preparedStatement.setBigDecimal(7, new BigDecimal(i).setScale(2, BigDecimal.ROUND_HALF_UP));
            preparedStatement.setObject(8, new Date());
            preparedStatement.setObject(9, new Date());
            preparedStatement.setInt(10, 0);
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Select all.
     *
     * @return record count
     */
    int selectAll() throws SQLException {
        int result = 0;
        try (Connection connection = this.dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT COUNT(1) AS count FROM t_order");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        }
        return result;
    }
}
