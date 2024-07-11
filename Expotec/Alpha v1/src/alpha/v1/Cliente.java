
package alpha.v1;

public class Cliente {
    private String dpi;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String pin;
    private String contraseña;

    public Cliente() {
    }

    public Cliente(String dpi, String nombre, String apellido, String telefono, String correo, String pin, String contraseña) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.pin = pin;
        this.contraseña = contraseña;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dpi=" + dpi + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", correo=" + correo + ", pin=" + pin + ", contrase\u00f1a=" + contraseña + '}';
    }
  
}
