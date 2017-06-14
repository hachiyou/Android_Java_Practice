/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *

 *
 */

package com.example.lin.justjava;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the UPDATE button is clicked.
     */
    public void update(View view) {
        display(quantity);
        displayPrice(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.Quantity_Num);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price total value on the screen.
     */
    private void displayPrice (int number) {
        TextView priceTV = (TextView) findViewById(R.id.price_TV);
        priceTV.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        TextView quantityTV = (TextView) findViewById(R.id.Quantity_Num);
        //System.out.println(number);
        quantity++;
        quantityTV.setText("" + quantity);
        displayPrice(quantity);
    }
    /**
     * This method is called when the - button is clicked.
     * If quantity is greater or equal to 1, perform normal decrement function.
     * Else a prompt is shown to prevent further decrement.
     */
    public void decrement(View view){
        TextView quantityTV = (TextView) findViewById(R.id.Quantity_Num);
        if ( quantity >= 1 ) {
            quantity--;
            quantityTV.setText("" + quantity);
            displayPrice(quantity);
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("The quantity cannot go below 0.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            display(quantity);
                        };
                    }).show();
        }
    }


}