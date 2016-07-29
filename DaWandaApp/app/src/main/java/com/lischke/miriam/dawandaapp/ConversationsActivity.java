package com.lischke.miriam.dawandaapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.lischke.miriam.dawandaapp.model.ConversationModel.ConvContext;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbConvContext;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbConversation;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbDatabaseNames;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbMessageDetails;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbOrder;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbProduct;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbShop;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbUser;
import com.lischke.miriam.dawandaapp.model.RVConvDetailsAdapter;
import com.lischke.miriam.dawandaapp.model.Session;
import com.lischke.miriam.dawandaapp.model.Singleton;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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


     public static List <Conversation> responsebody;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;
    RecyclerView rv;
    CardView cv;
    RVAdapter adapter;
//    public static String dbName;
    public ArrayList storeDatabaseName = new ArrayList();


    public ConversationsActivity() {


    }

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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        rv = (RecyclerView) findViewById(R.id.rv_l);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);


        final Session s = Singleton.getInstance().getSession();

        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
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

                    responsebody = response.body();
//                        ConversationsActivity.this.deleteDatabase("23157363");

                    Log.d("Retrofit onResponse", "My ID: " + response.body().get(0).getContext().getMe().getId());
                    DatabaseOperations db = new DatabaseOperations(ConversationsActivity.this, "" + response.body().get(0).getContext().getMe().getId());

//                    ConversationsActivity.this.deleteDatabase("26685803");
                    insertData(response, db);

                } else {
                    Toast.makeText(ConversationsActivity.this, "DbConversation Request Fehler!!", Toast.LENGTH_LONG).show();
                    try {
                        Log.d("DbConversation Request ", "Fehler!!!" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Conversation>> call, Throwable t) {
                Log.d("DbConversation Request ", "Failurrrrree!!!: " + t);

            }


        });


        cv = (CardView) findViewById(R.id.cv_l);



}

