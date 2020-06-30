package com.example.createcreativity;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

public interface FragmentActionListener {

    String LAYYOUT_SELECTED = "layout_selected";

    void onSelectedLayout(Context context);
    void IntentListener(int requstCode);
    void data(Intent data);
}
