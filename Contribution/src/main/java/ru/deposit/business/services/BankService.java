package ru.deposit.business.services;

import org.springframework.stereotype.Service;
import ru.deposit.data.dto.BankDTO;
import ru.deposit.data.entity.Bank;
import ru.deposit.data.repository.BankRepository;

import java.util.List;

@Service
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank createBank(BankDTO dto) {
        Bank bank = Bank.builder()
                .name(dto.getName())
                .bank_id_code(dto.getBankIdCode())
                .build();
        return bankRepository.save(bank);
    }

    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    public Bank update(Bank bank) {
        return bankRepository.save(bank);
    }

    public void delete(Long id) {
        bankRepository.deleteById(id);
    }

    public Bank getBankById(Long id) {
        return bankRepository.findById(id).get();
    }



}
