package com.example.mrmishka.lukoile;

/**
 * Created by MrMishka on 20.04.2017.
 */

public class TransactionParams {
    String fuelname;
    String litres;
    String bonusPLus;
    String bonusMinus;

    TransactionParams(String _fuelnameAndLitres,String _litres,String _bonusPLus,String _bonusMinus){
        this.fuelname = _fuelnameAndLitres;
        this.litres = _litres;
        this.bonusPLus = _bonusPLus;
        this.bonusMinus = _bonusMinus;
    }
}
