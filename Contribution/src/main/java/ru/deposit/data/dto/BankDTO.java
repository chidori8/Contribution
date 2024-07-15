package ru.deposit.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankDTO {

    private Integer bankIdCode;
    private String name;

}
