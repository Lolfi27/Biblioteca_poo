package biblioteca;

public class Libro {

    public String autor;

    public String ID;

    public String fechaPublicacion;

    public String genero;

    private boolean disponible;

    public Libro(String autor, String ID, String fechaPublicacion, String genero) {
        this.autor = autor;
        this.ID = ID;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.disponible = true;
    }

    public void registrarLibro() {
        System.out.println("  [LIBRO REGISTRADO] ID=" + ID + " | Autor: " + autor + " | Género: " + genero);
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro[ID=" + ID + ", Autor=" + autor 
             + ", Género=" + genero 
             + ", Publicación=" + fechaPublicacion 
             + ", Disponible=" + (disponible ? "Sí" : "No") + "]";
    }
}
