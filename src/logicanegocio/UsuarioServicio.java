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

        if (id.isEmpty() || nombre.isEmpty() || rol.isEmpty()) {
            throw new Exception("Datos incompletos");
        }

        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();

        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
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

        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();

        boolean existe = false;

        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
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