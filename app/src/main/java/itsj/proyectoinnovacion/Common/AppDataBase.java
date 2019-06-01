package itsj.proyectoinnovacion.Common;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import itsj.proyectoinnovacion.Controlador.FavoritosDAO;
import itsj.proyectoinnovacion.Controlador.UsuariosDAO;
import itsj.proyectoinnovacion.Controlador.VentasDAO;
import itsj.proyectoinnovacion.POJOS.Favoritos;
import itsj.proyectoinnovacion.POJOS.Usuarios;
import itsj.proyectoinnovacion.POJOS.Ventas;

@Database(entities = {Usuarios.class, Ventas.class, Favoritos.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UsuariosDAO usuariosDAO();
    public abstract VentasDAO ventasDAO();
    public abstract FavoritosDAO favoritosDAO();
}
