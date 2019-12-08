package sample.Classes;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

public class Investors extends ArrayList<Investor> {

    public ArrayList<Investor> list2;

    public Investors() {
        this.list2 = new ArrayList<>();
    }

    public ArrayList<Investor> getList() {
        return list2;
    }

    public Investors(int length) {
        this.list2 = new ArrayList<>(length);
    }

    public void addToList(Investor investor)
    {
        list2.add(investor);
    }
    public Investors getWithGraterDeposit(double deposit) {
        Investors sublist = new Investors();
        for (Investor investor : this.list2) {
            if (investor.deposit > deposit)
                sublist.addToList(investor);
        }
        return sublist;
    }

    public Investors getWithGraterTempDeposit(double temp) {
        Investors sublist = new Investors();
        for (Investor investor : this.list2) {
            if (investor.contractTerm > temp)
                sublist.addToList(investor);
        }
        return sublist;
    }

    public Investors getWithFIO(String FIO) {
        Investors sublist = new Investors();
        for (Investor investor : this.list2) {
            if (investor.FIO.equals(FIO))
                sublist.addToList(investor);
        }
        return sublist;
    }
    public Investors deleteWithFIO(String FIO) {
        for (Investor investor : this.list2) {
            if (investor.FIO.equals(FIO))
            {
                this.list2.remove(investor);
            }
        }
        return (Investors) this.list2;
    }

    @Override
    public String toString() {
        return "Investors{" +
                "list2=" + list2 +
                '}';
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return null;
    }
}
