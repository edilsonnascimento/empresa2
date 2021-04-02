package com.avaliacao.jpa.empresa2.service;

import com.avaliacao.jpa.empresa2.entity.Cargo;
import com.avaliacao.jpa.empresa2.repository.CargoRepository;
import com.avaliacao.jpa.empresa2.service.dto.CargoFuncionarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    public List<Cargo> listarTodos(){
        return cargoRepository.findAll();
    }

    public void salvar(Cargo cargo){
        cargoRepository.save(cargo);
    }

    public void excluir(Long idCargo){
        Optional<Cargo> cargoOptional = cargoRepository.findById(idCargo);
        if(cargoOptional.isPresent()){
            Cargo cargo = cargoOptional.get();
            funcionarioService.excluir(cargo.getFuncionario().getId());
            cargoRepository.deleteById(idCargo);
        }
    }

    public List<CargoFuncionarioDto> todosCargosFuncionarios(){
        List<CargoFuncionarioDto> cargosFuncioanrios = new ArrayList<>();
        List<Cargo> cargos = this.listarTodos();
        if(cargos != null) {
            cargosFuncioanrios = cargos.stream()
                    .map(cargo -> new CargoFuncionarioDto(cargo.getFuncionario().getNome(), cargo.getNomeCargo()))
                    .collect(Collectors.toList());
        }
        return cargosFuncioanrios;
    }
}
