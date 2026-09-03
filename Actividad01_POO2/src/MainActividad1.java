import java.util.ArrayList;
import java.util.List;

public class MainActividad1 {
    public static void main(String[] args) {
        List<Curso> listaCursos = new ArrayList<Curso>();

        // Al crear el alumno, el constructor lee automaticamente
        // el archivo cursosAlumnos.txt y llena su lista de cursos
        Alumno alumno1 = new Alumno("2023100", "Juan Perez", listaCursos);
        alumno1.mostrarCursos();

        System.out.println();

        Docente docente1 = new Docente("12345678", "Maria", "Lopez", "Programacion II", "Ingenieria");
        for (int i = 0; i < alumno1.getListaCursos().size(); i++) {
            docente1.calificarCurso(alumno1.getListaCursos().get(i));
        }

        System.out.println();
        alumno1.mostrarCursos();
    }
}
