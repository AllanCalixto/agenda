package br.com.solvetech.agenda.domain.service;

import br.com.solvetech.agenda.domain.entity.Paciente;
import br.com.solvetech.agenda.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public Paciente salvar(Paciente paciente){
       return pacienteRepository.save(paciente);
    }
    public List<Paciente> listarTodos(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id){
        return pacienteRepository.findById(id);
    }

    public void deletar(Long id){
        pacienteRepository.deleteById(id);
    }
}
