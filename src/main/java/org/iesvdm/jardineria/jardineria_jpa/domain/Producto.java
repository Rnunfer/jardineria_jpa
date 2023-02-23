package org.iesvdm.jardineria.jardineria_jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_producto;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_GAMA"))
    @JsonIgnore
    @ToString.Exclude
    private Gama gama;

    private String dimensiones;

    private String proveedor;

    private String descripcion;

    private int cantidad_en_stock;

    private BigDecimal precio_venta;

    private BigDecimal precio_proveedor;
}
