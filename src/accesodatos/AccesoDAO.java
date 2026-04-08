package accesodatos;

import entidades.Acceso;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccesoDAO {

    private final String ARCHIVO = "accesos.txt";

    public void registrarAcceso(Acceso acceso) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true));

        String salida = acceso.getFechaSalida() == null
                ? "null"
                : acceso.getFechaSalida().toString();

        String linea = acceso.getIdUsuario() + ";" +
                       acceso.getFechaEntrada() + ";" +
                       salida;

        bw.write(linea);
        bw.newLine();
        bw.close();
    }

    public List<Acceso> obtenerAccesos() throws IOException {

        List<Acceso> lista = new ArrayList<>();

        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            return lista;
        }

        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String linea;

        while ((linea = br.readLine()) != null) {

            String[] partes = linea.split(";");

            LocalDateTime entrada = LocalDateTime.parse(partes[1]);

            LocalDateTime salida = partes[2].equals("null")
                    ? null
                    : LocalDateTime.parse(partes[2]);

            Acceso acceso = new Acceso(
                    partes[0],
                    entrada,
                    salida
            );

            lista.add(acceso);
        }

        br.close();

        return lista;
    }

}