package com.example.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*RadioButton rAdd = (RadioButton) findViewById(R.id.radioAdd);
    RadioButton rSub = (RadioButton) findViewById(R.id.radioSub);
    RadioButton rMul = (RadioButton) findViewById(R.id.radioMul);
    RadioButton rDiv = (RadioButton) findViewById(R.id.radioDiv);*/

    EditText one, two;
    RadioButton Add, Sub, Mul, Div;
    RadioGroup G;
    TextView txtR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        one = (EditText) findViewById(R.id.edtNum1);
        two = (EditText) findViewById(R.id.edtNum2);
        Add = (RadioButton) findViewById(R.id.radioAdd);
        Sub = (RadioButton) findViewById(R.id.radioSub);
        Mul = (RadioButton) findViewById(R.id.radioMul);
        Div = (RadioButton) findViewById(R.id.radioDiv);
        G = (RadioGroup) findViewById(R.id.radioG);
        txtR = (TextView) findViewById(R.id.textView);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oneValue = one.getText().toString();
                String twoValue = two.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("one", oneValue);
                intent.putExtra("two", twoValue);
                switch(G.getCheckedRadioButtonId()) {
                    case R.id.radioAdd:
                        intent.putExtra("requestCode", 1001);
                        break;
                    case R.id.radioSub:
                        intent.putExtra("requestCode", 1002);
                        break;
                    case R.id.radioMul:
                        intent.putExtra("requestCode", 1003);
                        break;
                    case R.id.radioDiv:
                        intent.putExtra("requestCode", 1004);
                        break;
                }
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 || requestCode == 1002 || requestCode == 1003 || requestCode == 1004) {
            if (resultCode == RESULT_OK) {
                String result = data.getIntExtra("result", 0)+"";
                Toast.makeText(this, "계산결과 : " + result, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
