package itsj.proyectoinnovacion.Activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import itsj.proyectoinnovacion.Common.AppDataBase;
import itsj.proyectoinnovacion.R;

public class MainActivity extends AppCompatActivity {

    public static AppDataBase db; //= Room.databaseBuilder(MainActivity.this, AppDataBase.class, "db").allowMainThreadQueries().build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(MainActivity.this, AppDataBase.class, "db").allowMainThreadQueries().build();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 4000);
    }
}
