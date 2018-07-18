package team.benchem.layoutdemo.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.UUID;

import team.benchem.layoutdemo.BR;

public class TodoModel extends BaseObservable {

    private String id;
    private Boolean finished;
    private String todo;

    public TodoModel() {
        id = UUID.randomUUID().toString();
        finished=false;
        todo="";
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
        notifyPropertyChanged(BR.finished);
    }

    @Bindable
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
        notifyPropertyChanged(BR.todo);
    }
}
