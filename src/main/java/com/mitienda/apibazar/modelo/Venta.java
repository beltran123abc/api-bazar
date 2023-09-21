package com.mitienda.apibazar.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private double total;
    @OneToMany
        private List<Producto> listaProductos;

    @OneToOne
    @JoinColumn(name = "un_cliente_id_cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente;

}
