package ru.osiptsoff.npaws.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.osiptsoff.npaws.dto.ClientDto;
import ru.osiptsoff.npaws.model.subject.Client;
import ru.osiptsoff.npaws.service.ClientService;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController extends AbstractPagedCrudController<Client, ClientDto> {

    protected ClientController(ClientService clientService) {
        super(clientService, clientService);
    }
    
}
