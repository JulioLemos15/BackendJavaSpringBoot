package com.api.testebetha.Controller;

import com.api.testebetha.Controller.dto.EmpresaWithTokenDto;
import com.api.testebetha.Model.EmpresaModel;
import com.api.testebetha.security.Token;
import com.api.testebetha.service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empresa")
public class EmpresaController {
    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<EmpresaModel>> listaEmpresa() {
        return ResponseEntity.status(200).body(empresaService.listaEmpresa());
    }

    @PostMapping("/criar")
    public ResponseEntity<EmpresaModel> criarEmpresa(@RequestBody EmpresaModel empresaModel){
        return ResponseEntity.status(201).body(empresaService.criarEmpresa(empresaModel));
    }

    @PutMapping("/criar")
    public ResponseEntity<EmpresaModel> editarEmpresa(@RequestBody EmpresaModel empresaModel){
        return ResponseEntity.status(201).body(empresaService.editarEmpresa(empresaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEmpresa(@PathVariable Long id){
        empresaService.excluirEmpresa(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<EmpresaWithTokenDto> logar(@RequestBody EmpresaModel empresaModel){
        EmpresaWithTokenDto empresaWithTokenDto = empresaService.gerarToken(empresaModel);
        if (empresaWithTokenDto != null){
            return ResponseEntity.ok(empresaWithTokenDto);
        }
        return ResponseEntity.status(403).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
