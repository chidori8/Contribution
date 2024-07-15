package ru.deposit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.deposit.data.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
