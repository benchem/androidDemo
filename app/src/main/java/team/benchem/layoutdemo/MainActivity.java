package team.benchem.layoutdemo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import team.benchem.layoutdemo.databinding.ActivityMainBinding;
import team.benchem.layoutdemo.viewmodel.TodoModel;

public class MainActivity extends Activity {

    final TodoModel todoModel = new TodoModel();

    final int ADDTODO_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoModel.setTodo("Hello world!");

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setTodoItem(todoModel);
        binding.setEvenHandler(this);
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
