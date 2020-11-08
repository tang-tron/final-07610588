package com.example.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.afinal.db.AppDatabase;
import com.example.afinal.model.User;
import com.example.afinal.util.AppExecutors;

import java.util.Locale;

public class Addrecordmi extends AppCompatActivity {

 @Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.add_speed);

     Button savebutton = findViewById(R.id.savebutton);
     savebutton.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick (View view){
             EditText meteredit = findViewById( R.id.meter );
             EditText timeedit = findViewById( R.id.second );
             double m = Double.parseDouble( meteredit.getText().toString() );
             double s = Double.parseDouble( timeedit.getText().toString() );
             double speed = (m / s) / 0.277778;

             final User user = new User( 130,0.6 );
             AppExecutors executors = new AppExecutors();
             executors.diskIO().execute(new Runnable() {
                 @Override
                 public void run() { // worker thread
                     AppDatabase db = AppDatabase.insertInitialData(Addrecordmi.this);
                     db.userDao().addUser(user);
                     finish();
                 }
             });
         }
     });
 }
}