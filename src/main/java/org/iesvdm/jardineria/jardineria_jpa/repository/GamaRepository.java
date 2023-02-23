package org.iesvdm.jardineria.jardineria_jpa.repository;

import org.iesvdm.jardineria.jardineria_jpa.domain.Gama;
import org.iesvdm.jardineria.jardineria_jpa.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamaRepository extends JpaRepository<Gama, Long> {
}
