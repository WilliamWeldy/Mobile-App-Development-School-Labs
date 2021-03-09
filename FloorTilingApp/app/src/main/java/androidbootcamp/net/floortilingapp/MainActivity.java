package androidbootcamp.net.floortilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double widthEntered = 0;
    double lengthEntered = 0;
    double roomSize;
    double tilesNeeded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText width = (EditText) findViewById(R.id.txtNumWidth);
        final EditText length = (EditText) findViewById(R.id.txtNumLength);
        final RadioButton tiles12x12 = (RadioButton) findViewById(R.id.tiles12x12);
        final RadioButton tiles18x18 = (RadioButton) findViewById(R.id.tiles18x18);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button calculate = (Button) findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                widthEntered=Double.parseDouble(width.getText().toString());
                lengthEntered=Double.parseDouble(length.getText().toString());
                roomSize = widthEntered * lengthEntered;

                DecimalFormat hundredth = new DecimalFormat("#.##");
                if(tiles12x12.isChecked( )) {
                    tilesNeeded = roomSize;
                    result.setText(hundredth.format(tilesNeeded) + " tiles are required.");
                }
                else if(tiles18x18.isChecked( )) {
                    tilesNeeded = roomSize * 1.5;
                    result.setText(hundredth.format(tilesNeeded) + " tiles are required.");
                }
                else {
                    result.setText("Neither option is selected, please choose your tile size!!");
                }
                }
        });
    }
}
