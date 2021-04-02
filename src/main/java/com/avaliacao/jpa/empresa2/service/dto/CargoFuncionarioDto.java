package com.avaliacao.jpa.empresa2.service.dto;

public class CargoFuncionarioDto {

    private String nomeFuncioanrio;
    private String cargoFuncioanrio;


    public CargoFuncionarioDto(String nomeFuncioanrio, String cargoFuncioanrio) {
        this.nomeFuncioanrio = nomeFuncioanrio;
        this.cargoFuncioanrio = cargoFuncioanrio;
    }

    public String getNomeFuncioanrio() {
        return nomeFuncioanrio;
    }

    public void setNomeFuncioanrio(String nomeFuncioanrio) {
        this.nomeFuncioanrio = nomeFuncioanrio;
    }

    public String getCargoFuncioanrio() {
        return cargoFuncioanrio;
    }

    public void setCargoFuncioanrio(String cargoFuncioanrio) {
        this.cargoFuncioanrio = cargoFuncioanrio;
    }


    @Override
    public String toString() {
        return "CargoFuncionarioDto{" +
                "nomeFuncioanrio='" + nomeFuncioanrio + '\'' +
                ", cargoFuncioanrio='" + cargoFuncioanrio + '\'' +
                '}';
    }
}
