package biblioteca;

public class UsuarioMenor extends Usuario {

    public String asociacionUsuarioMayorRegular;

    private Usuario tutor;

    public UsuarioMenor(String nombre, String ID, int edad) {
        super(nombre, ID, edad);
        this.tutor = null;
    }

    public void setTutor(Usuario tutor) {
        this.tutor = tutor;
        this.asociacionUsuarioMayorRegular = tutor.getID();
        System.out.println("  Tutor asignado a " + nombre + ": " + tutor.nombre + " (ID: " + tutor.getID() + ")");
    }

    public Usuario getTutor() {
        return tutor;
    }

    @Override
    public void solicitarLibro(Libro libro) {

        if (tutor == null) {
            System.out.println("  [DENEGADO] " + nombre + " no puede solicitar libros sin tutor asignado.");
            return;
        }
        if (!libro.isDisponible()) {
            System.out.println("  El libro " + libro.ID + " no está disponible.");
            return;
        }
        System.out.println("  " + nombre + " (menor) solicitó: " + libro.ID 
                         + " | Autorizado por: " + tutor.nombre);
    }

    @Override
    public String toString() {
        String tutorInfo = (tutor != null) ? tutor.nombre : "Sin tutor";
        return "UsuarioMenor[Nombre=" + nombre + ", ID=" + ID + ", Tutor=" + tutorInfo + "]";
    }
}
