package ru.deposit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.deposit.business.services.ClientService;
import ru.deposit.data.dto.BankDTO;
import ru.deposit.data.dto.ClientDTO;
import ru.deposit.data.entity.Bank;
import ru.deposit.data.entity.Client;

import java.util.List;

@RestController
@RequestMapping("contribution/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO dto) {
        return new ResponseEntity<>(clientService.createClient(dto), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> update(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        clientService.delete(id);
        return HttpStatus.OK;
    }

}
