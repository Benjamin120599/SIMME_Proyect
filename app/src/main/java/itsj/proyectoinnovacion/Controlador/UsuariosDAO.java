package itsj.proyectoinnovacion.Controlador;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import itsj.proyectoinnovacion.POJOS.Usuarios;

@Dao
public interface UsuariosDAO {
    @Query("SELECT * FROM Usuarios WHERE user = :nombreUsuario")
    Usuarios findByUsers(String nombreUsuario);

    @Insert
    void insertAll(Usuarios... users);

}
