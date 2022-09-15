package com.api.testebetha.Controller;

import com.api.testebetha.Model.OrdenServicoModel;
import com.api.testebetha.Controller.dto.OrdenServicoDto;
import com.api.testebetha.service.OrdenServicoService;
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
@RequestMapping("/ods")
public class OrdenServicoController {
     final OrdenServicoService ordenServicoService;

     public OrdenServicoController(OrdenServicoService ordenServicoService){this.ordenServicoService = ordenServicoService;}

    @PostMapping("/cadastroOds")
    public ResponseEntity<Object> saveOds(@RequestBody @Valid OrdenServicoDto ordenServicoDto){
         var ordenServicoModel = new OrdenServicoModel();
        BeanUtils.copyProperties(ordenServicoDto, ordenServicoModel);
        ordenServicoModel.setData_inicio(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(OrdenServicoService.save(ordenServicoModel));
    }

    @GetMapping
    public ResponseEntity<List<OrdenServicoModel>> getAllOrdenServico(){
         return ResponseEntity.status(HttpStatus.OK).body(ordenServicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneOrdenServico(@PathVariable(value = "id")Long id) {
        Optional<OrdenServicoModel> ordenServicoModelOptional = ordenServicoService.findById(id);
            if (!ordenServicoModelOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Essa ordem de serviço não existe");
            }
            return ResponseEntity.status(HttpStatus.OK).body(ordenServicoModelOptional.get());
        }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrdenServico(@PathVariable(value = "id") Long id){
         Optional<OrdenServicoModel> ordenServicoModelOptional = ordenServicoService.findById(id);
         if (!ordenServicoModelOptional.isPresent()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Essa ordem de serviço não existe");
         }
         ordenServicoService.delete(ordenServicoModelOptional.get());
         return ResponseEntity.status(HttpStatus.OK).body("Ordem de serviço excluida com sucesso!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOrdenServico(@PathVariable(value = "id") Long id, @RequestBody @Valid OrdenServicoDto ordenServicoDto){
         Optional<OrdenServicoModel> ordenServicoModelOptional = ordenServicoService.findById(id);
         if (!ordenServicoModelOptional.isPresent()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Essa ordem de serviço não existe");
         }
         var ordenServicoModel = new OrdenServicoModel();
         BeanUtils.copyProperties(ordenServicoDto, ordenServicoModel);
         ordenServicoModel.setId(ordenServicoModelOptional.get().getId());
         ordenServicoModel.setData_inicio(ordenServicoModelOptional.get().getData_inicio());
         return ResponseEntity.status(HttpStatus.OK).body(ordenServicoService.save(ordenServicoModel));
    }

    }
