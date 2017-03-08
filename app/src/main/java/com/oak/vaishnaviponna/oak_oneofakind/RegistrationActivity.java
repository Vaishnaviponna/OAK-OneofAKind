package com.oak.vaishnaviponna.oak_oneofakind;

import android.app.ProgressDialog;

       import android.app.Activity;
import android.content.Intent;
        import android.support.annotation.NonNull;
import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class RegistrationActivity extends Activity {
    private FirebaseAuth firebaseAuth;
    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextPhoneno;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private EditText editTextPincode;
    private TextView textViewPersons=null;
    private Button buttonSave;
    private Firebase mref;
    ArrayList<String> mylist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_design_reg_form);
        try {

            Firebase.setAndroidContext(this);
            firebaseAuth = FirebaseAuth.getInstance();
            buttonSave = (Button) findViewById(R.id.buttonSave);
            mref = new Firebase("https://logine-ba180.firebaseio.com/");
            editTextName = (EditText) findViewById(R.id.editTextName);
            editTextAddress = (EditText) findViewById(R.id.editTextAddress);
            editTextEmail = (EditText) findViewById(R.id.editTextEmail);
            editTextPassword = (EditText) findViewById(R.id.editTextPassword);
            editTextPhoneno = (EditText) findViewById(R.id.editTextPhoneno);
            editTextPincode = (EditText) findViewById(R.id.editTextPincode);


            textViewPersons = (TextView) findViewById(R.id.textViewPersons);

            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creating firebase object
//                    final Firebase ref = new Firebase("https://logine-ba180.firebaseio.com/");

                    //Getting values to store
                    String name = editTextName.getText().toString().trim();
                    String address = editTextAddress.getText().toString().trim();
                    String email = editTextEmail.getText().toString().trim();
                    String password = editTextPassword.getText().toString().trim();
                    String pincode = editTextPincode.getText().toString().trim();
                    String phoneno = editTextPhoneno.getText().toString().trim();
                    //Creating Person object
                    final Person person = new Person();

                    //Adding values
                    person.setName(name);
                    person.setAddress(address);
                    person.setPincode(pincode);
                    person.setEmail(email);
                    person.setPassword(password);
                    person.setPhoneno(phoneno);

                    //Storing values to firebase
                  //  ref.child("Person").push().setValue(person);
                    String  ref1 =    mref.getKey();
                    mylist.add(ref1);
                    int count= mylist.size();
                    String c = Integer.toString(count);
                    String k = mref.getKey();
                 //   textViewPersons.setText(k);

                    final ProgressDialog progressDialog = ProgressDialog.show(RegistrationActivity.this, "please wait..", "processing...", true);
                    (firebaseAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                mref.child("Person").push().setValue(person);
                                Toast.makeText(RegistrationActivity.this, "Registarion successful", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                                i.putExtra("phoneno", person.getPhoneno());
                                i.putExtra("username",person.getName());
                                startActivity(i);
                            } else {
                                Log.e("Error", task.getException().toString());
                                Toast.makeText(RegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }


                        }
                    });


                /*    ref.child(name).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

//                            User user = dataSnapshot.getValue(User.class);
                           // Person person = dataSnapshot.getValue(Person.class);
                            textViewPersons.setText(count);
                           // Log.d(TAG, "User name: " + person.getName() + ", email " + person.getAddress());
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                           // Log.w(TAG, "Failed to read value.", firebaseError.toException());
                        }


                    });
                    //Value event listener for realtime data update
                   /* ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {

                            try {
                                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                    //Getting the data from snapshot
                                    Person person = postSnapshot.getValue(Person.class);

                                    //Adding it to a string
                                    String string = "Name: " + person.getName() + "\nAddress: " + person.getAddress() + "\n\n";

                                    //Displaying it on textview
                                    textViewPersons.setText(string);


                                    List<String> lst = new ArrayList<String>(); // Result will be holded Here
                                    for (DataSnapshot dsp : snapshot.getChildren()) {
                                        lst.add(String.valueOf(dsp.getKey()));
                                    }

                                    for (String data : lst) {
                                        Context context = null;
                                        Toast.makeText(context, data, Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                            catch (Exception e)
                            {

                            }

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            //System.out.println("The read failed: " + firebaseError.getMessage());
                        }

                    });  */

                }
            });
        }
        catch ( Exception e)
        {

        }

    }

}
