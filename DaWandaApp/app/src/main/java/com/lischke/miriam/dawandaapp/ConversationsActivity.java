package com.lischke.miriam.dawandaapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;
import com.lischke.miriam.dawandaapp.model.Session;
import com.lischke.miriam.dawandaapp.model.Singleton;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ConversationsActivity extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Conversations Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.lischke.miriam.dawandaapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client2, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Conversations Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.lischke.miriam.dawandaapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client2, viewAction);
        client2.disconnect();
    }

    public interface DawandaService {

        @GET("/core/mobile/conversations")
        Call<List<Conversation>> getConversations();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversations);

        final Session s = Singleton.getInstance().getSession();
        Log.d("onCreate ConversationActivity", "Seaaion: " + s);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                okhttp3.Response response;

                System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>> intercepted !!!!! <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                Request request = chain.request();
                request = request.newBuilder()
                        .addHeader("AuthMethod:", "requred Auth")
                        .addHeader("Authorization:", "_dawanda_session " + s.getSid())
                        .build();
                response = chain.proceed(request);

                return response;
            }
        });
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://de.dawanda.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        DawandaService service = retrofit.create(DawandaService.class);

        Call<List<Conversation>> conversationCall = service.getConversations();


        conversationCall.enqueue(new Callback<List<Conversation>>() {
            @Override
            public void onResponse(Call<List<Conversation>> call, Response<List<Conversation>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {

                    Log.d("Conversation Request", " Responsebody: " + response.body().size() + ", " + response.body().toString());

                } else {
                    Toast.makeText(ConversationsActivity.this, "Conversation Request Fehler!!", Toast.LENGTH_LONG).show();
                    try {
                        Log.d("Conversation Request ", "Fehler!!!" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Conversation>> call, Throwable t) {
                Log.d("Request: ", "Failurrrrree!!!: " + t);
            }


        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
}
