package ro.ulbs.proiectaresoftware.Lab2;

import java.util.*;

public class Application {
    void main() {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList();
        Set<Integer> zSet = new TreeSet();
        List<Integer> xMinusY = new ArrayList();
        int p=4;
        List<Integer> xPlusYLimitedByP = new ArrayList();

        Random rand = new Random();
        int sizex = 5;
        int sizey = 7;
        for(int i=0;i<sizex;i++)
            x.add(rand.nextInt(10));
        for(int i=0;i<sizey;i++)
            y.add(rand.nextInt(10));
       Collections.sort(x);
       Collections.sort(y);


        //a)
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        for( Integer  n : xPlusY)
            System.out.print(n + " ");

        //b)
        zSet.addAll(x);
        zSet.retainAll(y);

        //c
        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        Collections.sort(xMinusY);

        //d)
        xPlusYLimitedByP.addAll(x);
        xPlusYLimitedByP.addAll(y);
        for( Integer n : xPlusYLimitedByP){
            if(n > p)
                xPlusYLimitedByP.remove(n);
        }
        Collections.sort(xPlusYLimitedByP);
    }
}
