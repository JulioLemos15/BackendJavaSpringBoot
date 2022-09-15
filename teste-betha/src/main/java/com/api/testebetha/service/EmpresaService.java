package com.api.testebetha.service;

import com.api.testebetha.Controller.dto.EmpresaWithTokenDto;
import com.api.testebetha.Model.EmpresaModel;
import com.api.testebetha.Repository.EmpresaRepository;
import com.api.testebetha.security.Token;
import com.api.testebetha.security.TokenUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;



@Service

public class EmpresaService<empresaDto> {
    private EmpresaRepository empresaRepository;
    private PasswordEncoder passwordEncoder;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<EmpresaModel> listaEmpresa() {
        List<EmpresaModel> lista = empresaRepository.findAll();
        return lista;
    }

    public EmpresaModel criarEmpresa(EmpresaModel empresaModel) {
        String encoder = this.passwordEncoder.encode(empresaModel.getSenha());
        empresaModel.setSenha(encoder);
        EmpresaModel empresaNovo = empresaRepository.save(empresaModel);
        return empresaNovo;
    }

    public EmpresaModel editarEmpresa(EmpresaModel empresaModel) {
        String encoder = this.passwordEncoder.encode(empresaModel.getSenha());
        empresaModel.setSenha(encoder);
        EmpresaModel empresaNovo = empresaRepository.save(empresaModel);
        return empresaNovo;
    }

    public Boolean excluirEmpresa(Long id) {
        empresaRepository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(EmpresaModel empresaModel) {
        String senha = empresaRepository.getReferenceById(empresaModel.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(empresaModel.getSenha(), senha);
        return valid;
    }

    public EmpresaWithTokenDto gerarToken(@Valid EmpresaModel empresaModel) {
        EmpresaModel empresa = empresaRepository.findByEmail(empresaModel.getEmail());
        if (empresa != null) {
            Boolean valid = passwordEncoder.matches(empresaModel.getSenha(), empresa.getSenha());
            if (valid){
                Token token = new Token(TokenUtil.createToken(empresa));
                return new EmpresaWithTokenDto(empresa.getId(), empresa.getEmail(), token.getToken());
            }
        }
        return null;
    }
}
