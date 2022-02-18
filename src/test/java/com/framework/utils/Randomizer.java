package com.framework.utils;

import com.framework.base.BrowserElements;

import java.util.List;
import java.util.Random;

public class Randomizer {

    public static BrowserElements chooseRandomElementFromList(List<BrowserElements> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
