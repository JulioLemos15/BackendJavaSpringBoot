package com.api.testebetha.Repository;

import com.api.testebetha.Model.EquipamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoModel, Long> {
}
