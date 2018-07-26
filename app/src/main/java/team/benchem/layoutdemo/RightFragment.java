package team.benchem.layoutdemo;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RightFragment extends Fragment {

    static RightFragment newInstance(String text){

        RightFragment fragment = new RightFragment();

        Bundle args = new Bundle();
        args.putString("text", text);
        fragment.setArguments(args);

        return fragment;
    }

    String initText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initText = getArguments() != null ? getArguments().getString("text") : "Rec....";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_right, null);
        TextView textView =  view.findViewById(R.id.module_fragment_right_tvMemo);
        textView.setText(initText);
        return view;
    }
}
