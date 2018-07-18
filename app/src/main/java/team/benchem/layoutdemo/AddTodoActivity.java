package team.benchem.layoutdemo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.fastjson.JSONObject;

import team.benchem.layoutdemo.databinding.ActivityAddtodoBinding;
import team.benchem.layoutdemo.viewmodel.TodoModel;

public class AddTodoActivity extends Activity {

    private TodoModel todoModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtodo);

        Intent intent = getIntent();
        String todoJson =  intent.getExtras().getString("todoModel");
        todoModel = JSONObject.parseObject(todoJson).toJavaObject(TodoModel.class);

        ActivityAddtodoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_addtodo);
        binding.setTodoObj(todoModel);
        binding.setEventHanlder(this);
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
