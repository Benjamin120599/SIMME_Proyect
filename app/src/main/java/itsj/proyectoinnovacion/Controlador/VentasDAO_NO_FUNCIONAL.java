/*
package itsj.proyectoinnovacion.Controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import itsj.proyectoinnovacion.POJOS.Ventas;

public class VentasDAO_NO_FUNCIONAL extends SQLiteOpenHelper{

    private static final int VERSION_BD = 1;
    private static final String NOMBRE_BD = "innovacion";
    private static final String TABLA_VENTAS = "Ventas";

    private static final String CAMPO_ID = "ID_Venta";
    private static final String CAMPO_TOTAL = "Total";
    private static final String CAMPO_FECHA = "Fecha";
    private static final String CAMPO_NOMBRE = "Nombre";

    //  MySQL  -->  CREATE TABLE alumnos(Num_Control VARCHAR(10) ......
    private static final String CREACION_TABLA_VENTAS = "CREATE TABLE "+TABLA_VENTAS+"("+CAMPO_ID+" INTEGER PRIMARY KEY, "+CAMPO_TOTAL+" DOUBLE, "+CAMPO_FECHA+" TEXT NOT NULL, "+CAMPO_NOMBRE+" TEXT NOT NULL)";

    public VentasDAO_NO_FUNCIONAL(Context context){
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREACION_TABLA_VENTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Actualizacion de la estructura de la BD
    }

    // --------------------------- METODOS ABCC para BD -----------------------------------

    public boolean agregarVenta(Ventas venta){
        boolean resultado = false;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(CAMPO_ID, venta.getIdVenta());
        contentValues.put(CAMPO_TOTAL, venta.getTotalVenta());
        contentValues.put(CAMPO_FECHA, venta.getFechaVenta());
        contentValues.put(CAMPO_NOMBRE, venta.getNombreResponsableVenta());

        long res = sqLiteDatabase.insert(TABLA_VENTAS, null, contentValues);
        if( res != -1){
            resultado = true;
            //Log.w("MSJ insercion registro:", res + "");
        }
        sqLiteDatabase.close();
        return resultado;
    }

    public boolean eliminarVenta(String nc){
        return false;
    }

    public boolean modificarVenta(Ventas venta){
        return false;
    }

    // Consultar
    public ArrayList<Ventas> mostrarVentas(){

        ArrayList arrayListVentas = new ArrayList<Ventas>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLA_VENTAS;
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do {
                arrayListVentas.add(new Ventas( cursor.getString(0), cursor.getDouble(1), cursor.getString(2), cursor.getString(3) ) );
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return arrayListVentas;
    }

    public ArrayList<Ventas> mostrarVentas(String campo, String cad){

        ArrayList arrayListVentas = new ArrayList<Ventas>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String sql = "SELECT * FROM "+TABLA_VENTAS+" WHERE "+campo+" LIKE '"+cad+";'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do {
                arrayListVentas.add(new Ventas( cursor.getString(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3)));
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return arrayListVentas;
    }

    public Ventas mostrarVenta(String campo, String cad){
        Ventas venta = new Ventas();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String sql = "SELECT * FROM "+TABLA_VENTAS+" WHERE "+campo+" LIKE '"+cad+";'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do {
                venta = new Ventas( cursor.getString(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3) );
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return venta;
    }

}*/