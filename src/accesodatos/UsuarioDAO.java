package accesodatos;

import entidades.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private final String ARCHIVO = "usuarios.txt";

    public void guardarUsuario(Usuario usuario) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true));

        String linea = usuario.getId() + ";" +
                       usuario.getNombre() + ";" +
                       usuario.getRol();

        bw.write(linea);
        bw.newLine();
        bw.close();
    }

    public List<Usuario> obtenerUsuarios() throws IOException {

        List<Usuario> lista = new ArrayList<>();

        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            return lista;
        }

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        while ((linea = br.readLine()) != null) {

            String[] partes = linea.split(";");

            Usuario usuario = new Usuario(
                    partes[0],
                    partes[1],
                    partes[2]
            );

            lista.add(usuario);
        }

        br.close();

        return lista;
    }

    public void eliminarUsuario(String id) throws IOException {

        List<Usuario> usuarios = obtenerUsuarios();

        BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO));

        for (Usuario u : usuarios) {

            if (!u.getId().equals(id)) {

                String linea = u.getId() + ";" +
                               u.getNombre() + ";" +
                               u.getRol();

                bw.write(linea);
                bw.newLine();
            }
        }

        bw.close();
    }

}