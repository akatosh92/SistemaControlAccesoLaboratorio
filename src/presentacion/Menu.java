package presentacion;

import entidades.Usuario;
import entidades.Acceso;
import logicanegocio.UsuarioServicio;
import logicanegocio.AccesoServicio;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner sc;
    private UsuarioServicio usuarioServicio;
    private AccesoServicio accesoServicio;

    public Menu() {
        sc = new Scanner(System.in);
        usuarioServicio = new UsuarioServicio();
        accesoServicio = new AccesoServicio();
    }

    public void mostrarMenu() {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== SISTEMA CONTROL DE LABORATORIO =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Consultar usuarios");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Registrar entrada");
            System.out.println("5. Registrar salida");
            System.out.println("6. Historial de accesos por usuario");
            System.out.println("7. Tiempo total en laboratorio");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            try {

                switch (opcion) {

                    case 1 -> registrarUsuario();
                    case 2 -> consultarUsuarios();
                    case 3 -> eliminarUsuario();
                    case 4 -> registrarEntrada();
                    case 5 -> registrarSalida();
                    case 6 -> historialUsuario();
                    case 7 -> tiempoTotal();

                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    }

    private void registrarUsuario() throws Exception {

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Rol (Estudiante/Docente): ");
        String rol = sc.nextLine();

        usuarioServicio.registrarUsuario(id, nombre, rol);

        System.out.println("Usuario registrado correctamente");
    }

    private void consultarUsuarios() throws Exception {

        List<Usuario> usuarios = usuarioServicio.consultarUsuarios();

        for (Usuario u : usuarios) {

            System.out.println(
                    u.getId() + " | " +
                    u.getNombre() + " | " +
                    u.getRol()
            );
        }

    }

    private void eliminarUsuario() throws Exception {

        System.out.print("Ingrese ID a eliminar: ");
        String id = sc.nextLine();

        usuarioServicio.eliminarUsuario(id);

        System.out.println("Usuario eliminado");
    }

    private void registrarEntrada() throws Exception {

        System.out.print("ID Usuario: ");
        String id = sc.nextLine();

        accesoServicio.registrarEntrada(id);

        System.out.println("Entrada registrada");
    }

    private void registrarSalida() throws Exception {

        System.out.print("ID Usuario: ");
        String id = sc.nextLine();

        accesoServicio.registrarSalida(id);

        System.out.println("Salida registrada");
    }

    private void historialUsuario() throws Exception {

        System.out.print("ID Usuario: ");
        String id = sc.nextLine();

        List<Acceso> accesos = accesoServicio.historialUsuario(id);

        for (Acceso a : accesos) {

            System.out.println(
                    "Entrada: " + a.getFechaEntrada() +
                    " | Salida: " + a.getFechaSalida()
            );
        }

    }

    private void tiempoTotal() throws Exception {

        System.out.print("ID Usuario: ");
        String id = sc.nextLine();

        long minutos = accesoServicio.tiempoTotalLaboratorio(id);

        System.out.println("Tiempo total en laboratorio: " + minutos + " minutos");

    }

}