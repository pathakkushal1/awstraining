package com.kushal.jwt.jwt.example.repository;

import com.kushal.jwt.jwt.example.exception.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class DBRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    ExceptionHandler exceptionHandler;

    public List<Map<String, Object>> query(final String query, final Map<String, Object> parameters)  {
            try {
                
                return jdbcTemplate.queryForList(query, parameters);
            }
            catch (DataAccessException e) {
               throw e;
            }
            catch (Exception e) {
               throw e;
            }
    }


    public Integer update(final String query, final Map<String, Object> parameters)  {
            try {
                return jdbcTemplate.update(query, parameters);
            }
            catch (DataAccessException e) {
                throw e;
            }
            catch (Exception e) {
                throw e;
            }

    }
}
