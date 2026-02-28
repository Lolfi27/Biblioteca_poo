package biblioteca;

public class Prestamo {

    public int duracion;

    public String ID;

    private Libro libro;

    private Usuario usuario;

    private boolean activo;

    public Prestamo(String ID, int duracion) {
        this.ID = ID;
        this.duracion = duracion;
        this.activo = false;
    }

    public void solicitarLibro(Libro libro, Usuario usuario) {
        if (!libro.isDisponible()) {
            System.out.println("  [PRÉSTAMO FALLIDO] El libro " + libro.ID + " no está disponible.");
            return;
        }
        this.libro = libro;
        this.usuario = usuario;
        this.activo = true;
        libro.setDisponible(false); 
        System.out.println("  [PRÉSTAMO CREADO] " + usuario.nombre 
                         + " tomó \"" + libro.ID + "\" por " + duracion + " días.");
    }

    public void registrarPrestamo() {
        if (!activo || libro == null || usuario == null) {
            System.out.println("  [ERROR] No hay préstamo activo para registrar.");
            return;
        }

        String[] detalles = {
            "ID Préstamo : " + ID,
            "Usuario     : " + usuario.nombre + " (" + usuario.getID() + ")",
            "Libro       : " + libro.ID + " - " + libro.autor,
            "Duración    : " + duracion + " días"
        };

        System.out.println("  --- Registro de Préstamo ---");
        for (String detalle : detalles) {
            System.out.println("  | " + detalle);
        }
        System.out.println("  ----------------------------");
    }
    public void finalizarPrestamo() {
        if (activo && libro != null) {
            libro.setDisponible(true);
            activo = false;
            System.out.println("  Préstamo " + ID + " finalizado. Libro " + libro.ID + " devuelto.");
        }
    }
    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Prestamo[ID=" + ID + ", Duración=" + duracion + " días, Activo=" + activo + "]";
    }
}
