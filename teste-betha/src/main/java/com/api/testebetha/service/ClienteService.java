package com.api.testebetha.service;

import com.api.testebetha.Model.ClienteModel;
import com.api.testebetha.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
    public class ClienteService {

    static ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        ClienteService.clienteRepository = clienteRepository;
    }
    @Transactional //para metodos construtivos ou destrutivos, pq caso algo de errado ele garante q tudo volte ao normal para não ter dados quebrados.
    public static ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel); //Metodoso save pega nosso repositorio jpa de repository, e salva na nossa entidade clienteModel.
    }

        public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
        }

    public Optional<ClienteModel> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public void delete(ClienteModel clienteModel) {
        clienteRepository.delete(clienteModel);
    }

        public boolean existsByTelefone(String telefone) {
        return clienteRepository.existsByTelefone(telefone);
        }

        public boolean existsByEmail(String email) {
        return clienteRepository.existsByEmail(email);
        }

    }
