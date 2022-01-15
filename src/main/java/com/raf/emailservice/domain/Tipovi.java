package com.raf.emailservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Tipovi {

    private List<Tip> tipovi = new ArrayList<Tip>();
    private Long id;

    public Tipovi() {
    }

    public boolean addTip(Tip tip){
        for(Tip postojeciTip : this.tipovi) {
            if(postojeciTip.getName().equals(tip.getName())) return false;
        }
        this.tipovi.add(tip);
        return true;
    }

    public List<Tip> getTipovi() {
        return tipovi;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
