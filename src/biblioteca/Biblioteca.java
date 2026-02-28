package biblioteca;


public class Biblioteca {

    public String nombre;

    public String ID;

    public Libro[] libros;

    public Usuario[] usuarios;

    private int totalLibros;

    private int totalUsuarios;

    public Biblioteca(String nombre, String ID) {
        this.nombre = nombre;
        this.ID = ID;
        this.libros = new Libro[100];   // Arreglo estático de libros
        this.usuarios = new Usuario[50]; // Arreglo estático de usuarios
        this.totalLibros = 0;
        this.totalUsuarios = 0;
    }


    public void registrarLibro(Libro libro) {
        // Estructura de selección: verificar capacidad del arreglo
        if (totalLibros >= libros.length) {
            System.out.println("  [ERROR] Capacidad máxima de libros alcanzada.");
            return;
        }
        libros[totalLibros] = libro;
        totalLibros++;
        libro.registrarLibro();
    }

    public void registrarUsuario(Usuario usuario) {
        if (totalUsuarios >= usuarios.length) {
            System.out.println("  [ERROR] Capacidad máxima de usuarios alcanzada.");
            return;
        }
        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;
        System.out.println("  [USUARIO REGISTRADO] " + usuario.nombre + " | Tipo: " 
                         + usuario.getClass().getSimpleName());
    }

    public void organizarLibro() {
        System.out.println("  Organizando " + totalLibros + " libro(s) por género...");


        for (int i = 0; i < totalLibros - 1; i++) {
            for (int j = 0; j < totalLibros - i - 1; j++) {
                if (libros[j].genero.compareTo(libros[j + 1].genero) > 0) {
                    Libro temp = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < totalLibros; i++) {
            System.out.println("  " + (i + 1) + ". " + libros[i].toString());
        }
    }

    public Libro consultarLibro(String ID) {
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].ID.equals(ID)) {
                System.out.println("  [ENCONTRADO] " + libros[i].toString());
                return libros[i];
            }
        }
        System.out.println("  [NO ENCONTRADO] No existe libro con ID: " + ID);
        return null;
    }

    public void solicitarLibro(String libroID, Usuario usuario) {
        Libro libro = consultarLibro(libroID);
        if (libro != null) {
            usuario.solicitarLibro(libro);
        }
    }

    public void mostrarCatalogo() {
        System.out.println("\n  === Catálogo de " + nombre + " ===");
        int disponibles = 0;
        for (int i = 0; i < totalLibros; i++) {
            System.out.println("  " + (i + 1) + ". " + libros[i].toString());
            if (libros[i].isDisponible()) disponibles++;
        }
        System.out.println("  Total: " + totalLibros + " | Disponibles: " + disponibles 
                         + " | Prestados: " + (totalLibros - disponibles));
    }

    public void mostrarUsuarios() {
        System.out.println("\n  === Usuarios de " + nombre + " ===");
        for (int i = 0; i < totalUsuarios; i++) {
            String tipo;
            if (usuarios[i] instanceof UsuarioMenor) {
                tipo = "Menor";
            } else if (usuarios[i] instanceof UsuarioMayor) {
                tipo = "Mayor";
            } else if (usuarios[i] instanceof UsuarioRegular) {
                tipo = "Regular";
            } else {
                tipo = "Genérico";
            }
            System.out.println("  " + (i + 1) + ". [" + tipo + "] " + usuarios[i].toString());
        }
    }

    @Override
    public String toString() {
        return "Biblioteca[Nombre=" + nombre + ", ID=" + ID 
             + ", Libros=" + totalLibros + ", Usuarios=" + totalUsuarios + "]";
    }
}
