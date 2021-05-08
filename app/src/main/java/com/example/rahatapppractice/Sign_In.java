
package com.example.rahatapppractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class Sign_In extends AppCompatActivity {
EditText et_email, et_pwd;
public static final String API_URL = "http://192.168.29.186:8080/API";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        et_email = getEditTextFromTL(R.id.et_email);
        et_pwd = getEditTextFromTL(R.id.et_pwd);
    }

    /**
     * Gets the edit text object from a textInputLayout
     * @param id ID of the textInputLayout
     * @return EditText
     */
    private EditText getEditTextFromTL(int id){
        TextInputLayout tl = findViewById(id);
        return tl.getEditText();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("email", et_email.getText().toString());
        outState.putString("pwd", et_pwd.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String email=savedInstanceState.getString("email"), pwd=savedInstanceState.getString("pwd");
        et_email.setText(email);
        et_pwd.setText(pwd);

        et_email.setSelection(email.length()); // moves the cursor to the words end
        et_pwd.setSelection(pwd.length());
    }

    public void signIn(View view){
        String email = et_email.getText().toString().trim().toUpperCase(),
               pwd = et_pwd.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL + "/authenticate",
                response -> {
                    if(response.equals("1")) {
                        startActivity(new Intent(this, Form_Request.class));
                        finish();
                    }
                    else
                        Toast.makeText(this, "Login unsuccessful"+response, Toast.LENGTH_SHORT).show();
                },
                error -> Toast.makeText(Sign_In.this, error.getMessage(), Toast.LENGTH_SHORT).show()
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> auth_data = new HashMap<>();
                auth_data.put("email", email);
                auth_data.put("password", pwd);
                return auth_data;
            }
        };

        MySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }


}