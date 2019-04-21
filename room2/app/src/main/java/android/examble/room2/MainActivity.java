package android.examble.room2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.examble.room2.animaldatabase.getAppDatabase;

public class MainActivity extends AppCompatActivity {
    //animaldatabase animaldatabas;
    List<animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);
            }
        });
        data_storage();
       recycler_View();
    }
   void  data_storage(){

       animaldatabase animalbase = getAppDatabase(getApplicationContext());
         animals = animalbase.userDao().fetchOneMoviesbyMovieId();
   }
    void recycler_View() {

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.Adapter mAdapter = mAdapter = new MyAdapter(this,animals);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1 ,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                animaldatabase animalbase = getAppDatabase(getApplicationContext());
                animalbase.userDao().insertOnlySingleMovie(new animal("rabit","dodo","25",1) );
                animalbase.userDao().fetchOneMoviesbyMovieId();
                //item1();
                return true;
            case R.id.item2:
                //item2();
                animalbase = getAppDatabase(getApplicationContext());
                animalbase.userDao().deleteMovies();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
