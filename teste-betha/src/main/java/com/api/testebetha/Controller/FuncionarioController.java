package com.api.testebetha.Controller;

import com.api.testebetha.Model.FuncionarioModel;
import com.api.testebetha.Controller.dto.FuncionarioDto;
import com.api.testebetha.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {

    final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService){this.funcionarioService = funcionarioService;}

    @PostMapping("cadastro")
    public ResponseEntity<Object> saveFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto){
        var funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);
        funcionarioModel.setDh_criacao(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(FuncionarioService.save(funcionarioModel));
    }
    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> getAllFuncionario(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFuncionario(@PathVariable(value = "id") Long id){
        Optional<FuncionarioModel> funcionarioModelOptional = funcionarioService.findById(id);
        if (!funcionarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não existe");
        }
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFuncionario(@PathVariable(value = "id") Long id){
        Optional<FuncionarioModel> funcionarioModelOptional = funcionarioService.findById(id);
        if (!funcionarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não existe");
        }
        funcionarioService.delete(funcionarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Funcionário excluido com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFuncionario(@PathVariable(value = "id") Long id, @RequestBody @Valid FuncionarioDto funcionarioDto){
        Optional<FuncionarioModel> funcionarioModelOptional = funcionarioService.findById(id);
        if (!funcionarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não existe");
        }
        var funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);
        funcionarioModel.setId(funcionarioModelOptional.get().getId());
        funcionarioModel.setDh_criacao(funcionarioModelOptional.get().getDh_criacao());
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionarioModel));
    }
}
