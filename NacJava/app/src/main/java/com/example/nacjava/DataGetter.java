package com.example.nacjava;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String, Void, String> {

    private TextView title;
    private TextView completed;

    public DataGetter(TextView title, TextView completed) {
        this.title = title;
        this.completed = completed;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        String result = NetworkToolkit.doGet(url);

        return result;
    }

    @Override
    protected void onPostExecute(String s) {

        try{
            JSONObject jsonObj = new JSONObject(s);

            this.title.setText(jsonObj.getString("title"));
            this.completed.setText(jsonObj.getString("completed"));


        }
        catch(JSONException e){

        }
    }
}

