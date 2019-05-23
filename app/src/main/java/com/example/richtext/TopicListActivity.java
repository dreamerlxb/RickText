package com.example.richtext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shuyu.textutillib.model.TopicModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicListActivity extends AppCompatActivity {

    public final static String DATA = "data";

    @BindView(R.id.user_list)
    ListView userList;

    private List<TopicModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);

        for (int i = 0; i < 50; i++) {
            TopicModel topicModel = new TopicModel();
            topicModel.setTopicName("测试话题" + i);
            topicModel.setTopicId(i * 30 + "");
            data.add(topicModel);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.user_list_item, data);
        userList.setAdapter(adapter);
        userList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent();
            intent.putExtra(DATA, data.get(position));
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}
