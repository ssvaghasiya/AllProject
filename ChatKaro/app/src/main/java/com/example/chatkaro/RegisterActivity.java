package com.example.chatkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mDisplayName;
    private TextInputLayout mEmail;
    private TextInputLayout mPassword;

    //private EditText mDisplayName;
//    private EditText mEmail;
//    private EditText mPassword;

    private Button mCreateBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

//        mDisplayName = (EditText)findViewById(R.id.reg_dispaly_name);
//        mEmail = (EditText)findViewById(R.id.reg_email);
//        mPassword = (EditText)findViewById(R.id.reg_password);
//        mCreateBtn = (Button)findViewById(R.id.start_reg_btn);

        mDisplayName = (TextInputLayout)findViewById(R.id.reg_display_name);
        mEmail = (TextInputLayout) findViewById(R.id.reg_email);
        mPassword = (TextInputLayout) findViewById(R.id.reg_password);
        mCreateBtn = (Button)findViewById(R.id.start_reg_btn);

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display_name = mDisplayName.getEditText().getText().toString();
                String email = mEmail.getEditText().getText().toString();
                String password = mPassword.getEditText().getText().toString();

              //  register_user(display_name,email,password);
            }
        });
    }


    private void register_user(String display_name,String email,String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent mainIntent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();

                }else {
                    Toast.makeText(RegisterActivity.this,"You got some error...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
