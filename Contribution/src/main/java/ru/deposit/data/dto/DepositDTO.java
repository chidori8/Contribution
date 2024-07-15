package ru.deposit.data.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DepositDTO {

//    private Timestamp opening_date;
    private Integer percent;
    private Integer period_in_month;
    private Long bankId;
    private Long clientId;
}
