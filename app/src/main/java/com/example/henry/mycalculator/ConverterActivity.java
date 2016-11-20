package com.example.henry.mycalculator;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by UMARU on 7/26/2016.
 */

//Activity class for the converting
public class ConverterActivity extends Activity {
    Integer fromBase = 10, toBase = 2;
    private Button mFromButton, mToButton, mConvertButton;
    private EditText mFromText;
    private TextView mToText;
    private InputMethodManager inputMethodManager;
    private static Map<Integer, String> base2Str = new HashMap<Integer, String>() {
        {
            put(2, "Bin");
            put(8, "Oct");
            put(10, "Dec");
            put(16, "Hex");
        }
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    private void update_base(int base, boolean isFrom) {
        if (isFrom) {
            fromBase = base;
            mFromButton.setText(base2Str.get(fromBase));
        } else {
            toBase = base;
            mToButton.setText(base2Str.get(toBase));
        }
    }

    public void showPopup(View v, final boolean isFrom) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.Hex:
                        update_base(16, isFrom);
                        break;
                    case R.id.Dec:
                        update_base(10, isFrom);
                        break;
                    case R.id.Oct:
                        update_base(8, isFrom);
                        break;
                    case R.id.Bin:
                        update_base(2, isFrom);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        }
        );
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.base_menu, popup.getMenu());
        popup.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertor_activity);

            mFromButton = (Button) findViewById(R.id.fromButton);
            mToButton = (Button) findViewById(R.id.toButton);
            mFromText = (EditText) findViewById(R.id.fromText);
            mToText = (TextView) findViewById(R.id.toText);
            mConvertButton = (Button) findViewById(R.id.convertButton);
            inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        mConvertButton.setOnClickListener(new convertButtonOnClickListener());
        mFromButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopup(v, true);
                }
            });
        mToButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopup(v, false);
                }
            });
            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    class convertButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String input = mFromText.getText().toString();
            try {
                Converter converter = new Converter(input, fromBase);
                if (!converter.isValid()) {
                    mFromText.setError("Input Format Error");
                }
                mToText.setText(converter.toBase(toBase));
                MyUtils.hideSoftKeyBoard(v, inputMethodManager);

            } catch (IntOverFlow e) {
                mFromText.setError("Input Number Too Large");
            }

        }
    }
}
