package android.examble.room2;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@android.arch.persistence.room.Dao
public interface Dao {
    @Insert
    void insertOnlySingleMovie (animal anima);
    @Insert
    void insertMultipleMovies (List<animal> animals);
    @Query("SELECT * FROM animal ")
     List <animal> fetchOneMoviesbyMovieId ();
    @Update
    void updateMovie (animal anima);
    @Delete
    void deleteMovie (animal anima);
//    @Delete
//    void deleteMovies ();
    @Query("DELETE FROM animal ")
     void  deleteMovies();
}
