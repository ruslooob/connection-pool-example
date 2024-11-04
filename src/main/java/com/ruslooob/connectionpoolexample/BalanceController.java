package com.ruslooob.connectionpoolexample;

import com.ruslooob.connectionpoolexample.request.AddMoneyRequest;
import com.ruslooob.connectionpoolexample.request.CreateUserRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BalanceController {
    BalanceRepository repository;

    @PostMapping("/create-user")
    public void creteUser(@RequestBody CreateUserRequest request) {
        repository.createUser(request.name());

    }

    @PostMapping("/add-money")
    public void addMoney(@RequestBody AddMoneyRequest request) {
        repository.addMoney(request.userId(), request.moneysToAdd());
    }

}
