package biblioteca;


public class Main {

    public static void main(String[] args) {

        printSeparador("CASO 1: Creación de la Biblioteca y Registro de Libros");

        Biblioteca bib = new Biblioteca("Biblioteca Central", "BIB-001");

        Libro libro1 = new Libro("Gabriel García Márquez", "L001", "1967-06-05", "Novela");
        Libro libro2 = new Libro("George Orwell",          "L002", "1949-06-08", "Distopía");
        Libro libro3 = new Libro("J.K. Rowling",           "L003", "1997-06-26", "Fantasía");
        Libro libro4 = new Libro("Frank Herbert",          "L004", "1965-08-01", "Ciencia Ficción");

        bib.registrarLibro(libro1);
        bib.registrarLibro(libro2);
        bib.registrarLibro(libro3);
        bib.registrarLibro(libro4);

        printSeparador("CASO 2: Herencia – Registro de Usuarios");


        UsuarioRegular usuReg = new UsuarioRegular("Ana Torres",     "U001", 30);
        UsuarioMayor   usuMay = new UsuarioMayor("Carlos López",     "U002", 65);
        UsuarioMenor   usuMin = new UsuarioMenor("Sofía Ramírez",    "U003", 12);
        UsuarioMenor   usuMin2= new UsuarioMenor("Luis Herrera",     "U004", 10);

        bib.registrarUsuario(usuReg);
        bib.registrarUsuario(usuMay);
        bib.registrarUsuario(usuMin);
        bib.registrarUsuario(usuMin2);


        System.out.println();
        usuReg.verificacionDeUsuario();
        usuMay.verificacionDeUsuario();

        printSeparador("CASO 3: Asociación Tutor-Menor");

        usuMay.asociarUsuarioMenor(usuMin);

        usuReg.asociarUsuarioMenor(usuMin2);

        printSeparador("CASO 4: Polimorfismo – Solicitud de Libros");

        System.out.println("  -- Solicitud de usuario Regular --");
        usuReg.solicitarLibro(libro1); 

        System.out.println("  -- Solicitud de usuario Mayor --");
        usuMay.solicitarLibro(libro2); 
        System.out.println("  -- Solicitud de usuario Menor CON tutor --");
        usuMin.solicitarLibro(libro3); 

        System.out.println("  -- Solicitud de libro ya prestado --");
        libro1.setDisponible(false);  
        usuReg.solicitarLibro(libro1); 
        libro1.setDisponible(true);    

        printSeparador("CASO 5: Caso Borde – Menor sin Tutor");

        UsuarioMenor sinTutor = new UsuarioMenor("Pedro Gómez", "U005", 9);
        System.out.println("  Intentando solicitar libro sin tutor asignado:");
        sinTutor.solicitarLibro(libro4); 

        printSeparador("CASO 6: Gestión de Préstamos");

        Prestamo p1 = new Prestamo("P001", 14);
        p1.solicitarLibro(libro1, usuReg); 
        p1.registrarPrestamo();           

        System.out.println("  -- Intentar prestar libro ya prestado --");
        Prestamo p2 = new Prestamo("P002", 7);
        p2.solicitarLibro(libro1, usuMay); 

        printSeparador("CASO 7: Gestión de Multas");

        Multa multa1 = new Multa("M001", usuMin, 50.0);
        multa1.restringirAccesoAUsuario(); 


        multa1.devolucionDeLibro(libro3);
        multa1.restringirAccesoAUsuario(); 


        printSeparador("CASO 8: Conversión de Objetos y Catálogo");
        bib.mostrarUsuarios();


        printSeparador("CASO 9: Organización del Catálogo por Género");
        bib.organizarLibro();


        printSeparador("ESTADO FINAL DEL SISTEMA");
        bib.mostrarCatalogo();
        System.out.println("\n  " + bib.toString());
        System.out.println("\n  === FIN DE PRUEBAS ===");
    }

    private static void printSeparador(String titulo) {
        System.out.println("\n=================================================");
        System.out.println("  " + titulo);
        System.out.println("====================================================");
    }
}
