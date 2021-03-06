package com.sprinklet.worknowis;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;


public class LoginActivity extends AppCompatActivity  {
    private Button LogIn,NewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_login);

    }

    public void createUser(View view){
        Intent add = new Intent(LoginActivity.this, AddUserActivity.class);
        startActivity(add);
    }

    public void check_login(View view) {
        String user = ((EditText)findViewById(R.id.txtUsuario)).getText().toString();
        String pass = ((EditText)findViewById(R.id.txtContraseña)).getText().toString();
        JSONObject postDataParams = new JSONObject();
        try {
            postDataParams.put("user", user);
            postDataParams.put("pass", pass);
            SendRequest dt = new SendRequest("http://weareonevision.org/rqst/check_user.php",postDataParams);
            dt.execute();
            ((EditText)findViewById(R.id.txtUsuario)).setText(dt._result);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        /*
        URL url;
        HttpURLConnection con;
        try {
            url = new URL("http://weareonevision.org/this.php");
            con = null;
            // Construir los datos a enviar
            String data = "id=45&name=uan";

            con = (HttpURLConnection)url.openConnection();

            // Activar método POST
            con.setDoOutput(true);

            // Tamaño previamente conocido
            con.setFixedLengthStreamingMode(data.getBytes().length);

            // Establecer application/x-www-form-urlencoded debido a la simplicidad de los datos
            con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            Log.e("",con.getResponseMessage());
            OutputStream out = new BufferedOutputStream(con.getOutputStream());

            out.write(data.getBytes());
            out.flush();
            out.close();
            con.disconnect();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {        }

        Intent add = new Intent(LoginActivity.this,MapsActivity.class);
        startActivity(add);*/;
    }
    public class SendRequest extends AsyncTask<String, Void, String> {
        String _url;
        String _result;
        JSONObject  postDataParams;

        public SendRequest(String j, JSONObject m)
        {
            _url = j;
            postDataParams = m;
        }

        protected String doInBackground(String... arg0) {

            try{

                URL url = new URL(_url);

                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();
            _result = result;


        }
    }

    public String getPostDataString(JSONObject params) throws Exception
    {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }
}