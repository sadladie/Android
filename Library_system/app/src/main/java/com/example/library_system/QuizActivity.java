package com.example.library_system;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
public class QuizActivity extends AppCompatActivity {
    private TextView countLabel, questionLabel;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;
    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 6;
    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    String[][] quizData = {
            {"О приключениях смелой Элли рассказал этот писатель", "Александр Волков", "Евгений Шварц", "Ирина Токмакова", "Тамара Крюкова"},
            {"Его историю «Кто сказал мяу?» знают и любят все дети", "Владимир Сутеев", "Корней Чуковский", "Андрей Усачев", "Григорий Остер"},
            {"Автор поучительной сказки «Путаница»", "Корней Чуковский", "Елена Усачева", "Григорий Остер", "Александр Волков"},
            {"Кто написал детективную историю «Живая шляпа?»", "Николай Носов", "Тамара Крюкова", "Ирина Токмакова", "Агния Барто"},
            {"Главный герой поэтического произведения «Дядя Степа» был очень похож на самого автора", "Сергей Михалков", "Андрей Некрасов", "Евгений Шварц", "Андрей Усачев"},
            {"Рассказы этой писательницы, в том числе и «Волшебное слово», хорошо знакомы школьникам", "Валентина Осеева", "Астрид Линдгрен", "Холли Вебб", "Джоан Роулинг"},
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        countLabel = (TextView) findViewById(R.id.countLabel);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        answerBtn1 = (Button) findViewById(R.id.answerBtn1);
        answerBtn2 = (Button) findViewById(R.id.answerBtn2);
        answerBtn3 = (Button) findViewById(R.id.answerBtn3);
        answerBtn4 = (Button) findViewById(R.id.answerBtn4);

        for (int i = 0; i < quizData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //question
            tmpArray.add(quizData[i][1]); //right answer
            tmpArray.add(quizData[i][2]); //choice1
            tmpArray.add(quizData[i][3]); //choice2
            tmpArray.add(quizData[i][4]); //choice3
            quizArray.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz() {
        countLabel.setText("Q" + quizCount);
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        ArrayList<String> quiz = quizArray.get(randomNum);
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);
        quiz.remove(0);
        Collections.shuffle(quiz);
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));
        quizArray.remove(randomNum);
    }
    public void checkAnswer(View view) {
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        String alertTitle;
        if (btnText.equals(rightAnswer)) {
            alertTitle = "Правильно!";
            rightAnswerCount++;
        } else {
            alertTitle = "Неправильно...";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Ответ: " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);
                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}