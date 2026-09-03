public class Curso {
    private String nombreCurso;
    private int nota;

    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
        this.nota = -1; // -1 significa que todavia no tiene nota asignada
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String toString() {
        if (nota == -1) {
            return nombreCurso;
        } else {
            return nombreCurso + " - Nota: " + nota;
        }
    }
}