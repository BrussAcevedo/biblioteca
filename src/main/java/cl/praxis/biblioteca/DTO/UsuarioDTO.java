package cl.praxis.biblioteca.DTO;

public class UsuarioDTO {
    private String nombreUsuario;
    private String password;
    private String idUsuario;
    public UsuarioDTO(String nombreUsuario, String password, String idUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.idUsuario = idUsuario;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    @Override
    public String toString() {
        return "UsuarioDTO [nombreUsuario=" + nombreUsuario + ", password=" + password + ", idUsuario=" + idUsuario
                + "]";
    }
    


    
}
