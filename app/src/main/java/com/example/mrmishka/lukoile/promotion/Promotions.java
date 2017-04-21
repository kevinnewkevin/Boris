package com.example.mrmishka.lukoile.promotion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrmishka.lukoile.R;

/**
 * Created by MrMishka on 18.04.2017.
 */

public class Promotions extends Fragment{
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstance){

            View view = inflater.inflate(R.layout.promotions,container,false);
            return  view;

        }
}
