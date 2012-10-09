/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeid3.cs.model;


import decisiontreeid3.cs.entities.EntStatistic;
import decisiontreeid3.cs.entities.EntropyEntity;
import decisiontreeid3.cs.entities.GainsEntity;
import decisiontreeid3.cs.entities.TrainingSet;
import decisiontreeid3.cs.services.HelpAttribute;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hendri
 */
public class GainsModel {

    private EntropyEntity parentEntropy;
    private EntropyModel modelParentEnt;
    private List<TrainingSet> subSet;
    private List<GainsEntity> gains;
    private List<EntropyEntity> targetEntropy;
    private int numField;

    public EntropyModel getModelParentEnt() {
        return modelParentEnt;
    }

    public void setModelParentEnt(EntropyModel modelParentEnt) {
        this.modelParentEnt = modelParentEnt;
    }

    public int getNumField() {
        return numField;
    }

    public void setNumField(int numField) {
        this.numField = numField;
    }

    public List<GainsEntity> getGains() {
        return gains;
    }

    public void setGains(List<GainsEntity> gains) {
        this.gains = gains;
    }

    public EntropyEntity getParentEntropy() {
        return parentEntropy;
    }

    public void setParentEntropy(EntropyEntity parentEntropy) {
        this.parentEntropy = parentEntropy;
    }

    public List<EntropyEntity> getTargetEntropy() {
        return targetEntropy;
    }

    public void setTargetEntropy(List<EntropyEntity> targetEntropy) {
        this.targetEntropy = targetEntropy;
    }

    public List<TrainingSet> getSubSet() {
        return subSet;
    }

    public void setSubSet(List<TrainingSet> subSet) {
        this.subSet = subSet;
    }

    public void countGains() {

        //parentEntropy = 
        //List<EntStatistic> stat = e;

        //for (int i = 0; i < stat.size(); i++) {
        //    
        //}
        if (gains == null) {
            gains = new ArrayList<GainsEntity>();
        }

        if (modelParentEnt == null) {
            modelParentEnt = new EntropyModel();
        }

        if (parentEntropy == null) {
            parentEntropy = new EntropyEntity();
            modelParentEnt.setDataSet(subSet);
            //modelParentEnt.countProportion(this.numField);

        }

      
        for (int i = 0; i < HelpAttribute.getAtribut().size() - 1; i++) {

          
            if (HelpAttribute.isAvailable(i)) {
                System.out.println(HelpAttribute.getAtribut().get(i).getAttribute() + " : ");
                //initiate
                GainsEntity gainTemp = new GainsEntity();
                EntropyModel model = new EntropyModel();
                //passing params to model of entropy
             
                model.setDataSet(subSet);
                model.countProportion(i);
                targetEntropy = model.countAllEntropy();

                //pasting to gains entity
                gainTemp.setNumField(i);
                gainTemp.setEntropyParent(parentEntropy);
                gainTemp.setEntropyTarget(targetEntropy);
                gainTemp.setCountDataSet(subSet.size());
                gainTemp.gainsProgress();
                gains.add(gainTemp);
                //gainTemp.set
            }
        }

    }

    public GainsEntity biggestValue() {
        GainsEntity max = new GainsEntity();

        for (int i = 0; i < gains.size(); i++) {
            if (i == 0) {
                max = gains.get(i);
            } else {
                if (gains.get(i).getGains() > max.getGains()) {
                    max = gains.get(i);
                }
            }
        }

        HelpAttribute.getAtribut().get(max.getNumField()).setState(true);
        return max;

    }
}
