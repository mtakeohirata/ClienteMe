package clienteMe.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clienteMe.model.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

}