public void onClick(View view){

    int id =  view.getId();


    builderDetailAdapter(id);
}


    public void builderDetailAdapter(int id){

        List<DbMessageDetails> mList = null;
        List<DbMessageDetails> fullmList = null;
        List<DbUser> uList = null;
        List<DbConvContext> cList = null;
        List<DbConversation> conList = null;
        DatabaseOperations helper = OpenHelperManager.getHelper(this, DatabaseOperations.class);


        try {

            Dao<DbConversation, Integer> conDao = helper.getConversationDao();
            Dao<DbMessageDetails, Integer> mDao = helper.getMessagesDao();
            Dao<DbMessageDetails, Integer> fullmDao = helper.getMessagesDao();
            Dao<DbConvContext, Integer> cDao = helper.getConvConDao();

            fullmList = mDao.queryForAll();
            conList = conDao.queryForAll();
            cList = cDao.queryForAll();


            for (int j = 0; j<conList.size(); j++) {

                if (id == conList.get(j).getContext()) {

                    for (int i = 0; i < fullmList.size(); i++) {

                        mList = mDao.queryForEq(DbMessageDetails.mess_reciver, cList.get(i).getMe());
                        Log.d("ConversationActivity", "mListe: "+mList.size());
//                        mList = mDao.queryForEq(DbMessageDetails.mess_sender, cList.get(i).getMe());
//                        Log.d("ConversationActivity", "mListe: "+mList.size());
                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        OpenHelperManager.releaseHelper();
        helper.databasenameListClose();

        RVConvDetailsAdapter detailsAdapter = new RVConvDetailsAdapter(this, mList, cList, uList);
        rv.setAdapter(detailsAdapter);
    }



    private void insertData(Response<List<Conversation>> response,DatabaseOperations insertDB) {

        String id = ""+responsebody.get(0).getContext().getMe().getId();
        boolean check =checkData(id, responsebody.get(0));

        if(id == id){

            getData();
        }
        else
        {

            List<Conversation> responsebody;

            responsebody = response.body();
            DbConversation conversation;
            ConvContext cCo;
            DbUser user ;
            DbUser me ;
            DbMessageDetails messages;
            DbShop shop = null;
            DbProduct product = null;
            DbOrder order = null;
            DbConvContext convContext;

//        insertDB = new DatabaseOperations(this);


            Dao<DbProduct, Integer> productDao = null;
            Dao<DbConversation, Integer> conversationsDao = null;
            Dao<DbShop, Integer> shopDao = null;
            Dao<DbUser, Integer> usersDao = null;
            Dao<DbMessageDetails, Integer> messagesDao = null;
            Dao<DbOrder, Integer> ordersDao = null;
            Dao<DbConvContext, Integer> convConDao = null;

            try {
                productDao = insertDB.getProductDao();
                conversationsDao = insertDB.getConversationDao();
                shopDao = insertDB.getShopDao();
                usersDao = insertDB.getUserDao();
                messagesDao = insertDB.getMessagesDao();
                ordersDao = insertDB.getOrderDao();
                convConDao = insertDB.getConvConDao();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < responsebody.size(); i++) {

                conversation = new DbConversation( responsebody.get(i));
                user = new DbUser(responsebody.get(i));

                messages = new DbMessageDetails(responsebody.get(i));

                if (i < responsebody.get(i).getMessages().size() && responsebody.get(i).getMessages().get(i).getProduct() != null ) {

                    product = new DbProduct(responsebody.get(i));
                }

                if (responsebody.get(i).getContext().getOrder() != null ) {

                    order = new DbOrder(responsebody.get(i));

                    if (responsebody.get(i).getContext().getOrder().getShop() != null ) {
                        shop = new DbShop(responsebody.get(i));
                    }

                }

                convContext = new DbConvContext(responsebody.get(i));



                try {
                    if (i < responsebody.get(i).getMessages().size() && responsebody.get(i).getMessages().get(i).getProduct() != null) {
                        productDao.create(product);
                    }
                    usersDao.create(user);
                    shopDao.create(shop);
                    messagesDao.create(messages);
                    ordersDao.create(order);
                    convConDao.create(convContext);
                    conversationsDao.create(conversation);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }


            getData();
    }
//
//insertDB.queryForEq(DbMessageDetails.mess_sender,""+DbUser.user_id+"");
        Toast.makeText(getBaseContext(), "Data was inserted", Toast.LENGTH_LONG).show();
    }


public void getData(){

    DatabaseOperations helper = OpenHelperManager.getHelper(this,DatabaseOperations.class);


    try {
        Dao<DbMessageDetails, Integer> messagesDao = helper.getMessagesDao();
        List<DbMessageDetails> messagList = null;
        messagList = messagesDao.queryForAll();


        Dao<DbUser, Integer> userDao = helper.getUserDao();
        List<DbUser>  userList = userDao.queryForAll();

        Dao<DbConvContext, Integer> convconDao = helper.getConvConDao();
        List<DbConvContext>  convconList = convconDao.queryForAll();

        adapter = new RVAdapter(this,messagList,userList,convconList);
        rv.setAdapter(adapter);

    } catch (SQLException e) {
        e.printStackTrace();
    }

    OpenHelperManager.releaseHelper();
    helper.messagesClose();
    helper.userClose();

}
///Funktioniert nicht wirklich!!!
    public boolean checkData(String name,Conversation conv){
        List<DbDatabaseNames> databaseNames = null;
        DatabaseOperations helper = OpenHelperManager.getHelper(this,DatabaseOperations.class);
        DbDatabaseNames newName = new DbDatabaseNames(conv);

        try {

            Dao<DbDatabaseNames, Integer> databaseNamesDao = helper.getDatabasenameList();
            databaseNames = databaseNamesDao.queryForAll();
            if (!databaseNames.contains(name)){

                databaseNamesDao.create(newName);

                OpenHelperManager.releaseHelper();
                helper.databasenameListClose();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        OpenHelperManager.releaseHelper();
        helper.databasenameListClose();

    return databaseNames.contains(name);
    }


}
