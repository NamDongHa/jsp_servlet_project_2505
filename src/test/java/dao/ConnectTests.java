package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTests {
    @Test
    public void testHikariCP (){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/parking");
        config.setUsername("root");
        config.setPassword("9644");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        try (Connection connection = ds.getConnection()){
            System.out.println("Connection 성공 " + connection);
            Assertions.assertNotNull(connection); //변수가 null인지 아닌지 확인 => null이 아니면 객체를 참조하고 있음
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
