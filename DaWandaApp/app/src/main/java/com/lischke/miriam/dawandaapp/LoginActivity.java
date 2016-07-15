package com.lischke.miriam.dawandaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lischke.miriam.dawandaapp.model.Session;
import com.lischke.miriam.dawandaapp.model.Singleton;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class LoginActivity extends AppCompatActivity {

    TextView email;
    TextView password;
    Button enterButton;


    public interface DawandaService {

        String KEY_USER = "user[email_or_username]";
        String KEY_PASSWORD = "user[password]";

        @FormUrlEncoded
        @POST("/core/mobile/sessions")
        Call<Session> loginUserEachByEach(@Field(KEY_USER) String user, @Field(KEY_PASSWORD) String password);

        @FormUrlEncoded
        @POST("/core/mobile/sessions")
        Call<Session> loginUserMap(@FieldMap() Map<String, String> keyMap);;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);
        enterButton = (Button) findViewById(R.id.email_sign_in_button);

        enterButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
               if( loginCheck()){

                   sessionIdRequest();
               }
            }
         });



    }

    private void sessionIdRequest() {
        Toast.makeText(LoginActivity.this,"Eingabe: "+email.getText().toString()+", "+password.getText().toString(),Toast.LENGTH_LONG).show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://de.dawanda.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DawandaService service = retrofit.create(DawandaService.class);
        Call<Session> userLoginCall = service.loginUserEachByEach(email.getText().toString(),password.getText().toString());


        userLoginCall.enqueue(new Callback<Session>() {

            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {
//                if (response.isSuccessful() && response.body() != null) {
                    Singleton.getInstance().setSession(response.body());
                    Toast.makeText(LoginActivity.this,"Your Login was Successful!",Toast.LENGTH_LONG).show();
                    Log.d("onCreate","Singleton Instance: "+ Singleton.getInstance().getSession().toString());
                    startActivity(new Intent(getApplicationContext(),ConversationsActivity.class));
//                }else{
//                    Toast.makeText(LoginActivity.this,"Fehler!!",Toast.LENGTH_LONG).show();
//                    Log.d("LoginActivity Request ", "Fehler!!!");
//                }
            }
            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                Log.d("Retrofit request","Failurrrrree!!!: "+t);
            }


        });
    }

    private boolean loginCheck() {

        email.setError(null);
        password.setError(null);

        String emailL = email.getText().toString();
        String passwordL= password.getText().toString();


        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(passwordL) && !isPasswordValid(passwordL)) {
            password.setError(getString(R.string.error_invalid_password));
            focusView = password;
            cancel = true;
        }

        if (TextUtils.isEmpty(emailL)) {
            password.setError(getString(R.string.error_field_required));
            focusView = password;
            cancel = true;
  }
// else if (!isEmailValid(emailL)) {
//            email.setError(getString(R.string.error_invalid_email));
//            focusView = email;
//            cancel = true;
//        }

      Toast.makeText(LoginActivity.this,"Insertation correct!!!",Toast.LENGTH_LONG).show();
        return !cancel;
    }

    private boolean isEmailValid(String email) {

        return email.contains("-");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}
