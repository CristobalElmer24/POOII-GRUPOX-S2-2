import java.util.Random;

public class Docente extends Persona {
    private String cursoDocente;
    private String facultadDocente;

    public Docente(String dni, String nombre, String apellido, String cursoDocente, String facultadDocente) {
        super(dni, nombre, apellido);
        this.cursoDocente = cursoDocente;
        this.facultadDocente = facultadDocente;
    }

   
    public void calificarCurso(Curso curso) {
        Random random = new Random();
        int nota = random.nextInt(21); 
        curso.setNota(nota);
        System.out.println("El docente " + this.nombre + " califico el curso " + curso.getNombreCurso() + " con nota " + nota);
    }

    public String getCursoDocente() {
        return cursoDocente;
    }

    public String getFacultadDocente() {
        return facultadDocente;
    }
}
