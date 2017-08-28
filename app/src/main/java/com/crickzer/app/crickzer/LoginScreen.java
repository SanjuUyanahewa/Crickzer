package com.crickzer.app.crickzer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnBackToLive1;
    ImageButton btnreatAcc;
    ImageButton buttonSignIn;

        //defining views
        //private Button buttonSignIn;
        private EditText editTextEmail;
        private EditText editTextPassword;
        private TextView textViewSignup;

        //firebase auth object
        private FirebaseAuth firebaseAuth;

        //progress dialog
        private ProgressDialog progressDialog;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_screen);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            btnBackToLive1 = (ImageButton) findViewById(R.id.backToLive1);

            btnBackToLive1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentLoadNewActivity = new Intent(LoginScreen.this, ThirdScreen.class);
                    startActivity(intentLoadNewActivity);
                }
            });

            btnreatAcc = (ImageButton) findViewById(R.id.creatAcc);

            btnreatAcc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentLoadNewActivity = new Intent(LoginScreen.this, RegScreen.class);
                    startActivity(intentLoadNewActivity);
                }
            });


            //getting firebase auth object
            firebaseAuth = FirebaseAuth.getInstance();

            //if the objects getcurrentuser method is not null
            //means user is already logged in
            if(firebaseAuth.getCurrentUser() != null){
                //close this activity
                finish();
                //opening profile activity
                startActivity(new Intent(getApplicationContext(), PredictionScreen.class));
            }

            //initializing views
            editTextEmail = (EditText) findViewById(R.id.editText);
            editTextPassword = (EditText) findViewById(R.id.editText6);
            buttonSignIn = (ImageButton) findViewById(R.id.imageButton7);
            //buttonSignIn = (Button) findViewById(R.id.imageButton7);
            //textViewSignup  = (TextView) findViewById(R.id.textViewSignUp);

           // textViewSignup = (ImageButton) findViewById(R.id.imageButton5);

            progressDialog = new ProgressDialog(this);

            //attaching click listener
            buttonSignIn.setOnClickListener(this);
           //textViewSignup.setOnClickListener(this);
        }

        //method for user login
        private void userLogin(){
            String email = editTextEmail.getText().toString().trim();
            String password  = editTextPassword.getText().toString().trim();


            //checking if email and passwords are empty
            if(TextUtils.isEmpty(email)){
                Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(password)){
                Toast.makeText(this,"Please enter password", Toast.LENGTH_LONG).show();
                return;
            }

            //if the email and password are not empty
            //displaying a progress dialog

            progressDialog.setMessage("Loaging Please Wait...");
            progressDialog.show();

            //logging in the user
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            //if the task is successfull
                            if(task.isSuccessful()){
                                //start the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), PredictionScreen.class));
                            }
                        }
                    });

        }

        @Override
        public void onClick(View view) {
            if(view == buttonSignIn){
                userLogin();
            }

            if(view == textViewSignup){
                finish();
                startActivity(new Intent(this, RegScreen.class));
            }
        }



    }

