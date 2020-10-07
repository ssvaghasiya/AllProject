package com.example.firebaseapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editText , editText2;
   private Button button;
   TextView textView;

    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mRef = new Firebase("https://users-48a20.firebaseio.com/user1/user1/name");

        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        textView = (TextView)findViewById(R.id.textView2);

//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String value = editText.getText().toString();
//                String key  = editText2.getText().toString();
//                Firebase mRefChild = mRef.child("user1");
//                Firebase mRefchild1 = mRefChild.child(key);
//                mRefchild1.setValue(value);
//
//         //       mRef.push().setValue(value);
//                Toast.makeText(MainActivity.this,"Data Inserted...",Toast.LENGTH_SHORT).show();
//            }
//        });

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String data = dataSnapshot.getValue(String.class);
                textView.setText(data);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
