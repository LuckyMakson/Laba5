package sample;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.*;

public class Investors implements ObservableList<Investor> {

    public ArrayList<Investor> list2;

    public Investors() {
        this.list2 = new ArrayList<>();
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
    public ArrayList<Investor> deleteWithFIO(String FIO) {
        this.list2.remove(FIO);
        return this.list2;
    }

    @Override
    public String toString() {
        return "Investors{" +
                "list2=" + list2 +
                '}';
    }

    @Override
    public void addListener(ListChangeListener<? super Investor> listChangeListener) {

    }

    @Override
    public void removeListener(ListChangeListener<? super Investor> listChangeListener) {

    }

    @Override
    public boolean addAll(Investor... investors) {
        return false;
    }

    @Override
    public boolean setAll(Investor... investors) {
        return false;
    }

    @Override
    public boolean setAll(Collection<? extends Investor> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Investor... investors) {
        return false;
    }

    @Override
    public boolean retainAll(Investor... investors) {
        return false;
    }

    @Override
    public void remove(int i, int i1) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Investor> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(Investor investor) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Investor> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends Investor> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Investor get(int i) {
        return null;
    }

    @Override
    public Investor set(int i, Investor investor) {
        return null;
    }

    @Override
    public void add(int i, Investor investor) {

    }

    @Override
    public Investor remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Investor> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Investor> listIterator(int i) {
        return null;
    }

    @Override
    public List<Investor> subList(int i, int i1) {
        return null;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}
