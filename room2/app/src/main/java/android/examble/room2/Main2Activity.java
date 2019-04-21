package android.examble.room2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import static android.examble.room2.animaldatabase.getAppDatabase;

public class Main2Activity extends AppCompatActivity {
    int gender =0  ;
    public Button button ;
    public EditText text1;
    public EditText text2;
    public EditText text3;

    String txt;
    String txt2;
    String txt3;
    String spin;
    //animaldatabase animaldatabas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinnner();
        text1 =findViewById(R.id.editText);
        text2 =findViewById(R.id.editText2);
        text3 =findViewById(R.id.editText3);
        button =(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 txt = text1.getText().toString();
                 txt2 = text2.getText().toString();
                 txt3 = text3.getText().toString();
               // animaldatabas = Room.databaseBuilder(getApplicationContext(),
                        //animaldatabase.class, "animal")
                        //.allowMainThreadQueries()
                        //.build();
                animaldatabase  animalbase = getAppDatabase(getApplicationContext());
                animalbase.userDao().insertOnlySingleMovie(new animal(txt,txt2,txt3,gender));
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }

//    private static ContactsContract.CommonDataKinds.Note addUser(final AppDatabase db, ContactsContract.CommonDataKinds.Note user) {
//        db.userDao().insertAll(user);
//        return user;
//    }
//
//    private static void populateWithTestData(animaldatabase db) {
//        ContactsContract.CommonDataKinds.Note user = new ContactsContract.CommonDataKinds.Note();
//        user.setFirstName("Ajay");
//        user.setLastName("Saini");
//        user.setAge(25);
//        addUser(db, user);
//    }
    void spinnner(){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals("male")) {
                        gender = 1; // Male
                    } else if (selection.equals("female")) {
                        gender = 2; // Female
                    } else {
                        gender = 0; // Unknown
                    }
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {
                gender= 0;

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2 ,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                //item1();
                animaldatabase  animalbase = getAppDatabase(getApplicationContext());
                animalbase.userDao().insertOnlySingleMovie(new animal(txt,txt2,txt3,gender));
                text1.setText("");
                text2.setText("");
                text3.setText("");
                return true;
            case R.id.item2:
                //item2();
                text1.setText("");
                text2.setText("");
                text3.setText("");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
