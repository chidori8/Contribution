package ru.deposit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.deposit.business.services.BankService;
import ru.deposit.data.dto.BankDTO;
import ru.deposit.data.entity.Bank;

import java.util.List;

@RestController
@RequestMapping("contribution/bank")
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/create")
    public ResponseEntity<Bank> createBank(@RequestBody BankDTO dto) {
        return new ResponseEntity<>(bankService.createBank(dto), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Bank>> getAll() {
        return new ResponseEntity<>(bankService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Bank> update(@RequestBody Bank bank) {
        return new ResponseEntity<>(bankService.update(bank), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        bankService.delete(id);
        return HttpStatus.OK;
    }
}
