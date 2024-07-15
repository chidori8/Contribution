package ru.deposit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.deposit.data.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
