package com.apps.W9598404.ebooklearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardAdminActivity extends AppCompatActivity {

    FirebaseAuth auth;
    TextView tvSubTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);

        auth = FirebaseAuth.getInstance();
        tvSubTitle = findViewById(R.id.tvSubTitle);
        checkUser();
    }

    private void checkUser() {

        FirebaseUser user = auth.getCurrentUser();
        if (user==null){
            //not logged in, go to login
            startActivity(new Intent(DashboardAdminActivity.this, LoginActivity.class));
            finish();

        } else {
            //logged in, get user info
            String email = user.getEmail();
            tvSubTitle.setText(email);



        }

    }
}
