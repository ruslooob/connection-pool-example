package com.ruslooob.connectionpoolexample;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Repository
@AllArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BalanceRepository {
    NamedParameterJdbcTemplate jdbcTemplate;

    @Transactional
    public void createUser(String userName) {
        sleep(10);
        jdbcTemplate.update("INSERT into balances(name, balance) values (:name, 0)",
                Map.of("name", userName));
    }

    @Transactional
    public void addMoney(Long userId, int moneyToAad) {
        sleep(10);
        jdbcTemplate.update("UPDATE balances set balance = balance + :addMoney where id = :id",
                Map.of("id", userId, "addMoney", moneyToAad));
    }

    @SneakyThrows
    private void sleep(int millis) {
        Thread.sleep(millis);
    }
}
