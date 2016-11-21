package com.example.henry.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.StringTokenizer;

/**
 * Created by Jordan Ang on 11/20/2016.
 */

//Calculator that allows for user to input different bases
public class baseCalculator extends Activity {
    Integer inputOneBase = 10;
    Integer inputTwoBase = 10;
    Integer resultBase = 10;
    Integer operation = 0;
    private Button inputOneBaseButton;
    private Button inputTwoBaseButton;
    private Button resultBaseButton;
    private EditText firstInput;
    private EditText secondInput;
    private TextView baseCalcResult;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private InputMethodManager inputMethodManager;
    private static Map<Integer, String> base2Str = new HashMap<Integer, String>() {
        {
            put(2, "Bin");
            put(8, "Oct");
            put(10, "Dec");
            put(16, "Hex");
        }
    };

    private GoogleApiClient client;


    private void update_base(int base, int whichBase) {
        if (whichBase == 0) {
            inputOneBase = base;
            inputOneBaseButton.setText(base2Str.get(inputOneBase));
        } else if (whichBase == 1){
            inputTwoBase = base;
            inputTwoBaseButton.setText(base2Str.get(inputTwoBase));
        }else
            resultBase = base;
            resultBaseButton.setText(base2Str.get(resultBase));
    }

    public void showPopup(View v, final int whichBase) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                             @Override
                                             public boolean onMenuItemClick(MenuItem item) {
                                                 int id = item.getItemId();
                                                 switch (id) {
                                                     case R.id.Hex:
                                                         update_base(16, whichBase);
                                                         break;
                                                     case R.id.Dec:
                                                         update_base(10, whichBase);
                                                         break;
                                                     case R.id.Oct:
                                                         update_base(8, whichBase);
                                                         break;
                                                     case R.id.Bin:
                                                         update_base(2, whichBase);
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
        setContentView(R.layout.base_calculator_activity);

        inputOneBaseButton = (Button) findViewById(R.id.inputOneBaseButton);
        inputTwoBaseButton = (Button) findViewById(R.id.inputTwoBaseButton);
        firstInput = (EditText) findViewById(R.id.firstInput);
        secondInput = (EditText) findViewById(R.id.secondInput);
        baseCalcResult = (TextView) findViewById(R.id.baseCalcResult);
        resultBaseButton = (Button) findViewById(R.id.resultBaseButton);
        addButton = (Button) findViewById(R.id.addButton);
        subtractButton = (Button) findViewById(R.id.subtractButton);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);

        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = 0;
                calculate();
            }
        });
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = 1;
                calculate();
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = 2;
                calculate();
            }
        });
         inputOneBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, 0);
            }
        });
        inputTwoBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, 1);
            }
        });
        resultBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, 2);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void calculate(){
        String input1 = firstInput.getText().toString();
        String input2 = secondInput.getText().toString();
        String result = "";
        boolean negative = false;
        try {
            Converter converter1 = new Converter(input1, inputOneBase);
            Converter converter2 = new Converter(input2, inputOneBase);
            if (!converter1.isValid()) {
                firstInput.setError("Input Format Error");
            } else if (!converter2.isValid()) {
                secondInput.setError("Input Format Error");
            }
            int input1_decimal = Integer.parseInt(converter1.toBase(10));
            int input2_decimal = Integer.parseInt(converter2.toBase(10));
            if(operation == 0) {
                result = Integer.toString(input1_decimal + input2_decimal);
            } else if(operation == 1){
                int value = input1_decimal - input2_decimal;
                if(value < 0) {
                    negative = true;
                } else{
                    negative = false;
                }
                result = Integer.toString(Math.abs(value));
            } else if(operation == 2) {
                result = Integer.toString(input1_decimal * input2_decimal);
            }
            Converter converter3 = new Converter(result, 10);
            if(negative == false) {
                baseCalcResult.setText(converter3.toBase(resultBase));
            } else {
                baseCalcResult.setText("-" + converter3.toBase(resultBase));
            }
        } catch (IntOverFlow e) {
            firstInput.setError("Input Number Too Large");
        }
    }
    
}


