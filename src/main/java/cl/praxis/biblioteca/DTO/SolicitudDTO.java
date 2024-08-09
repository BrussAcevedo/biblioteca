package cl.praxis.biblioteca.DTO;

public class SolicitudDTO {
    private String idUsuario;
    private String idSolicitud;
    
    public SolicitudDTO(String idUsuario, String idSolicitud) {
        this.idUsuario = idUsuario;
        this.idSolicitud = idSolicitud;
    }
    public String getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getIdSolicitud() {
        return idSolicitud;
    }
    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    @Override
    public String toString() {
        return "SolicitudDTO [idUsuario=" + idUsuario + ", idSolicitud=" + idSolicitud + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
        result = prime * result + ((idSolicitud == null) ? 0 : idSolicitud.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SolicitudDTO other = (SolicitudDTO) obj;
        if (idUsuario == null) {
            if (other.idUsuario != null)
                return false;
        } else if (!idUsuario.equals(other.idUsuario))
            return false;
        if (idSolicitud == null) {
            if (other.idSolicitud != null)
                return false;
        } else if (!idSolicitud.equals(other.idSolicitud))
            return false;
        return true;
    }

    


    
}
