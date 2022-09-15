package com.api.testebetha.Controller;

import com.api.testebetha.Model.EquipamentoModel;
import com.api.testebetha.Controller.dto.EquipamenteoDto;
import com.api.testebetha.service.EquipamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("equipamento")
public class EquipamentoController {
    final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {this.equipamentoService = equipamentoService;}

    @PostMapping("/cadastro")
    public ResponseEntity<Object> saveEquipamento(@RequestBody @Valid EquipamenteoDto equipamenteoDto){
        var equipamentoModel = new EquipamentoModel();
        BeanUtils.copyProperties(equipamenteoDto, equipamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(EquipamentoService.save(equipamentoModel));
    }
    @GetMapping
    public ResponseEntity<List<EquipamentoModel>> getAllEquipamento(){
        return ResponseEntity.status(HttpStatus.OK).body(equipamentoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEquipamento(@PathVariable(value = "id") Long id){
        Optional<EquipamentoModel> equipamentoModelOptional = equipamentoService.findById(id);
        if (!equipamentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipamento não existe");
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipamentoModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEquipamento(@PathVariable(value = "id") Long id){
        Optional<EquipamentoModel> equipamentoModelOptional = equipamentoService.findById(id);
        if (!equipamentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipamento não existe");
        }
        equipamentoService.delete(equipamentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Equipamento excluido com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEquipamento(@PathVariable(value = "id") Long id, @RequestBody @Valid EquipamenteoDto equipamenteoDto){
        Optional<EquipamentoModel> equipamentoModelOptional = equipamentoService.findById(id);
        if (!equipamentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipamento não existe");
        }
        var equipamentoModel = new EquipamentoModel();
        BeanUtils.copyProperties(equipamenteoDto, equipamentoModel);
        equipamentoModel.setId(equipamentoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(equipamentoService.save(equipamentoModel));
    }
}
