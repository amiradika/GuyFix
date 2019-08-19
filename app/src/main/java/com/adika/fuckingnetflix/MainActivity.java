package com.adika.fuckingnetflix;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    ProgressDialog PD;
    Button comedy, drama, romantic, anime, action;
    ImageView i1 , i2 , i3 , i4 , i5 , i6;



    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);
        comedy = (Button) findViewById(R.id.c);
        drama = (Button) findViewById(R.id.d);
        romantic = (Button) findViewById(R.id.r);
        anime = (Button) findViewById(R.id.an);
        action = (Button) findViewById(R.id.ac);
        i1 = (ImageView)findViewById(R.id.imageView1);
        i2 = (ImageView)findViewById(R.id.imageView2);
        i3 = (ImageView)findViewById(R.id.imageView3);
        i4 = (ImageView)findViewById(R.id.imageView4);
        i5 = (ImageView)findViewById(R.id.imageView5);
        i6 = (ImageView)findViewById(R.id.imageView6);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii1 = new Intent(MainActivity.this, friends.class);
                startActivity(ii1);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii2 = new Intent(MainActivity.this, Game.class);
                startActivity(ii2);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii3 = new Intent(MainActivity.this,howimetyourmother.class );
                startActivity(ii3);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii4 = new Intent(MainActivity.this, suits.class);
                startActivity(ii4);
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii5 = new Intent(MainActivity.this,southpark.class);
                startActivity(ii5);
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii6 = new Intent(MainActivity.this, bigbangtheory.class);
                startActivity(ii6);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Home) {
            Intent ihome = new Intent(this, MainActivity.class);
            startActivity(ihome);
            recreate();
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

                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
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

    @Override    protected void onResume() {
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        super.onResume();
    }


    public void D(View view) {
        Intent idrama = new Intent(this, Drama.class);
        startActivity(idrama);
    }

    public void C(View view) {
        Intent icomedy = new Intent(this, Comedy.class);
        startActivity(icomedy);
    }

    public void R(View view) {
        Intent iromantic = new Intent(this, Romantic.class);
        startActivity(iromantic);
    }

    public void AN(View view) {
        Intent ianime = new Intent(this, Anime.class);
        startActivity(ianime);
    }

    public void AC(View view) {
        Intent iaction = new Intent(this, Action.class);
        startActivity(iaction);
    }
}