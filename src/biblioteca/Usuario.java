package biblioteca;

public class Usuario {

    public String nombre;

    protected String ID;

    public int edad;

    public Usuario(String nombre, String ID, int edad) {
        this.nombre = nombre;
        this.ID = ID;
        this.edad = edad;
    }

    public void leerLibro(Libro libro) {
        if (libro.isDisponible()) {
            System.out.println("  " + nombre + " está leyendo: \"" + libro.autor + "\" (ID: " + libro.ID + ")");
        } else {
            System.out.println("  El libro " + libro.ID + " no está disponible actualmente.");
        }
    }

    public void solicitarLibro(Libro libro) {
        if (libro.isDisponible()) {
            System.out.println("  " + nombre + " ha solicitado el libro: " + libro.ID);
        } else {
            System.out.println("  El libro " + libro.ID + " no está disponible para solicitud.");
        }
    }

    public void consultarLibro(Libro libro) {
        System.out.println("  [CONSULTA] " + libro.toString());
    }

    public void devolucionDeLibro(Libro libro) {
        libro.setDisponible(true);
        System.out.println("  " + nombre + " devolvió el libro: " + libro.ID + " → Ahora disponible.");
    }


    public void verificacionDeUsuario() {
        System.out.println("  [VERIFICADO] " + nombre + " | ID: " + ID + " | Edad: " + edad);
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Usuario[Nombre=" + nombre + ", ID=" + ID + ", Edad=" + edad + "]";
    }
}
