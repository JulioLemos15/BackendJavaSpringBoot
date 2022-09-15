package com.api.testebetha.Repository;

import com.api.testebetha.Model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

    public EmpresaModel findByEmail(String email);
}
