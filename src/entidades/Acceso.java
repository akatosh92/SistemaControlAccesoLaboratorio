package entidades;

import java.time.LocalDateTime;

public class Acceso {

    private String idUsuario;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;

    public Acceso(String idUsuario, LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        this.idUsuario = idUsuario;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

}