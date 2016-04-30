package com.fun.hearthstonekillcalculatorv20.model;

import java.io.Serializable;

/**
 * Created by HZF on 2016/4/28.
 */
public class FishMen implements Serializable {

    private Integer reBirthBluegillWarrior;
    private Integer reBirthMurlocWarleader;
    private Integer reBirthOldMurkEye;
    private Integer eachBluegillWarrior;
    private Integer eachOldMurkEye;
    private Integer total;

    public Integer getReBirthBluegillWarrior() {
        return reBirthBluegillWarrior;
    }

    public void setReBirthBluegillWarrior(Integer reBirthBluegillWarrior) {
        this.reBirthBluegillWarrior = reBirthBluegillWarrior;
    }

    public Integer getReBirthMurlocWarleader() {
        return reBirthMurlocWarleader;
    }

    public void setReBirthMurlocWarleader(Integer reBirthMurlocWarleader) {
        this.reBirthMurlocWarleader = reBirthMurlocWarleader;
    }

    public Integer getReBirthOldMurkEye() {
        return reBirthOldMurkEye;
    }

    public void setReBirthOldMurkEye(Integer reBirthOldMurkEye) {
        this.reBirthOldMurkEye = reBirthOldMurkEye;
    }

    public Integer getEachBluegillWarrior() {
        return eachBluegillWarrior;
    }

    public void setEachBluegillWarrior(Integer eachBluegillWarrior) {
        this.eachBluegillWarrior = eachBluegillWarrior;
    }

    public Integer getEachOldMurkEye() {
        return eachOldMurkEye;
    }

    public void setEachOldMurkEye(Integer eachOldMurkEye) {
        this.eachOldMurkEye = eachOldMurkEye;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "FishMen{" +
                "reBirthBluegillWarrior=" + reBirthBluegillWarrior +
                ", reBirthMurlocWarleader=" + reBirthMurlocWarleader +
                ", reBirthOldMurkEye=" + reBirthOldMurkEye +
                ", eachBluegillWarrior=" + eachBluegillWarrior +
                ", eachOldMurkEye=" + eachOldMurkEye +
                ", total=" + total +
                '}';
    }
}
