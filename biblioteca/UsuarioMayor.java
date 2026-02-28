package biblioteca;

public class UsuarioMayor extends Usuario {

    public String registroDeUsuario;

    public UsuarioMayor(String nombre, String ID, int edad) {
        super(nombre, ID, edad); 
        this.registroDeUsuario = "MAY-" + ID;
    }

    public void asociarUsuarioMenor(UsuarioMenor menor) {
        menor.setTutor(this);
        System.out.println("  " + nombre + " (Mayor) ahora es tutor de: " + menor.nombre);
    }

    @Override
    public String toString() {
        return "UsuarioMayor[Nombre=" + nombre + ", ID=" + ID + ", Registro=" + registroDeUsuario + "]";
    }
}
