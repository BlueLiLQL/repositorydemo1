package com.lql.comparabledemo;

import java.util.Comparator;

public class PeopleComparator implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        if(o1.getAge() > o2.getAge()) return 1;
        return -1;
    }
}
