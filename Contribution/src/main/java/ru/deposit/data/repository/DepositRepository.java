package ru.deposit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.deposit.data.entity.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
