package co.edu.unisabana.siga.estudiante;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimerControlador {

  List<Estudiante> listEstudiante = new ArrayList<>();

  //Los datos que va a tener el consctructor es para simular la data que esta en la base de datos
  public PrimerControlador() {
    listEstudiante.add(new Estudiante(1, "Eduen", 20, true));
    listEstudiante.add(new Estudiante(2, "Daniel", 32, true));
    listEstudiante.add(new Estudiante(3, "Daniela", 20, false));
    listEstudiante.add(new Estudiante(4, "David", 20, true));
  }

  @GetMapping(path = "/estudiante/{id}")
  public Estudiante buscarEstudiantePorId(@PathVariable int id) {
    for (Estudiante estudiante : listEstudiante) {
      if (estudiante.codigoEstudiantill == id) {
        return estudiante;
      }
    }
    return null;
  }


  @GetMapping(path = "/estudiante")
  public List<Estudiante> filtrarEstudiantePorNombre(@RequestParam String nombre,
      @RequestParam int limite) {
    List<Estudiante> filtro = new ArrayList<>();
    for (Estudiante estudiante : listEstudiante) {
      if (estudiante.nombre.contains(nombre) && filtro.size() < limite) {
        filtro.add(estudiante);
      }
    }
    return filtro;
  }

  //contestarle a pinilla

  @PostMapping(path = "/estudiante/agregar")
  public Respuesta agregarEstudiante(@RequestBody Estudiante estudiante) {
    listEstudiante.add(estudiante);
    return new Respuesta("Ok");
  }

  @PutMapping(path = "/estudiante/revivir/{id}")
  public Respuesta revivirEstudiante(@PathVariable int id) {
    for (Estudiante estudiante : listEstudiante) {
      if (estudiante.codigoEstudiantill == id && !estudiante.vivo) {
        estudiante.vivo = true;
        return new Respuesta("Revivivdo");
      } else {
        return new Respuesta("Imposible revivir ,ya esta vivo");
      }
    }
  return null;
  }


  @GetMapping(path = "/saludame")
  public String saludar() {
    return "Hola Mundo, desde la maquina de daniel";
  }

  @GetMapping(path = "/saludame/conestilo")
  public String saludar2() {
    throw new NullPointerException();

  }

  @GetMapping(path = "/suma")
  public String sumar(@RequestParam int num1, @RequestParam int num2) {
    return "Resultado" + (num1 + num2);
  }
}
