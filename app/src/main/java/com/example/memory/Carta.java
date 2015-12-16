package com.example.memory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

class Carta extends ImageView {


    static final int COPERTA = 0;
    static final int SCOPERTA = 1;
    static final int FUORI_DAL_TAVOLO = 0;
    private static int carteGenerate = 0;


    // immagineDorso è solo per comodità invece di chiamare getReso....
    Drawable immagineCarta;

    // TODO : Valutare la ridondanza di immagineCarta e Valore (nel senso che vanno insieme 1 1, 2 2 etc
    private Drawable immagineDorso = this.getResources().getDrawable(R.drawable.carta_dorso);
    private int valore;

    private int stato;


    ///////////////////////////////////////////////////////////////////////////////////////
    //                   METODI PUBBLICI
    ///////////////////////////////////////////////////////////////////////////////////////

    public Carta(Context context) {
        super(context);
        this.generaCarta();
    }

    public Carta(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.generaCarta();
    }

    public Carta(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.generaCarta();
    }


    boolean èCoperta() {
        return (this.stato == Carta.COPERTA);
    }

    boolean èScoperta() {
        return (this.stato == Carta.SCOPERTA);
    }

    boolean èUgualeA(Carta c) {
        return (this.valore == c.valore);
    }

    void scopri() {
        this.stato = Carta.SCOPERTA;
        this.setImageDrawable(this.immagineCarta);
    }

    void copri() {
        this.stato = Carta.COPERTA;
        this.setImageDrawable(immagineDorso);
    }

    void metteFuori() {
        this.stato = Carta.FUORI_DAL_TAVOLO;
        this.setVisibility(INVISIBLE);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //                   METODI Privati
    ///////////////////////////////////////////////////////////////////////////////////////

    private void generaCarta() {

        Carta.carteGenerate++;
        if (Carta.carteGenerate == 17)
            Carta.carteGenerate = 1;

        this.stato = Carta.COPERTA;

        switch (Carta.carteGenerate) {

            case 1:
            case 2:
                valore = 1;
                immagineCarta = this.getResources().getDrawable(R.drawable.carta_1);
                break;
            case 3:
            case 4:
                valore = 2;
                immagineCarta = this.getResources().getDrawable(R.drawable.carta_2);
                break;
            case 5:
            case 6:
                valore = 3;
                immagineCarta = this.getResources().getDrawable(R.drawable.carta_3);
                break;
            case 7:
            case 8:
                valore = 4;
                immagineCarta = this.getResources().getDrawable(R.drawable.carta_4);
                break;
            case 9:
            case 10:
                valore = 5;
                immagineCarta = this.getResources().getDrawable(R.drawable.carta_5);
                break;
            case 11:
            case 12:
                valore = 6;
                immagineCarta = this.getResources().getDrawable(R.drawable.carta_6);
                break;
            case 13:
            case 14:
                valore = 7;
                immagineCarta = this.getResources().getDrawable(R.drawable.carta_7);
                break;
            case 15:
            case 16:
                valore = 8;
                immagineCarta = this.getResources().getDrawable(R.drawable.carta_8);
                break;


        }
        this.setImageDrawable(immagineDorso);
    }

}
