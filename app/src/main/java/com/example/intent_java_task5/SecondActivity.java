package com.example.intent_java_task5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
        loadData();
    }

    private void initViews() {
        textView = findViewById(R.id.text_second);
        button = findViewById(R.id.btn_second);

        button.setOnClickListener(v -> {
            Member member = new Member("Kotlin", "Java");
            backToMainActivity(member);
        });
    }

    private void loadData() {
        User user = (User) getIntent().getSerializableExtra("key");
        textView.setText(user.toString());
    }

    private void backToMainActivity(Member member) {
        Intent intent = new Intent();
        intent.putExtra("member", member);
        setResult(RESULT_OK, intent);
        finish();
    }
}