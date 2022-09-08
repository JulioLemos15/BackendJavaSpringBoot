package com.api.testebetha.Repository;

import com.api.testebetha.Model.OrdenServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenServicoRepository extends JpaRepository<OrdenServicoModel, Long>{
}
