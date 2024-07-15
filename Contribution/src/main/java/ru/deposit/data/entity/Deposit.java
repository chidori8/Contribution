package ru.deposit.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "deposit_id_seq")
    @SequenceGenerator(name = "deposit_id_seq", sequenceName = "deposit_id_seq", allocationSize = 1)
    private Long id;

    private Timestamp opening_date;

    private Integer percent;

    private Integer period_in_month;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank_id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client_id;

}
