package logicanegocio;

import accesodatos.AccesoDAO;
import accesodatos.UsuarioDAO;
import entidades.Acceso;
import entidades.Usuario;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccesoServicio {

    private AccesoDAO accesoDAO;

    public AccesoServicio() {
        accesoDAO = new AccesoDAO();
    }

    public void registrarEntrada(String idUsuario) throws Exception {

        if (idUsuario == null || idUsuario.trim().isEmpty()) {
            throw new Exception("ID de usuario inválido");
        }

        idUsuario = idUsuario.trim();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();

        boolean existe = false;

        for (Usuario u : usuarios) {
            if (u.getId().equalsIgnoreCase(idUsuario)) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            throw new Exception("El usuario no existe");
        }

        List<Acceso> accesos = accesoDAO.obtenerAccesos();

        for (Acceso a : accesos) {
            if (a.getIdUsuario().equalsIgnoreCase(idUsuario) && a.getFechaSalida() == null) {
                throw new Exception("El usuario ya está dentro del laboratorio");
            }
        }

        Acceso acceso = new Acceso(
                idUsuario,
                LocalDateTime.now(),
                null
        );

        accesoDAO.registrarAcceso(acceso);
    }

    public void registrarSalida(String idUsuario) throws Exception {

        if (idUsuario == null || idUsuario.trim().isEmpty()) {
            throw new Exception("ID de usuario inválido");
        }

        idUsuario = idUsuario.trim();

        List<Acceso> accesos = accesoDAO.obtenerAccesos();

        boolean encontrado = false;

        for (Acceso a : accesos) {

            if (a.getIdUsuario().equalsIgnoreCase(idUsuario) && a.getFechaSalida() == null) {

                a.setFechaSalida(LocalDateTime.now());
                encontrado = true;
            }
        }

        if (!encontrado) {
            throw new Exception("No existe entrada registrada para este usuario");
        }

        guardarTodos(accesos);
    }

    private void guardarTodos(List<Acceso> accesos) throws IOException {

        java.io.BufferedWriter bw =
                new java.io.BufferedWriter(new java.io.FileWriter("accesos.txt"));

        for (Acceso a : accesos) {

            String salida = a.getFechaSalida() == null
                    ? "null"
                    : a.getFechaSalida().toString();

            String linea = a.getIdUsuario() + ";" +
                    a.getFechaEntrada() + ";" +
                    salida;

            bw.write(linea);
            bw.newLine();
        }

        bw.close();
    }

    public List<Acceso> historialUsuario(String idUsuario) throws IOException {

        List<Acceso> accesos = accesoDAO.obtenerAccesos();
        List<Acceso> resultado = new ArrayList<>();

        for (Acceso a : accesos) {

            if (a.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                resultado.add(a);
            }
        }

        return resultado;
    }

    public long tiempoTotalLaboratorio(String idUsuario) throws IOException {

        List<Acceso> accesos = historialUsuario(idUsuario);

        long minutos = 0;

        for (Acceso a : accesos) {

            if (a.getFechaSalida() != null) {

                Duration d = Duration.between(
                        a.getFechaEntrada(),
                        a.getFechaSalida()
                );

                minutos += d.toMinutes();
            }
        }

        return minutos;
    }
}