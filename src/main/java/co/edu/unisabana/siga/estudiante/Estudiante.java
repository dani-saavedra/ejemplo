package co.edu.unisabana.siga.estudiante;

public class Estudiante {

  int codigoEstudiantill;
  String nombre;
  int edad;
  boolean vivo;

  public Estudiante() {
  }

  public Estudiante(int codigoEstudiantill, String nombre, int edad, boolean vivo) {
    this.codigoEstudiantill = codigoEstudiantill;
    this.nombre = nombre;
    this.edad = edad;
    this.vivo = vivo;
  }

  public int getCodigoEstudiantill() {
    return codigoEstudiantill;
  }

  public void setCodigoEstudiantill(int codigoEstudiantill) {
    this.codigoEstudiantill = codigoEstudiantill;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public boolean isVivo() {
    return vivo;
  }

  public void setVivo(boolean vivo) {
    this.vivo = vivo;
  }
}
