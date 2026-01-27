package es.instituto.orientacion.seguimiento_casos;

import es.instituto.orientacion.seguimiento_casos.entities.Caso;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SeguimientoCasosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguimientoCasosApplication.class, args);
	}

    Scanner sc = new Scanner(System.in);
    String idCaso;
    String programa;
    String paso;
    String subpaso;

    String estado;
    String ubicacionFisica;
    String observacionesNeutras;
    Caso nuevoCaso = new Caso();
}
