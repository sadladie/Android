package com.example.library_system;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class ResultActivity extends AppCompatActivity {
    private Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btn_back = (Button) findViewById(R.id.btn_back);
        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        TextView totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);
        totalScore += score;
        resultLabel.setText(score + "/6");
        totalScoreLabel.setText("Общий счет: " + totalScore);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();
    }
}