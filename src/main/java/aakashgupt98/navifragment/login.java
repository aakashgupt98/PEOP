package aakashgupt98.navifragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private EditText email;
    private EditText password;
    private CheckBox saveLoginCheckBox;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login =(Button)findViewById(R.id.login);
        login.setOnClickListener(this);

        email=(EditText)findViewById(R.id.emaillogin);
        password=(EditText)findViewById(R.id.passwordlogin);

        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            email.setText(loginPreferences.getString("username", ""));
            password.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }

        progressDialog=new ProgressDialog(this);
        firebaseAuth= FirebaseAuth.getInstance();

    }

    private void userLogin() {
        String putEmail = email.getText().toString().trim();
        String identifyEmail = putEmail.substring(putEmail.indexOf('@'));
        String putPassword = password.getText().toString().trim();
        String studentEmail = "@stu.upes.ac.in";
        String facultyEmail = "@ddn.upes.ac.in";


        if (TextUtils.isEmpty(putEmail)) {
            Toast.makeText(this, "Plaese enter the email", Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(putPassword)) {
            Toast.makeText(this, "Please enter the password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        if (identifyEmail.equals(studentEmail)) {
            firebaseAuth.signInWithEmailAndPassword(putEmail, putPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                finish();
                                startActivity(new Intent(getApplicationContext(), NaviActivity.class));
                            } else {
                                Toast.makeText(login.this, "login Failed please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }


        if (identifyEmail.equals(facultyEmail)) {

            firebaseAuth.signInWithEmailAndPassword(putEmail, putPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                finish();
                                startActivity(new Intent(getApplicationContext(), InfofacultyActivity.class));
                            } else {
                                Toast.makeText(login.this, "login Failed please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }


    }
    private void sendEmailVerification() {
        // Disable button
        findViewById(R.id.resetpass).setEnabled(false);

        // Send verification email
        // [START send_email_verification]
        final FirebaseUser user = firebaseAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // [START_EXCLUDE]
                        // Re-enable button
                        findViewById(R.id.resetpass).setEnabled(true);

                        if (task.isSuccessful()) {
                            Toast.makeText(login .this,
                                    "Verification email sent to " + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(TAG, "sendEmailVerification", task.getException());
                            Toast.makeText(login.this,
                                    "Failed to send verification email.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // [END_EXCLUDE]
                    }
                });
        // [END send_email_verification]
    }

    @Override
    public void onClick(View view) {

//        if(view == signin){
//            finish();
//            startActivity(new Intent(this,MainActivity.class));
//        }
        int i = view.getId();
        if(view == login)
        {
            String putEmail = email.getText().toString();
            String putPassword = password.getText().toString();

            if (saveLoginCheckBox.isChecked()) {
                loginPrefsEditor.putBoolean("saveLogin", true);
                loginPrefsEditor.putString("username", putEmail);
                loginPrefsEditor.putString("password", putPassword);
                loginPrefsEditor.commit();
            } else {
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();
            }
            userLogin();

        }
        else if (i == R.id.resetpass) {
            sendEmailVerification();
        }
    }


    public void resetpass(View v)
    {
        startActivity(new Intent(login.this,ForgotpasswordActivity.class));
    }
}
