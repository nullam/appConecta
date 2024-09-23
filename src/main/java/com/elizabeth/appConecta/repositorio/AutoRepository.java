package com.elizabeth.appConecta.repositorio;

import com.elizabeth.appConecta.entidad.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ElySanchez
 */
@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

}
