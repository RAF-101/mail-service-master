package com.raf.emailservice.tipizacija;

import java.util.ArrayList;
import java.util.List;

public class Tipovi {
    private List<Tip> tipovi = new ArrayList<Tip>();

    public Tipovi() {
    }

    public void addTip(Tip tip){
        this.tipovi.add(tip);
    }

    public boolean deleteTip(String name){
        for(Tip tip : tipovi){
            if(tip.getName().equals(name)){
                tipovi.remove(tip);
                return true;
            }
        }
        return false;
    }

    public Tip getTip(String name){
        for(Tip tip : tipovi){
            if(tip.getName().equals(name)){
                tipovi.remove(tip);
                return tip;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Tipovi{" +
                "tipovi=" + tipovi +
                '}';
    }
}
