package com.example.mrmishka.lukoile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrMishka on 18.04.2017.
 */

public class CustomerCard extends Fragment {
    GetCard getCardParam;

    HttpURLConnection connection = null;
    BufferedReader reader = null;

    ListView listView;


    TextView clientName, clientBonus;
    String naming;
    TransactionAdapter adapter;
    ArrayList<TransactionParams> paramses = new ArrayList<TransactionParams>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.customer_card, container, false);


        listView = (ListView) view.findViewById(R.id.ListTransactions);
        clientName = (TextView) view.findViewById(R.id.clientName);
        clientBonus = (TextView) view.findViewById(R.id.myBonus);

        getCardParam = new GetCard();
        getCardParam.execute("http://jambik.ru/api/user/auth?email=9285100611&password=123456");
        return view;

    }

    class GetCard extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {

            Transactions(GetTOkenApi(params[0]));
            return NameClient(GetTOkenApi(params[0]));


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            adapter = new TransactionAdapter(getActivity(), paramses);
            listView.setAdapter(adapter);
            clientBonus.setText(s);
            clientName.setText(naming);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

    }


    String GetTOkenApi(String s) {

        try {
            URL url = new URL(s);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String l = "";
            while ((l = reader.readLine()) != null) {
                buffer.append(l);

            }
            JSONObject jsonObject = new JSONObject(buffer.toString());
            s = jsonObject.getString("api_token");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        connection.disconnect();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;

    }


    void Transactions(String api) {
        try {
            URL url = new URL("http://jambik.ru/api/user/discounts?api_token=" + api + "");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String l = "";
            while ((l = reader.readLine()) != null) {
                buffer.append(l);

            }
            JSONObject parentObject = new JSONObject(buffer.toString());
            JSONArray parentArray = parentObject.getJSONArray("discounts");
            StringBuffer finalBufferedData = new StringBuffer();
            for (int i = 0; i < parentArray.length(); i++) {
                JSONObject finalobject = parentArray.getJSONObject(i);
                String typeOfFuel = finalobject.getString("fuel_name");
                double volume = finalobject.getDouble("volume");
                double price = finalobject.getDouble("price");
                double point = finalobject.getDouble("point");

                paramses.add(new TransactionParams(typeOfFuel, volume + "Л","+ "+ price,"- "+ point));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    String NameClient(String api) {
        try {
            URL url = new URL("http://jambik.ru/api/user/info?api_token=" + api + "");

            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String l = "";
            while ((l = reader.readLine()) != null) {
                buffer.append(l);

            }
            JSONObject jsonObject = new JSONObject(buffer.toString());
            api = String.valueOf(jsonObject.getDouble("discounts_sum"));
            JSONObject parentArray = jsonObject.getJSONObject("info");
            naming = parentArray.getString("full_name");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return api;

    }
}
