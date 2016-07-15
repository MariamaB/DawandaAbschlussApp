package com.lischke.miriam.dawandaapp.model;

/**
 * Created by Miriam on 27.05.2016.
 */
public class Price {

    private String currency;
    private int cents;
    private String symbol;



    public void Price(){

    }

    public String getCurrency(){
        return currency;
    }


    public String getPrice(){
        return ""+cents+" "+symbol;
    }

    @Override
    public String toString() {
        return "Price{" +
                "currency='" + currency + '\'' +
                ", cents=" + cents +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
