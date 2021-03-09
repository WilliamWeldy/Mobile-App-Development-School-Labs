package androidbootcamp.net.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Double num1;
    Double num2;
    double result = -1.2345;
    String operatorChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText number1 = (EditText)findViewById(R.id.txtBox1);
        final EditText number2 = (EditText)findViewById(R.id.txtBox2);
        final Spinner group = (Spinner)findViewById(R.id.operatorAssigner);
        Button calculate = (Button)findViewById(R.id.calcBtn);
        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView resultTxt = ((TextView)findViewById(R.id.resultTextView));
            @Override
            public void onClick(View view) {
                num1 = Double.parseDouble(number1.getText( ).toString( ));
                num2 = Double.parseDouble(number2.getText( ).toString( ));

                operatorChoice = group.getSelectedItem( ).toString( );
                if(operatorChoice.equals("/")) {
                    result = num1 / num2;

                         if (num1 == 0) resultTxt.setText("ERROR! You can't divide by 0, please edit your number fields!");
                    else if (num2 == 0) resultTxt.setText("ERROR! You can't divide by 0, please edit your number fields!");
                    else resultTxt.setText("Result: " + result);
                }
                if(operatorChoice.equals("*")) {
                    result = num1 * num2;
                    resultTxt.setText("Result: " + result);
                }
                if(operatorChoice.equals("+")) {
                    result = num1 + num2;
                    resultTxt.setText("Result: " + result);
                }
                if(operatorChoice.equals("-")) {
                    result = num1 - num2;
                    resultTxt.setText("Result: " + result);
                }
            }
        });
    }
}
