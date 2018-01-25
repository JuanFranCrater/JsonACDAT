package com.example.usuario.icantfindjson.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.usuario.icantfindjson.Network.Analisis;
import com.example.usuario.icantfindjson.Network.MySingleton;
import com.example.usuario.icantfindjson.R;

import org.json.JSONException;
import org.json.JSONObject;

public class QuinielaActivity extends AppCompatActivity implements View.OnClickListener{
        public static final String TAG = "MyTag";
        public static final String WEB = "http:/portadaalta.mobi/acceso/primitiva.json";;
        Button mButton;
        TextView mTextView;
        RequestQueue mRequestQueue;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiniela);
            mButton = (Button) findViewById(R.id.button);
            mButton.setOnClickListener(this);
            mTextView = (TextView) findViewById(R.id.mtextview);
            mRequestQueue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
        }
        @Override
        public void onClick(View view) {
            if (view == mButton)
                descarga();
        }

    private void descarga() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, WEB, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    mTextView.setText(Analisis.analizarPrimitiva(response));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText(error.getMessage());
            }
        });

        jsonObjectRequest.setTag(TAG);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(3000,1,1));
        mRequestQueue.add(jsonObjectRequest);
        }

    @Override
    protected void onStop() {
        super.onStop();
        if(mRequestQueue!=null)
            mRequestQueue.stop();
    }
}
