package com.api.testebetha.service;

import com.api.testebetha.Model.EquipamentoModel;
import com.api.testebetha.Repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {
    static EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository){EquipamentoService.equipamentoRepository = equipamentoRepository;}

    @Transactional
    public static EquipamentoModel save(EquipamentoModel equipamentoModel){
        return equipamentoRepository.save(equipamentoModel);
    }

    public List<EquipamentoModel> findAll(){return equipamentoRepository.findAll();}

    public Optional<EquipamentoModel> findById(Long id){
        return equipamentoRepository.findById(id);
    }

    @Transactional
    public void delete(EquipamentoModel equipamentoModel) {equipamentoRepository.delete(equipamentoModel);}
}
