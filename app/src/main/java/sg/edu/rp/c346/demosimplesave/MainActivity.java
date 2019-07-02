package sg.edu.rp.c346.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause(){
        super.onPause();

        /**
         * Step 1 - Obtain an instance of the SharedPreferences
         * Step 2 - Obtain an instance of the SharedPreference Editor for update later
         * Step 3 - Add the key-value pair
         * Step 4 - Call commit() to save the changes into SharedPreferences
         **/
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefsEdit = prefs.edit();
        prefsEdit.putString("greetings", "Hello!");
        prefsEdit.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();

        /**
         * Step 1 - Obtain an instance of the SharedPreferences
         * Step 2 - Retrieve the saved data with the key from SharedPreference object
         **/
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String message = prefs.getString("greetings", "No greetings");

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }
}
