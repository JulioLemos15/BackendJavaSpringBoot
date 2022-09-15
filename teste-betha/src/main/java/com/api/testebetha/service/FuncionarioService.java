package com.api.testebetha.service;

import com.api.testebetha.Model.FuncionarioModel;
import com.api.testebetha.Repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    static FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){FuncionarioService.funcionarioRepository = funcionarioRepository;}

    @Transactional
    public static FuncionarioModel save(FuncionarioModel funcionarioModel){
        return funcionarioRepository.save(funcionarioModel);
    }

    public List<FuncionarioModel> findAll(){return funcionarioRepository.findAll();}

    public Optional<FuncionarioModel> findById(Long id){
        return funcionarioRepository.findById(id);
    }

    @Transactional
    public void delete(FuncionarioModel funcionarioModel){funcionarioRepository.delete(funcionarioModel);}
}
