package com.Pruebatecnica.PokerTexasHolderOnboardTest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class Card {

    Logger logger = Logger.getLogger(Card.class.getName());
    public String Par(String hand1, String hand2 ){
        logger.info("INGRESA AL METODO findAllRoutes");
        int posicion =0;
        int par=0;
        int[] pares=new int[3];

        String[] cartas = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};


        for (int i = 0; i < hand1.length(); i+=3) {
            for (int j = i+3; j <= hand1.length(); j+=3) {
                logger.info("INGRESA AL METODO findAllRoutes");
                logger.log(Level.INFO, "el valor de j: {0}", j);
                if (hand1.charAt(i)==hand1.charAt(j)){
                    logger.info("INGREso al if");
                    pares[posicion]=j;
                    par+=1;
                    posicion++;
                }
            }

        }
        String numeroString = String.valueOf(par);
    return numeroString;
    }

    private Integer menor(Integer num1, Integer num2){
        if(num1 < num2)
            return num1;
        if(num1>num2)
            return num2;
        return 0;
    }
}
