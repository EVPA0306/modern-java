package com.evpa.mj.chs;

import com.evpa.mj.chs.four.Dish;
import com.evpa.mj.chs.four.DishType;
import com.evpa.mj.chs.four.Trader;
import com.evpa.mj.chs.four.Transaction;

import java.util.Arrays;
import java.util.List;

public interface Data {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");


    List<Dish> DISH_LIST = Arrays.asList(new Dish("Pork", false, 800, DishType.MEAT)
            , new Dish("Mac and Cheese", false, 620, DishType.OTHER)
            , new Dish("Buffalo Wings", false, 743, DishType.POULTRY)
            , new Dish("Salmon",false, 450, DishType.FISH)
            , new Dish("Pizza", true,   550, DishType.OTHER)
            , new Dish("White Rice", true, 350, DishType.OTHER)
            , new Dish("Beef",false, 780, DishType.MEAT)
    );

    List<Transaction> TRANSACTIONS_LIST = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );
}
