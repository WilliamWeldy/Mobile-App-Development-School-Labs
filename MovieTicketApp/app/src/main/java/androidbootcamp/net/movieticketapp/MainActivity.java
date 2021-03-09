package androidbootcamp.net.movieticketapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DecimalFormat;

public class MainActivity extends ListActivity {

    public static double ammountOwed;
    String rowNumber = "";
    String numberOfSeats = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[ ] options={"Purchase Ticket", "Select Seat", "Display Ticket", "Go to our website"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.moptions, options));
    }
    protected void onListItemClick(ListView l, View v, int position, long id) {
        DecimalFormat hundredth = new DecimalFormat("#.##");

        switch (position) {
            case 0: //This allows the user to enter how many tickets they want to buy.
                startActivity(new Intent(MainActivity.this, PurchaseTicket.class));
                break;

                case 1: //This will request the user to enter the row and seat number(s) they want.
                    startActivity(new Intent(MainActivity.this, SelectSeat.class));
                    break;

                    case 2: //Displays the ticket image.
                        startActivity(new Intent(MainActivity.this, Display.class));
                        break;

                        case 3: //Goes to the website.
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse ("https://www.regaltheater.com/")));
                            break;
        }
    }
}
