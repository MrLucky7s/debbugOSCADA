package hr.ferit.bruno.exercise1.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.ferit.bruno.exercise1.R;
import hr.ferit.bruno.exercise1.TasksRepository;
import hr.ferit.bruno.exercise1.model.Task;

public class MainActivity extends AppCompatActivity {

    TasksRepository mRepository;

    @BindView(R.id.edittext_newtask_title)
    EditText mTitle;
    @BindView(R.id.edittext_newtask_summary)
    EditText mSummary;
    @BindView(R.id.edittext_newtask_importance)
    EditText mImportance;
    @BindView(R.id.textview_newtask_display)
    TextView mDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRepository = TasksRepository.getInstance();
    }


    @OnClick(R.id.button_newtask_save)
    public void saveTask(View view) {

        // ToDo: 	store the task
        // Parse data from the widgets and store it in a task
        // Store the task in the fake database using the repository
        String title = mTitle.getText().toString();
        String summary = mSummary.getText().toString();
        int importance = Integer.parseInt(mImportance.getText().toString());
        Task task = new Task(importance,title,summary);

        // ToDo:	clear the UI for the new task
        // Clear all of the editText controls
        mTitle.setText("");
        mSummary.setText("");
        mImportance.setText("");

        // ToDo: 	define a method
        // Create a method for displaying the tasks in the textview as strings
        // one below the other and call it on each new task.
        mDisplay.setText(title +" " + summary+" "+importance);
    }
}
