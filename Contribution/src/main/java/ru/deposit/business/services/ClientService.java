package ru.deposit.business.services;

import org.springframework.stereotype.Service;
import ru.deposit.data.dto.ClientDTO;
import ru.deposit.data.entity.Client;
import ru.deposit.data.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(ClientDTO dto) {
        Client client = Client.builder()
                .name(dto.getName())
                .short_name(dto.getShortName())
                .curr_organizational_form(dto.getOrganizationalForm())
                .build();
        return clientRepository.save(client);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }
}
