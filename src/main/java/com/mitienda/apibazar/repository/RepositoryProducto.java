package com.mitienda.apibazar.repository;

import com.mitienda.apibazar.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryProducto extends JpaRepository<Producto, Long> {
    List<Producto> findBycantidaddisponibleLessThan(int cantidad);
}
