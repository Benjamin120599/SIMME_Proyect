package itsj.proyectoinnovacion.POJOS;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Ventas {

    @PrimaryKey
    @NonNull
    private int idVenta;
    @ColumnInfo(name = "total_venta")
    private double totalVenta;
    @ColumnInfo(name = "fecha_venta")
    private String fechaVenta;
    @ColumnInfo(name = "responsable")
    private String nombreResponsableVenta;

    public Ventas() {
    }

    public Ventas(int idVenta, double totalVenta, String fechaVenta, String nombreResponsableVenta) {
        this.idVenta = idVenta;
        this.totalVenta = totalVenta;
        this.fechaVenta = fechaVenta;
        this.nombreResponsableVenta = nombreResponsableVenta;
    }

    // Getters And Setters
    public int getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }
    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }
    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombreResponsableVenta() {
        return nombreResponsableVenta;
    }
    public void setNombreResponsableVenta(String nombreResponsableVenta) {
        this.nombreResponsableVenta = nombreResponsableVenta;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "idVenta='" + idVenta + '\'' +
                ", totalVenta=" + totalVenta +
                ", fechaVenta='" + fechaVenta + '\'' +
                ", nombreResponsableVenta='" + nombreResponsableVenta + '\'' +
                '}';
    }
}
