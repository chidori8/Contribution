package ru.deposit.business.services;

import org.springframework.stereotype.Service;
import ru.deposit.data.dto.DepositDTO;
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
                .client(clientService.getClientById(dto.getClientId()))
                .bank(bankService.getBankById(dto.getBankId()))
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

    public List<Deposit> getDepositsByBankId(Long id) {
        return depositRepository.findDepositsByBankId(id);
    }

    public List<Deposit> getDepositsByClientId(Long id) {
        return depositRepository.findDepositsByBankId(id);
    }

    public List<Deposit> getDepositsByPercentBetween(Integer low, Integer high) {
        return depositRepository.findDepositsByPercentBetween(low, high);
    }
}
