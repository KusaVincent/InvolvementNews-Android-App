package com.example.invorun03;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Register extends AppCompatActivity {

    Button submit;
    EditText username, email, password;
    TextView log;

    JSONObject json_data;
    HttpURLConnection con;
    String query, results;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        submit = findViewById(R.id.submit);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        log = findViewById(R.id.log);
        username.addTextChangedListener(searchTextWatcher);
        password.addTextChangedListener(searchTextWatcher);
        email.addTextChangedListener(searchTextWatcher);

        submit.setEnabled(false);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Login.class);
                startActivity(myIntent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Create().execute();
            }
        });

    }
    private TextWatcher searchTextWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String pass = password.getText().toString().trim();
            String user = username.getText().toString().trim();
            String mail = email.getText().toString().trim();

            submit.setEnabled(!user.isEmpty() && !pass.isEmpty() && !mail.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };



    final class Create extends AsyncTask<String, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(Register.this);
            mProgressDialog.setMessage("Creating record please wait..");
            mProgressDialog.setIndeterminate(false);

            mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("username", username.getText().toString().trim())
                        .appendQueryParameter("email", email.getText().toString().trim())
                        .appendQueryParameter("password", password.getText().toString().trim());
                query = builder.build().getEncodedQuery();
                String url = "https://kusavin.000webhostapp.com/Trial/create.php";
                URL obj = new URL(url);
                con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
                con.setRequestProperty("Accept-Language", "UTF-8");
                con.setDoOutput(true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
                outputStreamWriter.write(query);
                outputStreamWriter.flush();
            } catch (Exception e) {
                android.util.Log.e("Fail 1", e.toString());
            }

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line + "\n");
                }
                results = sb.toString();
            } catch (Exception e) {
                android.util.Log.e("Fail 2", e.toString());

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            try {

                json_data = new JSONObject(results);
                int code = (json_data.getInt("code"));
                if (code == 1) {
                    final AlertDialog.Builder alert = new AlertDialog.Builder(Register.this);
                    alert.setTitle("Success");
                    alert.setMessage("Student Record Created");
                    alert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(@NonNull DialogInterface dialog, int whichButton) {
                            dialog.cancel();
                        }
                    });
                    String str = username.getText().toString();
                    Intent intents = new Intent(getApplicationContext(), MainActivity.class);
                    intents.putExtra("message", str);
                    startActivity(intents);
                    alert.show();
                } else {
                    final AlertDialog.Builder alert = new AlertDialog.Builder(Register.this);
                    alert.setTitle("Failed");
                    alert.setMessage("Creating Student Failed");
                    alert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(@NonNull DialogInterface dialog, int whichButton) {
                            dialog.cancel();
                        }

                    });
                    alert.show();

                }
            } catch (Exception e) {
                Log.e("Fail 3", e.toString());

            }
            mProgressDialog.dismiss();
        }
    }
}