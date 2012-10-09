/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeid3.cs.entities;

import java.util.List;

/**
 *
 * @author hendri
 */
public class GainsEntity {

    private Float gains;
    private EntropyEntity entropyParent;
    private List<EntropyEntity> entropyTarget;
    private Integer sigma;
    private Integer countDataSet;
    private int numField;

    public int getNumField() {
        return numField;
    }

    public void setNumField(int numField) {
        this.numField = numField;
    }

    public Integer getCountDataSet() {
        return countDataSet;
    }

    public void setCountDataSet(Integer countDataSet) {
        this.countDataSet = countDataSet;
    }

    public Integer getSigma() {
        return sigma;
    }

    public void setSigma(Integer sigma) {
        this.sigma = sigma;
    }

    public Float getGains() {
        return gains;
    }

    public void setGains(Float gains) {
        this.gains = gains;
    }

    public EntropyEntity getEntropyParent() {
        return entropyParent;
    }

    public void setEntropyParent(EntropyEntity entropyParent) {
        this.entropyParent = entropyParent;
    }

    public List<EntropyEntity> getEntropyTarget() {
        return entropyTarget;
    }

    public void setEntropyTarget(List<EntropyEntity> entropyTarget) {
        this.entropyTarget = entropyTarget;
    }

    public void gainsProgress() {

        Float tempPart = 0.0F;
        Float temp = entropyParent.getEntropy();
        Float sDiv = 0.0F;
        Integer countTarget = 0;

        if ((sigma == null) || (sigma == 0)) {
            sigma = entropyTarget.size();
        }



        String hitung = " gains = " + temp + "-(";
        for (int i = 0; i < sigma; i++) {
            hitung += "(" + entropyTarget.get(i).getAllVal() + "/" + (float) countDataSet;
            sDiv = (float) entropyTarget.get(i).getAllVal() / (float) countDataSet;
            hitung += sDiv + "*" + entropyTarget.get(i).getEntropy() + ")";
            tempPart += sDiv * entropyTarget.get(i).getEntropy();
            if (i != sigma - 1) {
                hitung += " - ";
            }

        }

        temp = temp - tempPart;
        hitung += ") =" + temp;

        gains = temp;
        System.out.println(hitung);
    }
}
