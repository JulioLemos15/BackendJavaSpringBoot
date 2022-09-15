package com.api.testebetha.Controller;

import com.api.testebetha.Model.ClienteModel;
import com.api.testebetha.Controller.dto.ClienteDto;
import com.api.testebetha.Model.EmpresaModel;
import com.api.testebetha.Repository.EmpresaRepository;
import com.api.testebetha.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cliente")
public class ClienteController {
    final ClienteService clienteService;
    final EmpresaRepository empresaRepository;

    public ClienteController(ClienteService clienteService, EmpresaRepository empresaRepository) {
        this.clienteService = clienteService;
        this.empresaRepository = empresaRepository;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDto clienteDto){ // ResponseEntity vai montar uma resposta tanto com o status quanto o corpo da resposta e o Object porque pode ter outros tipos de retorno dependendo das verificações
        Optional<EmpresaModel> empresaModel = empresaRepository.findById(clienteDto.getEmpresa());
        //@Valid para validar as validaçoes notblank do nosso DTO
        if (clienteService.existsByTelefone(clienteDto.getTelefone())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este numero de telefone Já existe");
        }
        if (clienteService.existsByEmail(clienteDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este email Já existe");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel); //converte o Dto em Model, estamos recependo DTO mas salva no nosso Model.
        clienteModel.setDh_criacao(LocalDateTime.now());
        clienteModel.setEmpresa(empresaModel.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteService.save(clienteModel));
        //Controi como retorno a resposta, responseEntity.status, on    de é passado o statusHttpCreate, e no body o retorno do metodo save para salvar no banco de dados.
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> getAllCliente(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") Long id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Long id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe");
        }
        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") Long id, @RequestBody @Valid ClienteDto clienteDto){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteModel.setId(clienteModelOptional.get().getId());
        clienteModel.setDh_criacao(clienteModelOptional.get().getDh_criacao());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }


}
