package com.example.memory;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @author paolo
 */
public class MainActivity extends Activity {

    int carteScoperte = 0;
    Carta primaCarta, secondaCarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onCartaCliccata(View v) {

        Carta cartaCliccata = (Carta) v;

        if (cartaCliccata.èScoperta()) return;

        // la cartaCliccata.èCoperta()
        cartaCliccata.scopri();

        switch (carteScoperte) {

            case 0:
                primaCarta = cartaCliccata;
                carteScoperte = 1;
                break;
            case 1:
                if (cartaCliccata.èUgualeA(primaCarta)) {
                    primaCarta.metteFuori();
                    cartaCliccata.metteFuori();
                    carteScoperte = 0;
                } else {
                    secondaCarta = cartaCliccata;
                    carteScoperte = 2;
                }
                break;
            case 2:
                primaCarta.copri();
                secondaCarta.copri();

                primaCarta = cartaCliccata;
                carteScoperte = 1;

        } // end_switch
    }


    public void nuovaPartita(MenuItem item) {
        //TODO: imolementanre
    }

}