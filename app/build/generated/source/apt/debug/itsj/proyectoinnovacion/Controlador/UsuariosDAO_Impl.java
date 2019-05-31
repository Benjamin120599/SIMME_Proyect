package itsj.proyectoinnovacion.Controlador;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import itsj.proyectoinnovacion.POJOS.Usuarios;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public class UsuariosDAO_Impl implements UsuariosDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUsuarios;

  public UsuariosDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUsuarios = new EntityInsertionAdapter<Usuarios>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Usuarios`(`nombre`,`apellido_paterno`,`apellido_materno`,`user`,`contraseña`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Usuarios value) {
        if (value.getNombre() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNombre());
        }
        if (value.getApellidoP() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getApellidoP());
        }
        if (value.getApellidoM() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApellidoM());
        }
        if (value.getUser() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUser());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPassword());
        }
      }
    };
  }

  @Override
  public void insertAll(Usuarios... users) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUsuarios.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Usuarios findByUsers(String nombreUsuario) {
    final String _sql = "SELECT * FROM Usuarios WHERE user = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nombreUsuario == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nombreUsuario);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNombre = _cursor.getColumnIndexOrThrow("nombre");
      final int _cursorIndexOfApellidoP = _cursor.getColumnIndexOrThrow("apellido_paterno");
      final int _cursorIndexOfApellidoM = _cursor.getColumnIndexOrThrow("apellido_materno");
      final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("user");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("contraseña");
      final Usuarios _result;
      if(_cursor.moveToFirst()) {
        _result = new Usuarios();
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        _result.setNombre(_tmpNombre);
        final String _tmpApellidoP;
        _tmpApellidoP = _cursor.getString(_cursorIndexOfApellidoP);
        _result.setApellidoP(_tmpApellidoP);
        final String _tmpApellidoM;
        _tmpApellidoM = _cursor.getString(_cursorIndexOfApellidoM);
        _result.setApellidoM(_tmpApellidoM);
        final String _tmpUser;
        _tmpUser = _cursor.getString(_cursorIndexOfUser);
        _result.setUser(_tmpUser);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
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
