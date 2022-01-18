package com.example.intent_java_task5;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        textView = findViewById(R.id.text_main);
        Button button = findViewById(R.id.btn_main);

        button.setOnClickListener(v -> {
            User user = new User("Android", "12");
            openSecondActivity(user);
        });
    }

    private void openSecondActivity(User user) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key", user);
        getMemberSecondActivity.launch(intent);
    }

    ActivityResultLauncher<Intent> getMemberSecondActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    assert data != null;
                    textView.setText(data.getSerializableExtra("member").toString());
                }
            }
    );
}