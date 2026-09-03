import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Alumno extends Persona {
    private String codigoAlumno;
    private List<Curso> listaCursos;

    public Alumno(String codigo, String nombre, List<Curso> listaCursos){
        super(nombre);
        this.codigoAlumno = codigo;
        this.listaCursos = listaCursos;        
        this.leeCursosAlumno("cursosAlumnos.txt");
    }


    public void leeCursosAlumno(String archivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    Curso c = new Curso(linea.trim());
                    listaCursos.add(c);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de cursos: " + e.getMessage());
        }
    }

    public void mostrarCursos() {
        System.out.println("Cursos en los que el alumno " + this.nombre + " esta matriculado:");
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println("- " + listaCursos.get(i));
        }
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }
}
