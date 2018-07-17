package team.benchem.activitydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import team.benchem.activitydemo.R;

public class MainActivity extends AppCompatActivity {

    private final String LogTag = "activityDemo";

    private Button btnOpenActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LogTag, "MainActivity.onCreate");
        if(savedInstanceState != null){
            Log.i(LogTag, "MainActivity.onCreate -> savedInstanceState is not null");
        } else {
            Log.i(LogTag, "MainActivity.onCreate -> savedInstanceState is null");
        }

        btnOpenActivity = findViewById(R.id.button);
        btnOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PopupActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LogTag, "MainActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LogTag, "MainActivity.onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LogTag, "MainActivity.onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(LogTag, "MainActivity.onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LogTag, "MainActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LogTag, "MainActivity.onDestroy");
    }
}
