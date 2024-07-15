package ru.deposit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.deposit.data.entity.Bank;
import ru.deposit.data.entity.Deposit;

import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

    @Query(value = "select * from deposit where bank_id = :id", nativeQuery = true)
    List<Deposit> findDepositsByBankId(@Param("id") Long id);

    @Query(value = "select * from deposit where client_id = :id", nativeQuery = true)
    List<Deposit> findDepositsByClient(@Param("id") Long id);

    List<Deposit> findDepositsByPercentBetween(Integer l, Integer h);
}
