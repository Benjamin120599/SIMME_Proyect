package itsj.proyectoinnovacion.Controlador;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import itsj.proyectoinnovacion.POJOS.Ventas;

@Dao
public interface VentasDAO {

    @Query("SELECT * FROM Ventas")
    List<Ventas> getAll();

    @Query("SELECT * FROM Ventas WHERE total_venta >= :totalVentas")
    Ventas findByTotal(double totalVentas);

    @Query("SELECT * FROM Ventas WHERE idVenta = :idVenta")
    Ventas findById(int idVenta);

    @Query("SELECT * FROM Ventas WHERE responsable = :responsable")
    Ventas findByResponsable(String responsable);

    @Query("SELECT * FROM Ventas WHERE fecha_venta = :fecha")
    Ventas findByFecha(String fecha);

    @Insert
    void insertVenta(Ventas ventas);

    @Update
    void updateVenta(Ventas venta);

    @Delete
    void deleteVenta(Ventas venta);



}
