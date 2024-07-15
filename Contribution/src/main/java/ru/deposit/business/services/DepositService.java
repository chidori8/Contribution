package ru.deposit.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.deposit.data.dto.ClientDTO;
import ru.deposit.data.dto.DepositDTO;
import ru.deposit.data.entity.Client;
import ru.deposit.data.entity.Deposit;
import ru.deposit.data.repository.DepositRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DepositService {

    private final DepositRepository depositRepository;
    private final ClientService clientService;
    private final BankService bankService;

    public DepositService(DepositRepository depositRepository, BankService bankService, ClientService clientService) {
        this.depositRepository = depositRepository;
        this.bankService = bankService;
        this.clientService = clientService;
    }

    public Deposit createDeposit(DepositDTO dto) {
        Deposit deposit = Deposit.builder()
                .period_in_month(dto.getPeriod_in_month())
                .opening_date(new Timestamp(System.currentTimeMillis()))
                .percent(dto.getPercent())
                .client_id(clientService.getClientById(dto.getClientId()))
                .bank_id(bankService.getBankById(dto.getBankId()))
                .build();
        return depositRepository.save(deposit);
    }

    public List<Deposit> getAll() {
        return depositRepository.findAll();
    }

    public Deposit update(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    public void delete(Long id) {
        depositRepository.deleteById(id);
    }
}
