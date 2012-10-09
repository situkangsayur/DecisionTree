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
public class EntropyEntity {

    private Float entropy;
    private Integer allVal;
    private List<Integer> specVal;
    private Integer sigma;
    private String valueName;
    private int numValue;

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public int getNumValue() {
        return numValue;
    }

    public void setNumValue(int numValue) {
        this.numValue = numValue;
    }

    public void setEntropy(Float entropy) {
        this.entropy = entropy;
    }

    public Float getEntropy() {
        return entropy;
    }

    public Integer getAllVal() {
        return allVal;
    }

    public void setAllVal(Integer allVal) {
        this.allVal = allVal;
    }

    public List<Integer> getSpecVal() {
        return specVal;
    }

    public void setSpecVal(List<Integer> specVal) {
        this.specVal = specVal;
    }

    public Integer getSigma() {
        return sigma;
    }

    public void setSigma(Integer sigma) {
        this.sigma = sigma;
    }

    public void entropyFirstProgress() {
        Float temp = 0.0F;
        Float partTemp = 0.0F;
        float p = 0;

        if ((sigma == null) || (sigma == 0)) {
            sigma = specVal.size();
        }

        String hitung = " entropy = ";

    
        for (int i = 0; i < sigma; i++) {
           // System.out.println(specVal.get(i) + " & " + allVal);

            if (specVal.get(i) != 0) {
                hitung += "(-(" + specVal.get(i) + "/" + allVal + ")* 2Lo(" + specVal.get(i) + "/" + allVal
                        + ")) ";
                p = ((float) specVal.get(i)) / ((float) allVal);
                partTemp = (float) ((-p) * (Math.log10(p) / Math.log10(2)));
            } else {
                hitung += "0.0";
                partTemp = 0.0F;
            }
            if (i != sigma - 1) {
                hitung += "+";
            }

            if (i == 0) {
                temp = partTemp;
            } else {
                temp += partTemp;

            }
        }
        hitung += "= " +temp;
        entropy = temp;
        System.out.println(hitung);

    }
}
