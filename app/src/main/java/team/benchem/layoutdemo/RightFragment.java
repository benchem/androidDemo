package team.benchem.layoutdemo;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RightFragment extends Fragment {

    static RightFragment newInstance(String text){

        RightFragment fragment = new RightFragment();

        Bundle args = new Bundle();
        args.putString("text", text);
        fragment.setArguments(args);

        return fragment;
    }

    String initText;
    RightFragmentBinding binding;
    Bundle savedInstanceState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initText = getArguments() != null ? getArguments().getString("text") : "Rec....";
        this.savedInstanceState = savedInstanceState;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.module_fragment_right, container, false);
        binding.setInitText(initText);
        if(savedInstanceState != null){
            binding.moduleFragmentRightEtInput.setText(savedInstanceState.getString("txtInput"));
        }
        return binding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("txtInput", binding.getInitText());
    }
}
