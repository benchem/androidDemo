package team.benchem.layoutdemo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSONObject;

import team.benchem.layoutdemo.databinding.ActivityAddtodoBinding;
import team.benchem.layoutdemo.viewmodel.TodoModel;

public class AddTodoActivity extends Activity {

    private TodoModel todoModel;

    final String LogTAG = "layoutDemo";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtodo);
        Log.i(LogTAG, "AddTodoActivity.onCreate");

        Intent intent = getIntent();
        String todoJson =  intent.getExtras().getString("todoModel");
        todoModel = JSONObject.parseObject(todoJson).toJavaObject(TodoModel.class);

        ActivityAddtodoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_addtodo);
        binding.setTodoObj(todoModel);
        binding.setEventHanlder(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LogTAG, "AddTodoActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LogTAG, "AddTodoActivity.onResume");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(LogTAG, "AddTodoActivity.onAttachedToWindow");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i(LogTAG, "AddTodoActivity.onWindowFocusChanged");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LogTAG, "AddTodoActivity.onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(LogTAG, "AddTodoActivity.onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LogTAG, "AddTodoActivity.onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LogTAG, "AddTodoActivity.onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LogTAG, "AddTodoActivity.onDestroy");
    }

    public void onOkClick(View view){
        if(todoModel != null) {
            Intent result = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("todoModel", JSONObject.toJSONString(todoModel));
            result.putExtras(bundle);
            setResult(RESULT_OK, result);
        } else {
            setResult(RESULT_CANCELED);
        }
        finish();
    }

    public void onCancelClick(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
