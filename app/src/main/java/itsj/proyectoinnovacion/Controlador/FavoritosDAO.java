package itsj.proyectoinnovacion.Controlador;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
import itsj.proyectoinnovacion.POJOS.Favoritos;

@Dao
public interface FavoritosDAO {

    @Query("SELECT * FROM Favoritos")
    List<Favoritos> getAlL();

    @Insert
    void insertFavorito(Favoritos fav);

    @Delete
    void deleteFavorito(Favoritos fav);

}
