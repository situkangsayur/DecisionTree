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
public class TreeNode {
    //node Information
    //header

    private List<TreeNode> node;
    private TreeNode parentNode;
    //name of node and level of node information
    private Integer numField;
    private Integer totalOfValue;
    //query information
    private Integer deepLevel;
    private String queryNode;
    private List<QueryParamters> parameters;
    //aclcualtion gains information
    private EntropyEntity entropyParent;
    private GainsEntity gainParent;
    //check avalaible and final result
    private boolean checking;
    private Integer resultValue;

    public List<QueryParamters> getParameters() {
        return parameters;
    }

    public void setParameters(List<QueryParamters> parameters) {
        this.parameters = parameters;
    }

    public String getQueryNode() {
        return queryNode;
    }

    public void setQueryNode(String queryNode) {
        this.queryNode = queryNode;
    }

    public Integer getDeepLevel() {
        return deepLevel;
    }

    public void setDeepLevel(Integer deepLevel) {
        this.deepLevel = deepLevel;
    }

    public Integer getResultValue() {
        return resultValue;
    }

    public void setResultValue(Integer resultValue) {
        this.resultValue = resultValue;
    }

    public boolean isChecking() {
        return checking;
    }

    public void setChecking(boolean checking) {
        this.checking = checking;
    }

    public Integer getTotalOfValue() {
        return totalOfValue;
    }

    public void setTotalOfValue(Integer totalOfValue) {
        this.totalOfValue = totalOfValue;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public Integer getNumField() {
        return numField;
    }

    public void setNumField(Integer numField) {
        this.numField = numField;
    }

    public List<TreeNode> getNode() {
        return node;
    }

    public void setNode(List<TreeNode> node) {
        this.node = node;
    }

    public EntropyEntity getEntropyParent() {
        return entropyParent;
    }

    public void setEntropyParent(EntropyEntity entropyParent) {
        this.entropyParent = entropyParent;
    }

    public GainsEntity getGainParent() {
        return gainParent;
    }

    public void setGainParent(GainsEntity gainParent) {
        this.gainParent = gainParent;
    }
}
