package com.mitienda.apibazar.repository;

import com.mitienda.apibazar.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {

}
