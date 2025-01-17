package com.elaparato.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_seq")
    @SequenceGenerator(name = "venta_seq", sequenceName = "venta_seq", allocationSize = 1)
    private int id_venta;

    private Date fecha;
    //@OneToMany(mappedBy="venta")
    @ManyToMany (mappedBy = "listaVentas")
    private List<Producto> listaProductos;



}
