package com.example.nekit.wanted_vinyl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

        final String LOG_TAG = "myLogs";

    private Button btnFindThat;
    private EditText etWAYLF;
    private TextView tvWAYLF;

    private String a, answerHTTP;
    private final String server = "http://www.ozon.ru";

    private Gson gson = new GsonBuilder().create();

    private Retrofit wantedvinyl = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(server).build();

    private Finding find = wantedvinyl.create(Finding.class);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MainWindow(this));
        setContentView(R.layout.activity_main);

        btnFindThat = (Button) findViewById(R.id.FindThat);
        etWAYLF = (EditText) findViewById(R.id.Find);
        tvWAYLF = (TextView) findViewById(R.id.WAYLF);

        btnFindThat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = etWAYLF.getText().toString();

                HashMap<String, String> postDataParams = new HashMap<String, String>();
                postDataParams.put("a", a);

                Call<Object> call = find.performPostCall(postDataParams);

                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response){
                        HashMap<String, Double> map = gson.fromJson(response.body().toString(), HashMap.class);
                        answerHTTP = Double.toString(map.get("c"));
                        tvWAYLF.setText(answerHTTP);
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        tvWAYLF.setText("ERROR");
                    }
                });
            }
        });
    }

}
