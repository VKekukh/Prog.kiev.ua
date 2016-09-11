package net.ukr.p454;

import java.math.BigInteger;

/**
 * Created by vkekukh on 05.09.2016.
 */
public class Factorial implements Runnable{
    private int n;

    public Factorial(int n) {
        this.n = n;
    }

    public Factorial() {
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    @Override
    public void run(){

        System.out.println(calcFactorial());
    }

    public BigInteger calcFactorial(){

        BigInteger result =  new BigInteger("1");


        for (int i = 1; i <= this.n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }

}