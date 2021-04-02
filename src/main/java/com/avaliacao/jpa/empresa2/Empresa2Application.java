package com.avaliacao.jpa.empresa2;

import com.avaliacao.jpa.empresa2.entity.Cargo;
import com.avaliacao.jpa.empresa2.entity.Funcionario;
import com.avaliacao.jpa.empresa2.service.CargoService;
import com.avaliacao.jpa.empresa2.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Empresa2Application {

    private static final Logger log = LoggerFactory.getLogger(Empresa2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Empresa2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(FuncionarioService funcionarioService, CargoService cargoService){

        return (args) -> {
            Cargo cargo1 = new Cargo();
            cargo1.setId(1L);
            cargo1.setNomeCargo("Gerente");
            cargoService.salvar(cargo1);

            Cargo cargo2 = new Cargo();
            cargo2.setId(2L);
            cargo2.setNomeCargo("Encarregado");
            cargoService.salvar(cargo2);

            Cargo cargo3 = new Cargo();
            cargo3.setId(3L);
            cargo3.setNomeCargo("Analista");
            cargoService.salvar(cargo3);

            log.info("Cargos savo com sucesso!");

            Funcionario funcionario1 = new Funcionario();
            funcionario1.setId(1L);
            funcionario1.setNome("Gandalf o Cinzento");
            funcionario1.setSexo("Masculino");
            funcionario1.setTelefone("(041) 9.9978-7845");
            funcionario1.setCargo(cargo1);
            funcionarioService.salvar(funcionario1, cargo1);

            Funcionario funcionario2 = new Funcionario();
            funcionario2.setId(2L);
            funcionario2.setNome("Frodo Bolseiro");
            funcionario2.setSexo("Masculino");
            funcionario2.setTelefone("(041) 9.9978-7885");
            funcionario2.setCargo(cargo2);
            funcionarioService.salvar(funcionario2, cargo2);

            Funcionario funcionario3 = new Funcionario();
            funcionario3.setId(3L);
            funcionario3.setNome("Galdriel");
            funcionario3.setSexo("Feminino");
            funcionario3.setTelefone("(041) 9.9978-7812");
            funcionario3.setCargo(cargo3);
            funcionarioService.salvar(funcionario3, cargo3);

            log.info("3 Funcionarios inseridos com sucesso!");

            cargoService.excluir(1l);
           log.info("Cargo 1 excluído");

            funcionarioService.excluir(1l);
            log.info("Excluido funcionario 1");

            funcionarioService.listarTodos().parallelStream().forEach(System.out::println);
            log.info("Lista de Funcionarios com seus cargos.");

            cargoService.todosCargosFuncionarios().parallelStream().forEach(System.out::println);
            log.info("Lista de Cargos com seus Funcionarios.");

            funcionarioService.listarTodosNomes().parallelStream().forEach(System.out::println);
            log.info("Lista de Funcioanrios em ordem alfabetica");

            System.out.println("Total de Funcioonários: " + funcionarioService.totalFuncionarios());

        };
    }
}
