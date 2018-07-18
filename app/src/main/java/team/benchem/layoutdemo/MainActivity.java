package team.benchem.layoutdemo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import team.benchem.layoutdemo.databinding.ActivityMainBinding;
import team.benchem.layoutdemo.viewmodel.TodoModel;

public class MainActivity extends Activity {

    final TodoModel todoModel = new TodoModel();

    final String LogTAG = "layoutDemo";

    final int ADDTODO_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LogTAG, "MainActivity.onCreate");
        
        todoModel.setTodo("Hello world!");

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setTodoItem(todoModel);
        binding.setEvenHandler(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LogTAG, "MainActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LogTAG, "MainActivity.onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LogTAG, "MainActivity.onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(LogTAG, "MainActivity.onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LogTAG, "MainActivity.onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LogTAG, "MainActivity.onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LogTAG, "MainActivity.onDestroy");
    }

    public void onAddTodoClick(View view){
        Intent intent = new Intent(MainActivity.this, AddTodoActivity.class);
        Bundle bundle = new Bundle();
        String todoModelJson = JSON.toJSONString(todoModel);
        bundle.putString("todoModel", todoModelJson);
        intent.putExtras(bundle);
        startActivityForResult(intent, ADDTODO_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADDTODO_ACTIVITY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String modelJson = data.getExtras().getString("todoModel");
                TodoModel resultModel = JSONObject.parseObject(modelJson).toJavaObject(TodoModel.class);
                todoModel.setTodo(resultModel.getTodo());
            }
        }
    }

    public void onResetClick(View view){
        todoModel.setTodo("Reset~~~");
    }

    public void onBindingClick(View view){
        Toast toast = Toast.makeText(MainActivity.this, todoModel.getTodo(), Toast.LENGTH_SHORT);
        toast.show();
    }
}
