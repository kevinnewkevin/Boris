package com.example.mrmishka.lukoile.all.transAction.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mrmishka.lukoile.R;

import java.util.ArrayList;

/**
 * Created by MrMishka on 20.04.2017.
 */

public class TransactionAdapter extends BaseAdapter {
    LayoutInflater lInflater;
    ArrayList<TransactionParams> object;
    Context ctx;

    public TransactionAdapter(Context context, ArrayList<TransactionParams> tParams) {
        ctx = context;
        object = tParams;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return object.size();
    }

    @Override
    public Object getItem(int position) {
        return object.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.transaction_item, parent, false);
        }
        TransactionParams t = getParams(position);
        ((TextView) view.findViewById(R.id.fuelName)).setText(t.fuelname);
        ((TextView) view.findViewById(R.id.litresTextview)).setText(t.litres);
        ((TextView) view.findViewById(R.id.bonusPlusTextview)).setText(t.bonusPLus);
        ((TextView) view.findViewById(R.id.bonusMinusTextview)).setText(t.bonusMinus);
        return view;
    }


    TransactionParams getParams(int position) {
        return ((TransactionParams) getItem(position));
    }
}
