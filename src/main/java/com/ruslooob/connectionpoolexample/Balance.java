package com.ruslooob.connectionpoolexample;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Balance {
    Long id;
    final String name;
    final Long balance;
}
