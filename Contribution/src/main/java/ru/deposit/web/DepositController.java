package ru.deposit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.deposit.business.services.DepositService;
import ru.deposit.data.dto.ClientDTO;
import ru.deposit.data.dto.DepositDTO;
import ru.deposit.data.entity.Client;
import ru.deposit.data.entity.Deposit;

import java.util.List;

@RestController
@RequestMapping("contribution/deposit")
public class DepositController {

    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/create")
    public ResponseEntity<Deposit> createClient(@RequestBody DepositDTO dto) {
        return new ResponseEntity<>(depositService.createDeposit(dto), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Deposit>> getAll() {
        return new ResponseEntity<>(depositService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Deposit> update(@RequestBody Deposit deposit) {
        return new ResponseEntity<>(depositService.update(deposit), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        depositService.delete(id);
        return HttpStatus.OK;
    }
}
