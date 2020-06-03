package com.kushal.jwt.jwt.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushal.jwt.jwt.example.config.GetSecretAWS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //System.out.println(GetSecretAWS.getSecret());
    }

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() throws SQLException, JsonProcessingException {
        String secret  = GetSecretAWS.getSecret();
        Map<String, Object> response = new ObjectMapper().readValue(secret, HashMap.class);
        DataSource dataSource = new AbstractDriverBasedDataSource() {
            @Override
            protected Connection getConnectionFromDriver(Properties properties) throws SQLException {
                Connection con = null;
                try {
                    if (con == null || con.isClosed()) {
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://"+response.get("host").toString()+":3306/maankibaat"
                                ,response.get("username").toString()
                                , response.get("password").toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return con;
            }
        };

        return new NamedParameterJdbcTemplate(dataSource);

    }

    public DataSourceAutoConfiguration getDataSourceAutoConfiguration(){
        return new DataSourceAutoConfiguration();
    }


}
