package com.sveri.myapp11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button btnLogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        btnLogin=(Button) findViewById(R.id.btnsignin1);
        DB= new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GroceryActivity.class);
                startActivity(intent);

                String user=username.getText().toString();
                String pass=password.getText().toString();

                if (user.equals("")||pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please enter all the feilds", Toast.LENGTH_SHORT).show();

                }
                else {
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Sing in Succussefuly", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

    }
}