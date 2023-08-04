package com.Pruebatecnica.PokerTexasHolderOnboardTest.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class HighCard {
    public  ManoGanadora highCard(String hand1, String hand2){

        ManoGanadora manoGanadora = new ManoGanadora();

        HashMap cartasvalor = cartasValor();

        String[] cartas = hand1.split(" ");
        String[] cartas2 = hand2.split(" ");
        List<String> arraylista = Arrays.asList(cartas);
        List<String> arraylista2 = Arrays.asList(cartas2);


        List<String> haden1CartasPar = new ArrayList<>();
        List<String> haden1CartasPar2 = new ArrayList<>();
        List<String> haden2CartasPar = new ArrayList<>();
        List<String> haden2CartasPar2 = new ArrayList<>();
        List<String> array = new ArrayList<>();
        List<String> ordenada1 = new ArrayList<>();
        List<String> ordenada2 = new ArrayList<>();



        ordenada1=ordenar(arraylista);
        ordenada2=ordenar(arraylista2);

        Integer numero1=0;
        Integer numero2=0;
        for (int i = 0; i < ordenada1.size(); i++) {

            String ban1 = ordenada1.get(0);
            String valorCarta1 = ban1.substring(0, ban1.length() - 1);
            String ban2 = ordenada2.get(0);
            String valorCarta2 = ban2.substring(0, ban2.length() - 1);


            numero1= (Integer) cartasvalor.get(valorCarta1);
            numero2= (Integer) cartasvalor.get(valorCarta2);

            if (numero1>numero2){
                manoGanadora.setWinnerHand(hand1);
                manoGanadora.setWinnerHandType("HighCard");
                array.add(ordenada1.get(i));
                manoGanadora.setCompositionWinnerHand(array);
                return manoGanadora;
            }
            if (numero2>numero1){
                manoGanadora.setWinnerHand(hand2);
                manoGanadora.setWinnerHandType("HighCard");
                array.add(ordenada2.get(i));
                manoGanadora.setCompositionWinnerHand(array);
                return manoGanadora;
            }

        }






        return manoGanadora;
    }

    public List<String> ordenar(List<String> desordenada){
        HashMap cartasvalor = cartasValor();
        Integer numero1=0;
        Integer numero2=0;
        for (int i = 0; i < desordenada.size()-1; i++) {
            for (int j = 0; j <desordenada.size()-1; j++) {

                String ban1 = desordenada.get(j);
                String valorCarta1 = ban1.substring(0, ban1.length() - 1);
                String ban2 = desordenada.get(j+1);
                String valorCarta2 = ban2.substring(0, ban2.length() - 1);


                numero1= (Integer) cartasvalor.get(valorCarta1);
                numero2= (Integer) cartasvalor.get(valorCarta2);
                if (numero1<numero2){
                    String aux = desordenada.get(j);
                    desordenada.set(j,desordenada.get(j+1));
                    desordenada.set(j+1,aux);
                }


            }
        }
        return desordenada;
    }

    private HashMap<String, Integer> cartasValor(){
        HashMap<String, Integer> cartasValor = new HashMap<>();
        cartasValor.put("2",2);
        cartasValor.put("3",3);
        cartasValor.put("4",4);
        cartasValor.put("5",5);
        cartasValor.put("6",6);
        cartasValor.put("7",7);
        cartasValor.put("8",8);
        cartasValor.put("9",9);
        cartasValor.put("10",10);
        cartasValor.put("J",11);
        cartasValor.put("Q",12);
        cartasValor.put("K",13);
        cartasValor.put("A",14);
        return cartasValor;
    }




}


