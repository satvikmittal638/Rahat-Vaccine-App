package com.example.rahatapppractice;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Form_Request extends AppCompatActivity {
private EditText et_name, et_aadhar, et_age, et_address, et_contact;
private HashMap<String, String> request;
private static final String TAG = "Form_Request";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form__request);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initializeViews();

    }

    private void initializeViews(){
        et_name = getEditTextFromTL(R.id.et_name);
        et_aadhar = getEditTextFromTL(R.id.et_aadhar);
        et_age = getEditTextFromTL(R.id.et_age);
        et_address = getEditTextFromTL(R.id.et_address);
        et_contact = getEditTextFromTL(R.id.et_contact);
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

    private HashMap<String, String> getDataFromUI(){
        HashMap<String, String> req_data=new HashMap<>();
        String name = et_name.getText().toString().trim().toUpperCase().trim();
        String aadhar_no = et_aadhar.getText().toString().trim().toUpperCase().trim();
        String age = et_age.getText().toString().trim().toUpperCase().trim();
        String gender="N".trim();
        String address = et_address.getText().toString().trim().toUpperCase().trim();
        String contact_no = et_contact.getText().toString().trim().toUpperCase().trim();

        if(dataIsAuthentic(aadhar_no, age, address, contact_no)){
            req_data.put("name", name);
            req_data.put("aadhar_no", aadhar_no);
            req_data.put("age", age);
            req_data.put("gender", gender);
            req_data.put("address", address);
            req_data.put("contact_no", contact_no);
        }else
            Toast.makeText(this, "Sorry the data entered is incorrect", Toast.LENGTH_SHORT).show();
        return req_data;

    }

    /**
     * Check the validity or authenticity of the data provided
     * @param aadhar_no
     * @param age
     * @param address
     * @param contact_no
     * @return Whether the info supplied is valid or not
     */
    private boolean dataIsAuthentic(String aadhar_no, String age, String address, String contact_no){
        Pattern aadharP = Pattern.compile("^[2-9][0-9]{11}");
        Matcher matcher1 = aadharP.matcher(aadhar_no);
        boolean aadharIsValid =matcher1.matches();

        boolean ageIsValid = Integer.parseInt(age) >5 && Integer.parseInt(age)<110;
        boolean addressIsValid = address.length() > 10;

        Pattern contactP = Pattern.compile("^[7-9][0-9]{9}");
        Matcher matcher2 =contactP.matcher(contact_no);
        boolean contactIsValid = matcher2.matches();

        return aadharIsValid && addressIsValid && ageIsValid && contactIsValid;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", et_name.getText().toString());
        outState.putString("aadhar", et_aadhar.getText().toString());
        outState.putString("age", et_age.getText().toString());
        outState.putString("address", et_address.getText().toString());
        outState.putString("contact", et_contact.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        et_name.setText(savedInstanceState.getString("name"));
        et_aadhar.setText(savedInstanceState.getString("aadhar"));
        et_age.setText( savedInstanceState.getString("age"));
        et_address.setText( savedInstanceState.getString("address"));
        et_contact.setText( savedInstanceState.getString("contact"));
    }

    public void submit_request(View view) {
        request = getDataFromUI();
        if(!request.isEmpty()) {
            StringRequest vaccine_request = new StringRequest(Request.Method.POST, Sign_In.API_URL + "/vacc_req",
                    response -> Toast.makeText(this, response, Toast.LENGTH_SHORT).show(),
                    error -> Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show()
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Log.d(TAG, "getParams: Request generated");
                    return request;
                }
            };

            MySingleton.getInstance(this).addToRequestQueue(vaccine_request);
        }
    }

}