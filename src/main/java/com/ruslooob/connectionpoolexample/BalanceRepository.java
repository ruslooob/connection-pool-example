package com.ruslooob.connectionpoolexample;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@AllArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BalanceRepository {
    NamedParameterJdbcTemplate jdbcTemplate;

    public void createUser(String userName) {
        jdbcTemplate.update("INSERT into balances(name, balance) values (:name, 0)",
                Map.of("name", userName));
    }

    public void addMoney(Long userId, int moneyToAad) {
        jdbcTemplate.update("UPDATE balances set balance = balance + :addMoney where id = :id",
                Map.of("id", userId, "addMoney", moneyToAad));
    }
}
