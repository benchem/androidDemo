package team.benchem.layoutdemo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

import team.benchem.layoutdemo.adapter.TodoModelRecyclerViewAdapter;
import team.benchem.layoutdemo.databinding.ActivityMainBinding;
import team.benchem.layoutdemo.viewmodel.TodoModel;

public class MainActivity extends Activity {

    final List<TodoModel> mDataSource = new ArrayList<>();

    TodoModelRecyclerViewAdapter mTodoRecyclerAdapter;

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

        TodoModel item1 = new TodoModel();
        item1.setTodo("Todo Item 1");
        mDataSource.add(item1);
        mTodoRecyclerAdapter = new TodoModelRecyclerViewAdapter(this, mDataSource);
        binding.activityMainRecyleview.setAdapter(mTodoRecyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.activityMainRecyleview.setLayoutManager(linearLayoutManager);
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
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(LogTAG, "MainActivity.onAttachedToWindow");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i(LogTAG, "MainActivity.onWindowFocusChanged");
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

    public void onAddTodoClick(View view) {
        TodoModel newItem = new TodoModel();
        newItem.setTodo(todoModel.getTodo());
        mDataSource.add(newItem);
        mTodoRecyclerAdapter.notifyDataSetChanged();

        todoModel.setTodo("");
    }

    public void onOpenClick(View view){
        Intent intent = new Intent(MainActivity.this, AddTodoActivity.class);
        Bundle bundle = new Bundle();
        String todoModelJson = JSON.toJSONString(todoModel);
        bundle.putString("todoModel", todoModelJson);
        intent.putExtras(bundle);
        startActivityForResult(intent, ADDTODO_ACTIVITY_REQUEST_CODE);
    }

    public void onOpenFragmentDemo(View view){
        Intent intent = new Intent(MainActivity.this, FragmentDemoActivity.class);
        startActivity(intent);
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
