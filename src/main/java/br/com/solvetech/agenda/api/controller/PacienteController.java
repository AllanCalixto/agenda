package br.com.solvetech.agenda.api.controller;

import br.com.solvetech.agenda.domain.entity.Paciente;
import br.com.solvetech.agenda.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService pacienteService;
    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente){
        Paciente p = pacienteService.salvar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos(){
        List<Paciente> pacientes = pacienteService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id){
        Optional<Paciente> optPaciente = pacienteService.buscarPorId(id);
        if (optPaciente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Paciente paciente = optPaciente.get();
        return ResponseEntity.status(HttpStatus.OK).body(optPaciente.get());
    }
}
