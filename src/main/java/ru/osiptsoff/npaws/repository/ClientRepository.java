package ru.osiptsoff.npaws.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.osiptsoff.npaws.model.subject.Client;

@Repository
public interface ClientRepository extends
        CrudRepository<Client, UUID>,
        PagingAndSortingRepository<Client, UUID> {

        @Query(value = "select c from Client c where c.name != 'admin'")
        Page<Client> findAll(Pageable pageable);
    
}
