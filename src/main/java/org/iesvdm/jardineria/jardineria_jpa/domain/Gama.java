package org.iesvdm.jardineria.jardineria_jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "gama")
@EqualsAndHashCode(of = "gama")
public class Gama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gama;

    private String descripcion_texto;

    private String descripcion_html;

    private String imagen;

    @OneToMany(mappedBy = "gama", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Producto> productos = new HashSet<>();
}
