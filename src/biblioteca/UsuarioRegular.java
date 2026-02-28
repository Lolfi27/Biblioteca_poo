package biblioteca;

public class UsuarioRegular extends Usuario {

    public String registroDeUsuario;

    public UsuarioRegular(String nombre, String ID, int edad) {
        super(nombre, ID, edad);
        this.registroDeUsuario = "REG-" + ID;
    }

    public void asociarUsuarioMenor(UsuarioMenor menor) {
        menor.setTutor(this);
        System.out.println("  " + nombre + " (Regular) ahora es tutor de: " + menor.nombre);
    }

    @Override
    public String toString() {
        return "UsuarioRegular[Nombre=" + nombre + ", ID=" + ID + ", Registro=" + registroDeUsuario + "]";
    }
}
