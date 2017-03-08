package com.oak.vaishnaviponna.oak_oneofakind;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityLogin extends AppCompatActivity {
    private EditText txtEmailLogin;
    private EditText txtpwd;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_design_login_form);
        txtEmailLogin = (EditText) findViewById(R.id.txtEmailLogin);
        txtpwd = (EditText) findViewById(R.id.txtPasswordLogin);
        firebaseAuth =  firebaseAuth.getInstance();
    }
    public void btnUserLogin_Click(View v){
        final ProgressDialog progressDialog = ProgressDialog.show(ActivityLogin.this, "Please wait..", "Processing", true);
        (firebaseAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(), txtpwd.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful())
                {
                    Toast.makeText(ActivityLogin.this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(ActivityLogin.this, SelectPhoto.class);
                    i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                  //  i.putExtra("phoneno",getIntent().getExtras().getString("phoneno"));
                  //  i.putExtra("username",getIntent().getExtras().getString("username"));
                    startActivity(i);
                }
                else {
                    Log.e("Error", task.getException().toString());
                    Toast.makeText(ActivityLogin.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

