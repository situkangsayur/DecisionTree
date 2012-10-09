/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeid3.cs.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hendri
 */
public class EntStatistic {

    private String attribute;
    private Integer count;
    private List<Integer> result;
    private Double Entropy;

    public EntStatistic() {
        this.count = 0;
        if (result == null) {
            result = new ArrayList<Integer>();

            if (ResultEntity.isDone()) {

                for (int i = 0; i < ResultEntity.getVal().size(); i++) {
                    result.add(0);
                }
            }

        }
        this.Entropy = 0.0D;
    }

    public List<Integer> getResult() {
        return result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }

    public Double getEntropy() {
        return Entropy;
    }

    public void setEntropy(Double Entropy) {
        this.Entropy = Entropy;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
