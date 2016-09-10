package net.ukr.p454;

import java.util.Arrays;

public interface IReservists {

  default Human[] getReservists(Human[] humans){
    int position = 0;
    Human[] newList = new Human[humans.length];
    for (Human human : humans) {
      if(human.getAge()>=18 && human.getSex() == Sex.MALE){
        newList[position++] = human;
      }
    }
    return decreaseArray(newList, position);
  }

  static  Human[] decreaseArray(Human[] humans, int countHuman){
    Arrays.sort(humans, (a, b) -> a == null ? 1 : b == null ? -1 :
            a.getFullName().compareToIgnoreCase(b.getFullName()));

    Human[] newArray = new Human[countHuman];
    System.arraycopy(humans, 0, newArray, 0, countHuman);
    return newArray;
  }
}