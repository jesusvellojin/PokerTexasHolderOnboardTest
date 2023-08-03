package com.Pruebatecnica.PokerTexasHolderOnboardTest.model;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ManoGanadora {

    private String winnerHand;
    private String winnerHandType;
    private List<String> compositionWinnerHand;
}
