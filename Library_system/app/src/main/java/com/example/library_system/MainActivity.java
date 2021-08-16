package com.example.library_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.library_system.models.User;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public TextView emailAddress, fullName, greeting;
    private Button logout;
    private ImageButton btnmenu;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(100);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        

        logout = (Button) findViewById(R.id.logout);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();
        TextView mail = findViewById(R.id.emailAddress);
        mail.setText(email);

        emailAddress = findViewById(R.id.emailAddress);
        greeting = findViewById(R.id.greeting);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_quest:
                Intent intent_main = new Intent(this, QuestActivity.class);
                startActivity(intent_main);
                break;
            case R.id.nav_about_us:
                Intent intent_one = new Intent(this, About_Library_Activity.class);
                startActivity(intent_one);
                break;
            case R.id.nav_location:
                Intent intent_two = new Intent(this, MapsActivity.class);
                startActivity(intent_two);
                break;
            case R.id.nav_contacts:
                Intent intent_three = new Intent(this, Contacts_Activity.class);
                startActivity(intent_three);
                break;
            case R.id.nav_books_ex:
                Intent intent_f = new Intent(this, BooksActivityEx.class);
                startActivity(intent_f);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}

