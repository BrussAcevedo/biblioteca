package cl.praxis.biblioteca.DTO;

public class UsuarioDTO {
    private String nombreUsuario;
    private String password;
    
    public UsuarioDTO(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
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
    @Override
    public String toString() {
        return "UsuarioDTO [nombreUsuario=" + nombreUsuario + ", password=" + password + "]";
    }


    
}
