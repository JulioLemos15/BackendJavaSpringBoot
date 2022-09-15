package com.api.testebetha.service;

import com.api.testebetha.Model.OrdenServicoModel;
import com.api.testebetha.Repository.OrdenServicoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenServicoService {

    static OrdenServicoRepository ordenServicoRepository;

    public OrdenServicoService(OrdenServicoRepository ordenServicoRepository){OrdenServicoService.ordenServicoRepository = ordenServicoRepository;}

    @Transactional
    public static OrdenServicoModel save(OrdenServicoModel ordenServicoModel){
        return ordenServicoRepository.save(ordenServicoModel);
    }

    public List<OrdenServicoModel> findAll(){return ordenServicoRepository.findAll();}

    public Optional<OrdenServicoModel> findById(Long id){
        return ordenServicoRepository.findById(id);
    }

    @Transactional
    public void delete(OrdenServicoModel ordenServicoModel){ordenServicoRepository.delete(ordenServicoModel);}
}
