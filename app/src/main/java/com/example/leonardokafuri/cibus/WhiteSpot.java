package com.example.leonardokafuri.cibus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class WhiteSpot extends AppCompatActivity {

    String selection = "";
    int db, hamburguer, pastas,steak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_spot);
        final EditText dbdb = findViewById(R.id.doubledouble);
        final EditText hbg = findViewById(R.id.chickenPasta);
        final EditText pasta = findViewById(R.id.legendBurger);

        //calculate the prices on the checkboxes and add to a price pass the price to the next screen

        Button order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=Integer.parseInt(dbdb.getText().toString());
                pastas = Integer.parseInt(pasta.getText().toString());
                hamburguer = Integer.parseInt(hbg.getText().toString());

                try {
                    if (db > 0) {
                        selection = "Double double :" + db + "\n";

                    } else if (pastas > 0) {
                        selection = selection + "Pasta : " + pastas +"\n";

                    } else if (hamburguer > 0) {
                        selection = selection + "Hamburguers : " + hamburguer + "\n";

                    } else {
                        selection = "Error";

                    }


                    Intent i = new Intent(WhiteSpot.this,OrderConfirmation.class);
                    i.putExtra("data",selection);
                    startActivity(i);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                //startActivity(new Intent(WhiteSpot.this,OrderConfirmation.class));
            }
        });

    }

    //3 dot menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.home:
                startActivity(new Intent(WhiteSpot.this,AccountInfo.class));
                break;
            case R.id.History:
                startActivity(new Intent(WhiteSpot.this,History.class));
                break;
            case R.id.Promotion:
                startActivity(new Intent(WhiteSpot.this,Promotion.class));
                break;
            case R.id.logout:
                startActivity(new Intent(WhiteSpot.this,Login.class));
                break;
        }
        return true;
    }
}
