package itsj.proyectoinnovacion.Common;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import itsj.proyectoinnovacion.Controlador.FavoritosDAO;
import itsj.proyectoinnovacion.Controlador.FavoritosDAO_Impl;
import itsj.proyectoinnovacion.Controlador.UsuariosDAO;
import itsj.proyectoinnovacion.Controlador.UsuariosDAO_Impl;
import itsj.proyectoinnovacion.Controlador.VentasDAO;
import itsj.proyectoinnovacion.Controlador.VentasDAO_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class AppDataBase_Impl extends AppDataBase {
  private volatile UsuariosDAO _usuariosDAO;

  private volatile VentasDAO _ventasDAO;

  private volatile FavoritosDAO _favoritosDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Usuarios` (`nombre` TEXT, `apellido_paterno` TEXT, `apellido_materno` TEXT, `user` TEXT NOT NULL, `contraseña` TEXT, PRIMARY KEY(`user`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Ventas` (`idVenta` INTEGER NOT NULL, `total_venta` REAL NOT NULL, `fecha_venta` TEXT, `responsable` TEXT, PRIMARY KEY(`idVenta`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Favoritos` (`title` TEXT NOT NULL, `pub_date` TEXT, `content` TEXT, `link` TEXT, PRIMARY KEY(`title`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"8918cf722574b4e3082636c1c5b0259b\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Usuarios`");
        _db.execSQL("DROP TABLE IF EXISTS `Ventas`");
        _db.execSQL("DROP TABLE IF EXISTS `Favoritos`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUsuarios = new HashMap<String, TableInfo.Column>(5);
        _columnsUsuarios.put("nombre", new TableInfo.Column("nombre", "TEXT", false, 0));
        _columnsUsuarios.put("apellido_paterno", new TableInfo.Column("apellido_paterno", "TEXT", false, 0));
        _columnsUsuarios.put("apellido_materno", new TableInfo.Column("apellido_materno", "TEXT", false, 0));
        _columnsUsuarios.put("user", new TableInfo.Column("user", "TEXT", true, 1));
        _columnsUsuarios.put("contraseña", new TableInfo.Column("contraseña", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsuarios = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsuarios = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsuarios = new TableInfo("Usuarios", _columnsUsuarios, _foreignKeysUsuarios, _indicesUsuarios);
        final TableInfo _existingUsuarios = TableInfo.read(_db, "Usuarios");
        if (! _infoUsuarios.equals(_existingUsuarios)) {
          throw new IllegalStateException("Migration didn't properly handle Usuarios(itsj.proyectoinnovacion.POJOS.Usuarios).\n"
                  + " Expected:\n" + _infoUsuarios + "\n"
                  + " Found:\n" + _existingUsuarios);
        }
        final HashMap<String, TableInfo.Column> _columnsVentas = new HashMap<String, TableInfo.Column>(4);
        _columnsVentas.put("idVenta", new TableInfo.Column("idVenta", "INTEGER", true, 1));
        _columnsVentas.put("total_venta", new TableInfo.Column("total_venta", "REAL", true, 0));
        _columnsVentas.put("fecha_venta", new TableInfo.Column("fecha_venta", "TEXT", false, 0));
        _columnsVentas.put("responsable", new TableInfo.Column("responsable", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVentas = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVentas = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVentas = new TableInfo("Ventas", _columnsVentas, _foreignKeysVentas, _indicesVentas);
        final TableInfo _existingVentas = TableInfo.read(_db, "Ventas");
        if (! _infoVentas.equals(_existingVentas)) {
          throw new IllegalStateException("Migration didn't properly handle Ventas(itsj.proyectoinnovacion.POJOS.Ventas).\n"
                  + " Expected:\n" + _infoVentas + "\n"
                  + " Found:\n" + _existingVentas);
        }
        final HashMap<String, TableInfo.Column> _columnsFavoritos = new HashMap<String, TableInfo.Column>(4);
        _columnsFavoritos.put("title", new TableInfo.Column("title", "TEXT", true, 1));
        _columnsFavoritos.put("pub_date", new TableInfo.Column("pub_date", "TEXT", false, 0));
        _columnsFavoritos.put("content", new TableInfo.Column("content", "TEXT", false, 0));
        _columnsFavoritos.put("link", new TableInfo.Column("link", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavoritos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavoritos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavoritos = new TableInfo("Favoritos", _columnsFavoritos, _foreignKeysFavoritos, _indicesFavoritos);
        final TableInfo _existingFavoritos = TableInfo.read(_db, "Favoritos");
        if (! _infoFavoritos.equals(_existingFavoritos)) {
          throw new IllegalStateException("Migration didn't properly handle Favoritos(itsj.proyectoinnovacion.POJOS.Favoritos).\n"
                  + " Expected:\n" + _infoFavoritos + "\n"
                  + " Found:\n" + _existingFavoritos);
        }
      }
    }, "8918cf722574b4e3082636c1c5b0259b", "9857874a783370730a42069116ceea96");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Usuarios","Ventas","Favoritos");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Usuarios`");
      _db.execSQL("DELETE FROM `Ventas`");
      _db.execSQL("DELETE FROM `Favoritos`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public UsuariosDAO usuariosDAO() {
    if (_usuariosDAO != null) {
      return _usuariosDAO;
    } else {
      synchronized(this) {
        if(_usuariosDAO == null) {
          _usuariosDAO = new UsuariosDAO_Impl(this);
        }
        return _usuariosDAO;
      }
    }
  }

  @Override
  public VentasDAO ventasDAO() {
    if (_ventasDAO != null) {
      return _ventasDAO;
    } else {
      synchronized(this) {
        if(_ventasDAO == null) {
          _ventasDAO = new VentasDAO_Impl(this);
        }
        return _ventasDAO;
      }
    }
  }

  @Override
  public FavoritosDAO favoritosDAO() {
    if (_favoritosDAO != null) {
      return _favoritosDAO;
    } else {
      synchronized(this) {
        if(_favoritosDAO == null) {
          _favoritosDAO = new FavoritosDAO_Impl(this);
        }
        return _favoritosDAO;
      }
    }
  }
}
