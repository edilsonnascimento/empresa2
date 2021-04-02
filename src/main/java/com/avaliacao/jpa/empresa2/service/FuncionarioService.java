package com.avaliacao.jpa.empresa2.service;

import com.avaliacao.jpa.empresa2.entity.Cargo;
import com.avaliacao.jpa.empresa2.entity.Funcionario;
import com.avaliacao.jpa.empresa2.repository.CargoRepository;
import com.avaliacao.jpa.empresa2.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private CargoService cargoService;

    public void salvar(Funcionario funcionario, Cargo cargo){
        cargoRepository.save(cargo);
        funcionario.setCargo(cargo);
        funcionarioRepository.save(funcionario);
    }


    public void excluir(Long idFuncionario){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(idFuncionario);
        if(funcionarioOptional.isPresent()){
            Funcionario funcionario = funcionarioOptional.get();
            funcionario.setCargo(null);
            funcionarioRepository.save(funcionario);
            funcionarioRepository.delete(funcionario);
        }
    }

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> listarTodosNomes(){
        return funcionarioRepository.findAllByOrderByNome();
    }

    public Integer totalFuncionarios(){
        return funcionarioRepository.countTodosFuncionarios();
    }

}
