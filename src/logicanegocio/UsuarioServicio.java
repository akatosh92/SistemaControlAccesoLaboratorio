package logicanegocio;

import accesodatos.UsuarioDAO;
import entidades.Usuario;

import java.io.IOException;
import java.util.List;

public class UsuarioServicio {

    private UsuarioDAO usuarioDAO;

    public UsuarioServicio() {
        usuarioDAO = new UsuarioDAO();
    }

    public void registrarUsuario(String id, String nombre, String rol) throws Exception {

        if (id == null || nombre == null || rol == null) {
            throw new Exception("Datos incompletos");
        }

        id = id.trim();
        nombre = nombre.trim();
        rol = rol.trim();

        if (id.isEmpty() || nombre.isEmpty() || rol.isEmpty()) {
            throw new Exception("Los datos no pueden estar vacíos");
        }

        if (!rol.equalsIgnoreCase("Estudiante") && !rol.equalsIgnoreCase("Docente")) {
            throw new Exception("Rol inválido. Debe ser Estudiante o Docente");
        }

        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();

        for (Usuario u : usuarios) {
            if (u.getId().equalsIgnoreCase(id)) {
                throw new Exception("El ID ya existe");
            }
        }

        Usuario usuario = new Usuario(id, nombre, rol);
        usuarioDAO.guardarUsuario(usuario);
    }

    public List<Usuario> consultarUsuarios() throws IOException {
        return usuarioDAO.obtenerUsuarios();
    }

    public void eliminarUsuario(String id) throws Exception {

        if (id == null || id.trim().isEmpty()) {
            throw new Exception("ID inválido");
        }

        id = id.trim();

        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();

        boolean existe = false;

        for (Usuario u : usuarios) {
            if (u.getId().equalsIgnoreCase(id)) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            throw new Exception("Usuario no encontrado");
        }

        usuarioDAO.eliminarUsuario(id);
    }
}