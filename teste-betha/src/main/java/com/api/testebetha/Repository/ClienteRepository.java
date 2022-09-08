package com.api.testebetha.Repository;

import com.api.testebetha.Model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    boolean existsByTelefone(String telefone);

    boolean existsByEmail(String email);

}
