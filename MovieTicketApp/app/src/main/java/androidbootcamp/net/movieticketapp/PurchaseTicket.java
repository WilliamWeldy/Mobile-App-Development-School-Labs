package androidbootcamp.net.movieticketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PurchaseTicket extends AppCompatActivity {

    double ticketPrice = 15.00;
    double taxRate = 0.08;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_ticket);

        final EditText ticketNum = (EditText) findViewById(R.id.ticketNum);

        Button calculate = (Button) findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double tickets = Double.parseDouble(ticketNum.getText().toString());
                MainActivity.ammountOwed = ((tickets * ticketPrice) * taxRate);
            }
        }
    }
}
