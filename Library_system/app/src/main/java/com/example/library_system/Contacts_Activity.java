package com.example.library_system;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
public class Contacts_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        TextView email_1 = (TextView) findViewById(R.id.t_one_mail);
        email_1.setText(Html.fromHtml("<a href=\"mailto:library-CBS@mail.ru\">library-CBS@mail.ru</a>"));
        email_1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView email_2 = (TextView) findViewById(R.id.t_two_mail);
        email_2.setText(Html.fromHtml("<a href=\"mailto:library-zam@mail.ru\">library-zam@mail.ru</a>"));
        email_2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView email_3 = (TextView) findViewById(R.id.t_three_mail);
        email_3.setText(Html.fromHtml("<a href=\"mailto:BS_abonement@mail.ru\">BS_abonement@mail.ru</a>"));
        email_3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView email_4 = (TextView) findViewById(R.id.t_four_mail);
        email_4.setText(Html.fromHtml("<a href=\"mailto:library-SIO@mail.ru\">library-SIO@mail.ru</a>"));
        email_4.setMovementMethod(LinkMovementMethod.getInstance());
        TextView email_5 = (TextView) findViewById(R.id.t_five_mail);
        email_5.setText(Html.fromHtml("<a href=\"mailto:CBS-read@mail.ru\">CBS-read@mail.ru</a>"));
        email_5.setMovementMethod(LinkMovementMethod.getInstance());
        TextView email_6 = (TextView) findViewById(R.id.t_six_mail);
        email_6.setText(Html.fromHtml("<a href=\"mailto:library-kadr@mail.ru\">library-kadr@mail.ru</a>"));
        email_6.setMovementMethod(LinkMovementMethod.getInstance());
    }
}