package com.adika.fuckingnetflix;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Anime extends AppCompatActivity {
    FirebaseAuth auth;
    ImageView i1 , i2 , i3 , i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        auth = FirebaseAuth.getInstance();
        i1 = (ImageView)findViewById(R.id.imageView1);
        i2 = (ImageView)findViewById(R.id.imageView2);
        i3 = (ImageView)findViewById(R.id.imageView3);
        i4 = (ImageView)findViewById(R.id.imageView4);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii1 = new Intent(Anime.this, onepiece.class);
                startActivity(ii1);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii2 = new Intent(Anime.this, HunterXHunter.class);
                startActivity(ii2);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii3 = new Intent(Anime.this,OnePunchMan.class );
                startActivity(ii3);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii4 = new Intent(Anime.this, Naruto.class);
                startActivity(ii4);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Home) {
            Intent ihome = new Intent(this, MainActivity.class);
            startActivity(ihome);
            finish();
        }
        if (id==R.id.so)
        {
            auth.signOut();
            final FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user == null) {

                        startActivity(new Intent(Anime.this, LoginActivity.class));

                    }
                }
            };
        }
        if (id==R.id.ps)
        {
            startActivity(new Intent(getApplicationContext(), ForgetAndChangePasswordActivity.class).putExtra("Mode", 1));
        }
        return super.onOptionsItemSelected(item);
    }

}
