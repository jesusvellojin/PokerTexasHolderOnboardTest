package com.Pruebatecnica.PokerTexasHolderOnboardTest.model;


import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class Card {

    Logger logger = Logger.getLogger(Card.class.getName());
    public ManoGanadora Par(String hand1, String hand2 ){
        HashMap cartasvalor = cartasValor();
        List<String> haden1CartasPar = new ArrayList<>();
        List<String> haden1CartasPar2 = new ArrayList<>();
        List<String> haden2CartasPar = new ArrayList<>();
        List<String> haden2CartasPar2 = new ArrayList<>();
        List<String> array = new ArrayList<>();
        ManoGanadora manoGanadora = new ManoGanadora();


        int par1=0;
        int par2=0;
        boolean manoPar1 =false;
        boolean manoPar2 =false;


        for (int i = 0; i < hand1.length(); i+=3) {
            for (int j = i+3; j <= hand1.length(); j+=3) {
                logger.info("INGRESA AL METODO findAllRoutes");
                logger.log(Level.INFO, "el valor de j: {0}", j);
                if (hand1.charAt(i)==hand1.charAt(j)){
                    logger.info("INGREso al if");
                    par1+=1;
                    if (par1==1){
                        haden1CartasPar.add(String.valueOf(hand1.charAt(i)));
                        haden1CartasPar.add(String.valueOf(hand1.charAt(i+1)));
                        haden1CartasPar.add(String.valueOf(hand1.charAt(j)));
                        haden1CartasPar.add(String.valueOf(hand1.charAt(j+1)));

                        haden1CartasPar2.add(""+hand1.charAt(i)+hand1.charAt(i+1));
                        haden1CartasPar2.add(""+hand1.charAt(j)+hand1.charAt(j+1));
                        manoPar1=true;
                    }else if (par1>=2) {
                        manoPar1=false;
                    }

                }
            }

        }

        for (int i = 0; i < hand2.length(); i+=3) {
            for (int j = i+3; j <= hand2.length(); j+=3) {
                logger.info("INGRESA AL METODO findAllRoutes");
                logger.log(Level.INFO, "el valor de j: {0}", j);
                if (hand2.charAt(i)==hand2.charAt(j)){
                    logger.info("INGREso al if");
                    par2+=1;
                    if (par2==1){
                        haden2CartasPar.add(String.valueOf(hand2.charAt(i)));
                        haden2CartasPar.add(String.valueOf(hand2.charAt(i+1)));
                        haden2CartasPar.add(String.valueOf(hand2.charAt(j)));
                        haden2CartasPar.add(String.valueOf(hand2.charAt(j+1)));

                        haden2CartasPar2.add(""+hand2.charAt(i)+hand2.charAt(i+1));
                        haden2CartasPar2.add(""+hand2.charAt(j)+hand2.charAt(j+1));
                        manoPar2=true;
                    } else if (par2>=2) {
                        manoPar2=false;
                    }

                }
            }

        }






        List<String> manohordenada1=ordenarMano(hand1,haden1CartasPar);
        List<String> manohordenada2=ordenarMano(hand2,haden2CartasPar);
        logger.log(Level.INFO, "numero: {0}", manohordenada2);



        if ((manoPar1 == true) && (manoPar2 == true)){


            if (cartasvalor.get(haden1CartasPar.get(0))==cartasvalor.get(haden2CartasPar.get(0))){
                for (int i = 0; i < manohordenada1.size(); i++) {
                    String elemento1= manohordenada1.get(i);
                    Integer numero1 = (Integer) cartasvalor.get(String.valueOf(elemento1.charAt(0)));

                    String elemento2= manohordenada2.get(i);
                    Integer numero2 = (Integer) cartasvalor.get(String.valueOf(elemento2.charAt(0)));

                    if (numero1>numero2){
                        manoGanadora.setWinnerHand(hand1);
                        manoGanadora.setWinnerHandType("OnePair");
                        array.add(manohordenada1.get(i));
                        manoGanadora.setCompositionWinnerHand(array);
                        return manoGanadora;
                      //  return "gana mano 1";
                    }  if (numero2>numero1) {
                        manoGanadora.setWinnerHand(hand2);
                        manoGanadora.setWinnerHandType("OnePair");
                        array.add(manohordenada2.get(i));
                        manoGanadora.setCompositionWinnerHand(array);
                        return manoGanadora;
                    }
                }
            }
            Integer num1= (Integer) cartasvalor.get(haden1CartasPar.get(0));
            Integer num2= (Integer) cartasvalor.get(haden2CartasPar.get(0));

            if (num1>num2){
                manoGanadora.setWinnerHand(hand1);
                manoGanadora.setWinnerHandType("OnePair");
                manoGanadora.setCompositionWinnerHand(haden1CartasPar2);
                return manoGanadora;
            }

            if (num1<num2){
                manoGanadora.setWinnerHand(hand2);
                manoGanadora.setWinnerHandType("OnePair");
                manoGanadora.setCompositionWinnerHand(haden2CartasPar2);
                return manoGanadora;
            }

        } else if ((manoPar1 == true) && (manoPar2 == false)) {
            manoGanadora.setWinnerHand(hand1);
            manoGanadora.setWinnerHandType("OnePair");
            manoGanadora.setCompositionWinnerHand(haden1CartasPar2);
            return manoGanadora;
        }else {
            manoGanadora.setWinnerHand(hand2);
            manoGanadora.setWinnerHandType("OnePair");
            manoGanadora.setCompositionWinnerHand(haden2CartasPar2);
            return manoGanadora;
        }



        String numeroString = String.valueOf(par1);
    return manoGanadora;
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

    private List<String> ordenarMano(String hand, List<String> hadenCartasPar){
        List<String> hadenOrdenada = new ArrayList<>();
        HashMap cartasvalor = cartasValor();
        for (int i = 0; i < hand.length()-1; i++) {
            if ((hand.charAt(i)!=' ') && (hand.charAt(i+1)!=' ')){
                hadenOrdenada.add(""+hand.charAt(i)+hand.charAt(i+1));
            }
        }

        for (int i = 0; i < hadenCartasPar.size(); i+=2) {
            String numero = hadenCartasPar.get(i);
            String palo = hadenCartasPar.get(i+1);
            hadenOrdenada.remove(numero+palo);
        }


        Integer numero1=0;
        Integer numero2=0;
        for (int i = 0; i < hadenOrdenada.size()-1; i++) {
            for (int j = 0; j < hadenOrdenada.size()-1; j++) {

                String elemento1= hadenOrdenada.get(j);
                logger.log(Level.INFO, "elemento: {0}", elemento1);
                numero1= (Integer) cartasvalor.get(String.valueOf(elemento1.charAt(0)));
                logger.log(Level.INFO, "numero: {0}", numero1);

                String elemento2= hadenOrdenada.get(j+1);
                logger.log(Level.INFO, "elemento: {0}", elemento2);
                numero2= (Integer) cartasvalor.get(String.valueOf(elemento2.charAt(0)));
                logger.log(Level.INFO, "numero: {0}", numero2);

                if (numero1<numero2){
                    String aux = elemento1;
                    hadenOrdenada.set(j,elemento2);
                    hadenOrdenada.set(j+1,elemento1);
                }

            }

        }


        return hadenOrdenada;

    }



}
