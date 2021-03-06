package team.benchem.layoutdemo;

import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import team.benchem.layoutdemo.databinding.ModuleActivityFragmentdemoBinding;

/**
 * https://developer.android.com/reference/android/app/Fragment
 */
public class FragmentDemoActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_fragmentdemo);

        ModuleActivityFragmentdemoBinding binding = DataBindingUtil.setContentView(this, R.layout.module_activity_fragmentdemo);
        binding.setEventHandler(this);

        LeftFragment leftFragment = new LeftFragment();
        RightFragment rightFragment = new RightFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.module_activity_fragmentdemo_leftFragment, leftFragment);
        transaction.replace(R.id.module_activity_fragmentdemo_rightFragment, rightFragment);
        transaction.commit();
    }

    public void onSend(View view){

        //方法1
        TextView textView = findViewById(R.id.module_fragment_left_tvMemo);
        textView.setText("AAAAA1");

        //方法2
        RightFragment fragment = RightFragment.newInstance("AAAAA2");
        FragmentTransaction trans =  getFragmentManager().beginTransaction();
        trans.replace(R.id.module_activity_fragmentdemo_rightFragment, fragment);
        trans.commit();
    }
}
