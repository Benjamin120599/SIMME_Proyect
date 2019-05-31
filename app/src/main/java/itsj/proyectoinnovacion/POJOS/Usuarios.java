package itsj.proyectoinnovacion.POJOS;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity
public class Usuarios {

    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "apellido_paterno")
    private String apellidoP;
    @ColumnInfo(name = "apellido_materno")
    private String apellidoM;
    @PrimaryKey
    @NonNull
    private String user;
    @ColumnInfo(name = "contraseña")
    private String password;

    public Usuarios() {
    }

    public Usuarios(String nombre, String apellidoP, String apellidoM, String user, String password) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.user = user;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
