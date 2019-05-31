package itsj.proyectoinnovacion.Controlador;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import itsj.proyectoinnovacion.POJOS.Ventas;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class VentasDAO_Impl implements VentasDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfVentas;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfVentas;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfVentas;

  public VentasDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVentas = new EntityInsertionAdapter<Ventas>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Ventas`(`idVenta`,`total_venta`,`fecha_venta`,`responsable`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ventas value) {
        stmt.bindLong(1, value.getIdVenta());
        stmt.bindDouble(2, value.getTotalVenta());
        if (value.getFechaVenta() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFechaVenta());
        }
        if (value.getNombreResponsableVenta() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNombreResponsableVenta());
        }
      }
    };
    this.__deletionAdapterOfVentas = new EntityDeletionOrUpdateAdapter<Ventas>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Ventas` WHERE `idVenta` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ventas value) {
        stmt.bindLong(1, value.getIdVenta());
      }
    };
    this.__updateAdapterOfVentas = new EntityDeletionOrUpdateAdapter<Ventas>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Ventas` SET `idVenta` = ?,`total_venta` = ?,`fecha_venta` = ?,`responsable` = ? WHERE `idVenta` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ventas value) {
        stmt.bindLong(1, value.getIdVenta());
        stmt.bindDouble(2, value.getTotalVenta());
        if (value.getFechaVenta() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFechaVenta());
        }
        if (value.getNombreResponsableVenta() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNombreResponsableVenta());
        }
        stmt.bindLong(5, value.getIdVenta());
      }
    };
  }

  @Override
  public void insertVenta(Ventas ventas) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfVentas.insert(ventas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteVenta(Ventas venta) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfVentas.handle(venta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateVenta(Ventas venta) {
    __db.beginTransaction();
    try {
      __updateAdapterOfVentas.handle(venta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Ventas> getAll() {
    final String _sql = "SELECT * FROM Ventas";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdVenta = _cursor.getColumnIndexOrThrow("idVenta");
      final int _cursorIndexOfTotalVenta = _cursor.getColumnIndexOrThrow("total_venta");
      final int _cursorIndexOfFechaVenta = _cursor.getColumnIndexOrThrow("fecha_venta");
      final int _cursorIndexOfNombreResponsableVenta = _cursor.getColumnIndexOrThrow("responsable");
      final List<Ventas> _result = new ArrayList<Ventas>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Ventas _item;
        _item = new Ventas();
        final int _tmpIdVenta;
        _tmpIdVenta = _cursor.getInt(_cursorIndexOfIdVenta);
        _item.setIdVenta(_tmpIdVenta);
        final double _tmpTotalVenta;
        _tmpTotalVenta = _cursor.getDouble(_cursorIndexOfTotalVenta);
        _item.setTotalVenta(_tmpTotalVenta);
        final String _tmpFechaVenta;
        _tmpFechaVenta = _cursor.getString(_cursorIndexOfFechaVenta);
        _item.setFechaVenta(_tmpFechaVenta);
        final String _tmpNombreResponsableVenta;
        _tmpNombreResponsableVenta = _cursor.getString(_cursorIndexOfNombreResponsableVenta);
        _item.setNombreResponsableVenta(_tmpNombreResponsableVenta);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Ventas findByTotal(double totalVentas) {
    final String _sql = "SELECT * FROM Ventas WHERE total_venta >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindDouble(_argIndex, totalVentas);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdVenta = _cursor.getColumnIndexOrThrow("idVenta");
      final int _cursorIndexOfTotalVenta = _cursor.getColumnIndexOrThrow("total_venta");
      final int _cursorIndexOfFechaVenta = _cursor.getColumnIndexOrThrow("fecha_venta");
      final int _cursorIndexOfNombreResponsableVenta = _cursor.getColumnIndexOrThrow("responsable");
      final Ventas _result;
      if(_cursor.moveToFirst()) {
        _result = new Ventas();
        final int _tmpIdVenta;
        _tmpIdVenta = _cursor.getInt(_cursorIndexOfIdVenta);
        _result.setIdVenta(_tmpIdVenta);
        final double _tmpTotalVenta;
        _tmpTotalVenta = _cursor.getDouble(_cursorIndexOfTotalVenta);
        _result.setTotalVenta(_tmpTotalVenta);
        final String _tmpFechaVenta;
        _tmpFechaVenta = _cursor.getString(_cursorIndexOfFechaVenta);
        _result.setFechaVenta(_tmpFechaVenta);
        final String _tmpNombreResponsableVenta;
        _tmpNombreResponsableVenta = _cursor.getString(_cursorIndexOfNombreResponsableVenta);
        _result.setNombreResponsableVenta(_tmpNombreResponsableVenta);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Ventas findById(int idVenta) {
    final String _sql = "SELECT * FROM Ventas WHERE idVenta = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idVenta);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdVenta = _cursor.getColumnIndexOrThrow("idVenta");
      final int _cursorIndexOfTotalVenta = _cursor.getColumnIndexOrThrow("total_venta");
      final int _cursorIndexOfFechaVenta = _cursor.getColumnIndexOrThrow("fecha_venta");
      final int _cursorIndexOfNombreResponsableVenta = _cursor.getColumnIndexOrThrow("responsable");
      final Ventas _result;
      if(_cursor.moveToFirst()) {
        _result = new Ventas();
        final int _tmpIdVenta;
        _tmpIdVenta = _cursor.getInt(_cursorIndexOfIdVenta);
        _result.setIdVenta(_tmpIdVenta);
        final double _tmpTotalVenta;
        _tmpTotalVenta = _cursor.getDouble(_cursorIndexOfTotalVenta);
        _result.setTotalVenta(_tmpTotalVenta);
        final String _tmpFechaVenta;
        _tmpFechaVenta = _cursor.getString(_cursorIndexOfFechaVenta);
        _result.setFechaVenta(_tmpFechaVenta);
        final String _tmpNombreResponsableVenta;
        _tmpNombreResponsableVenta = _cursor.getString(_cursorIndexOfNombreResponsableVenta);
        _result.setNombreResponsableVenta(_tmpNombreResponsableVenta);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Ventas findByResponsable(String responsable) {
    final String _sql = "SELECT * FROM Ventas WHERE responsable = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (responsable == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, responsable);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdVenta = _cursor.getColumnIndexOrThrow("idVenta");
      final int _cursorIndexOfTotalVenta = _cursor.getColumnIndexOrThrow("total_venta");
      final int _cursorIndexOfFechaVenta = _cursor.getColumnIndexOrThrow("fecha_venta");
      final int _cursorIndexOfNombreResponsableVenta = _cursor.getColumnIndexOrThrow("responsable");
      final Ventas _result;
      if(_cursor.moveToFirst()) {
        _result = new Ventas();
        final int _tmpIdVenta;
        _tmpIdVenta = _cursor.getInt(_cursorIndexOfIdVenta);
        _result.setIdVenta(_tmpIdVenta);
        final double _tmpTotalVenta;
        _tmpTotalVenta = _cursor.getDouble(_cursorIndexOfTotalVenta);
        _result.setTotalVenta(_tmpTotalVenta);
        final String _tmpFechaVenta;
        _tmpFechaVenta = _cursor.getString(_cursorIndexOfFechaVenta);
        _result.setFechaVenta(_tmpFechaVenta);
        final String _tmpNombreResponsableVenta;
        _tmpNombreResponsableVenta = _cursor.getString(_cursorIndexOfNombreResponsableVenta);
        _result.setNombreResponsableVenta(_tmpNombreResponsableVenta);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Ventas findByFecha(String fecha) {
    final String _sql = "SELECT * FROM Ventas WHERE fecha_venta = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fecha == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fecha);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdVenta = _cursor.getColumnIndexOrThrow("idVenta");
      final int _cursorIndexOfTotalVenta = _cursor.getColumnIndexOrThrow("total_venta");
      final int _cursorIndexOfFechaVenta = _cursor.getColumnIndexOrThrow("fecha_venta");
      final int _cursorIndexOfNombreResponsableVenta = _cursor.getColumnIndexOrThrow("responsable");
      final Ventas _result;
      if(_cursor.moveToFirst()) {
        _result = new Ventas();
        final int _tmpIdVenta;
        _tmpIdVenta = _cursor.getInt(_cursorIndexOfIdVenta);
        _result.setIdVenta(_tmpIdVenta);
        final double _tmpTotalVenta;
        _tmpTotalVenta = _cursor.getDouble(_cursorIndexOfTotalVenta);
        _result.setTotalVenta(_tmpTotalVenta);
        final String _tmpFechaVenta;
        _tmpFechaVenta = _cursor.getString(_cursorIndexOfFechaVenta);
        _result.setFechaVenta(_tmpFechaVenta);
        final String _tmpNombreResponsableVenta;
        _tmpNombreResponsableVenta = _cursor.getString(_cursorIndexOfNombreResponsableVenta);
        _result.setNombreResponsableVenta(_tmpNombreResponsableVenta);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
