package com.example.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;

/**
 * Created by com on 2015-11-19.
 */
public class SecondActivity  extends ActionBarActivity {

    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.second);
        setTitle("Second 액티비티");

        btnCalc = (Button) findViewById(R.id.btnReturn);

        Intent intent = getIntent();
        final String one = intent.getStringExtra("one");
        final String two = intent.getStringExtra("two");
        final int requestCode = intent.getIntExtra("requestCode", 0);

        int result = 0;
        if(requestCode == 1001)
            result = Integer.parseInt(one) + Integer.parseInt(two);
        else if (requestCode == 1002)
            result = Integer.parseInt(one) - Integer.parseInt(two);
        else if (requestCode == 1003)
            result = Integer.parseInt(one) * Integer.parseInt(two);
        else if (requestCode == 1004)
            result = Integer.parseInt(one) / Integer.parseInt(two);

        //Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("Result", result);
        setResult(RESULT_OK, resultIntent);
        finish();

        /*switch (rGroup.getCheckedRadioButtonId()) {
            case R.id.radioAdd:
                result = value1 + value2;
                break;
            case R.id.radioSub:
                result = value1 - value2;
                break;
            case R.id.radioMul:
                result = value1 * value2;
                break;
            case R.id.radioDiv:
                result = value1 / value2;
                break;
        }*/

        /*final int hapValue = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
        final int chaValue = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
        final int gobValue = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
        final int mokValue = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);*/

        /*btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = 0;
                if(requestCode == 1001)
                    result = Integer.parseInt(one) + Integer.parseInt(two);
                else if (requestCode == 1002)
                    result = Integer.parseInt(one) - Integer.parseInt(two);
                else if (requestCode == 1003)
                    result = Integer.parseInt(one) * Integer.parseInt(two);
                else if (requestCode == 1004)
                    result = Integer.parseInt(one) / Integer.parseInt(two);

                //Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });*/
    }
}

