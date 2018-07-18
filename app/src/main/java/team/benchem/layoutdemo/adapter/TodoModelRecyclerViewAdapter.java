package team.benchem.layoutdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import team.benchem.layoutdemo.R;
import team.benchem.layoutdemo.databinding.ModuleRecycleItemTodoitemBinding;
import team.benchem.layoutdemo.viewmodel.TodoModel;

public class TodoModelRecyclerViewAdapter extends RecyclerView.Adapter<TodoModelViewHolder> {

    final List<TodoModel> mDataSource;

    final Context mContext;

    final LayoutInflater mInflater;

    public TodoModelRecyclerViewAdapter(Context mContext, List<TodoModel> mDataSource) {
        this.mContext = mContext;
        this.mDataSource = mDataSource == null ? new ArrayList<TodoModel>() : mDataSource;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public TodoModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.module_recycle_item_todoitem, parent, false);
        ModuleRecycleItemTodoitemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.module_recycle_item_todoitem,
                parent,
                false
        );
        TodoModelViewHolder holder = new TodoModelViewHolder(itemBinding.getRoot());
        return holder;
    }

    @Override
    public void onBindViewHolder(TodoModelViewHolder holder, int position) {
        ModuleRecycleItemTodoitemBinding itemBinding = DataBindingUtil.getBinding(holder.itemView);
        itemBinding.setTodoItem(mDataSource.get(position));
        itemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }
}
