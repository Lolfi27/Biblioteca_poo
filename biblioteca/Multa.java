package biblioteca;


public class Multa {

    public String ID;

    private Usuario usuario;

    private boolean activa;

    private double monto;


    public Multa(String ID, Usuario usuario, double monto) {
        this.ID = ID;
        this.usuario = usuario;
        this.monto = monto;
        this.activa = true;
    }

    public void restringirAccesoAUsuario() {
        if (activa) {
            System.out.println("  [ACCESO RESTRINGIDO] Usuario: " + usuario.nombre 
                             + " | Multa: " + ID + " | Monto: $" + monto);
        } else {
            System.out.println("  La multa " + ID + " ya fue saldada. Acceso libre.");
        }
    }

    public void devolucionDeLibro(Libro libro) {
        libro.setDisponible(true);
        activa = false;
        System.out.println("  [MULTA LEVANTADA] " + usuario.nombre 
                         + " devolvió el libro " + libro.ID + ". Multa " + ID + " cancelada.");
    }

    public boolean isActiva() {
        return activa;
    }

    @Override
    public String toString() {
        return "Multa[ID=" + ID + ", Usuario=" + usuario.nombre 
             + ", Monto=$" + monto + ", Activa=" + activa + "]";
    }
}
