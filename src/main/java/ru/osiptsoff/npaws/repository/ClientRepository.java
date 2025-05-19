package ru.osiptsoff.npaws.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.osiptsoff.npaws.model.subject.Client;

@Repository
public interface ClientRepository extends
        CrudRepository<Client, UUID>,
        PagingAndSortingRepository<Client, UUID> {
    
}
