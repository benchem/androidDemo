package team.benchem.activitydemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import team.benchem.activitydemo.R;
import team.benchem.activitydemo.databinding.PopupActivityBinding;
import team.benchem.activitydemo.entity.Employee;

public class PopupActivity extends Activity {

    private final String LogTag = "activityDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // https://www.jianshu.com/p/ba4982be30f8
        PopupActivityBinding binding = PopupActivityBinding.inflate(getLayoutInflater());
        Employee emp = new Employee("001", "BenChan");
        binding.setEmp(emp);
        setContentView(R.layout.popup_activity);
        Log.i(LogTag, "PopupActivity.onCreate");
        if(savedInstanceState != null){
            Log.i(LogTag, "PopupActivity.onCreate -> savedInstanceState is not null");
        } else {
            Log.i(LogTag, "PopupActivity.onCreate -> savedInstanceState is null");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LogTag, "PopupActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LogTag, "PopupActivity.onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LogTag, "PopupActivity.onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(LogTag, "PopupActivity.onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LogTag, "PopupActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LogTag, "PopupActivity.onDestroy");
    }

}
