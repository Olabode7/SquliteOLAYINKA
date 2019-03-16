package com.example.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("PatientMedicalReport", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS PatientData (name VARCHAR, age INT(3), gender VARCHAR, id INTEGER PRIMARY KEY)");
            sqLiteDatabase.execSQL("INSERT INTO PatientData (name, age,gender) VALUES ('Nick',23)");
            sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name, age,gender) VALUES ('Nick',43)");
            sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name, age,gender) VALUES ('Dave',14)");
            sqLiteDatabase.execSQL("INSERT INTO theNewUsers (name, age,gender) VALUES ('Dave',14)");
            //sqLiteDatabase.execSQL("DELETE FROM theNewUsers WHERE id = 2");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM PatientData WHERE age < 20", null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int genderIndex = c.getColumnIndex("gender");
            int idIndex = c.getColumnIndex("id");
            c.moveToFirst();

            while (c != null) {
                Log.i("PatientResults - id", c.getString(nameIndex));
                Log.i("PatientResults - name", Integer.toString(c.getInt(ageIndex)));
                Log.i("PatientResults - age", Integer.toString(c.getInt(idIndex)));
                Log.i("PatientResults - gender", c.getString(nameIndex));

                c.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

