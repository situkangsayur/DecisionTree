/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeid3.cs;

import decisiontreeid3.cs.entities.EntropyEntity;
import decisiontreeid3.cs.entities.GainsEntity;
import decisiontreeid3.cs.entities.QueryParamters;
import decisiontreeid3.cs.entities.TrainingSet;
import decisiontreeid3.cs.entities.TreeNode;
import decisiontreeid3.cs.model.EntropyModel;
import decisiontreeid3.cs.model.GainsModel;
import decisiontreeid3.cs.services.Attribute;
import decisiontreeid3.cs.services.Database;
import decisiontreeid3.cs.services.HelpAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author hendri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //List<Attribute> list = HelpAttribute.getAtribut();
        int step = 0;
        int numOfNode = 0;
        int nodeStep = 0;
        //databases control

        EntityManager manager;
        Query query;
        List<TrainingSet> mainDataSet = null;
        String queryString;


        EntropyModel model;
        EntropyModel modelRoot = new EntropyModel();
        GainsModel modelGains;
        EntropyEntity parent = new EntropyEntity();

        //treeNode
        TreeNode mainNode = new TreeNode();
        mainNode.setDeepLevel(1);
        manager = Database.getEntityManager();

        int possible = 1;

        while ((HelpAttribute.checkState() > 0) && (possible != 0)) {
            model = new EntropyModel();
            modelGains = new GainsModel();
          

            if (step == 0) {
                possible = 0;
                queryString = "SELECT t FROM TrainingSet t";
                query = manager.createQuery(queryString);
                mainDataSet = query.getResultList();
             
                modelRoot.setDataSet(mainDataSet);
                modelRoot.countProportion(5);
                modelRoot.countFirstEntropy();
                parent = modelRoot.getEntropyEnt();

                mainNode.setQueryNode(queryString);
                for (TrainingSet data : mainDataSet) {
                    System.out.println(" -- " + data.getDay() + "--" + data.getOutLook()
                            + "--" + data.getTemperatur() + "--" + data.getHumadity() + "--"
                            + data.getWind() + "--" + data.getPlayTennis());
                }


            } else {
                if (mainNode.getNode() == null) {
                    System.out.println("=============================================================");
                    System.out.println(" level = " + mainNode.getDeepLevel());
                    System.out.println("=============================================================");
                    String parentValue = mainNode.getEntropyParent().getValueName();
                    Integer numField = mainNode.getParentNode().getNumField();
                    String parentField = HelpAttribute.getAtribut().get(numField).getAttribute();
                    String original = parentField;
                    if (parentField.indexOf("_") != -1) {
                        parentField = parentField.substring(0, parentField.indexOf("_"))
                                + parentField.substring(parentField.indexOf("_") + 1, parentField.indexOf("_") + 2).toUpperCase()
                                + parentField.substring(parentField.indexOf("_") + 2, parentField.length()).toLowerCase();

                    }

                    String paramField = parentField.substring(0, 1).toLowerCase()
                            + parentField.substring(1, parentField.length());
                   // System.out.println(paramField);
                    paramField = paramField.trim();

                    if (mainNode.getDeepLevel() == 2) {

                        queryString = mainNode.getParentNode().getQueryNode() + " WHERE t." + paramField
                                + " = :" + paramField;
                      //  System.out.println(queryString);
                    } else {

                        queryString = mainNode.getParentNode().getQueryNode();
                        queryString += " and t." + paramField + " = :" + paramField;
                      
                    }
                    query = manager.createQuery(queryString);

                    List<QueryParamters> params;

                    if (mainNode.getParentNode().getParameters() != null) {
                        params = new ArrayList<QueryParamters>(mainNode.getParentNode().getParameters());
                    } else {
                        params = new ArrayList<QueryParamters>();
                    }


                    QueryParamters newParam = new QueryParamters();
                    newParam.setParameter(paramField);
                    newParam.setValue(parentValue);
                    params.add(newParam);

               
                    for (QueryParamters qr : params) {
                        query.setParameter(qr.getParameter(), (Object) qr.getValue());

                    }


                    List<TrainingSet> subSet = query.getResultList();

                    mainNode.setQueryNode(queryString);
                    mainNode.setParameters(params);

                    mainDataSet = subSet;
                    modelRoot = new EntropyModel();
                    modelRoot.setDataSet(subSet);
                    modelRoot.countProportion(5);
                    modelRoot.countFirstEntropy();
                    parent = modelRoot.getEntropyEnt();


                    for (TrainingSet data : mainDataSet) {
                        System.out.println(" -- " + data.getDay() + "--" + data.getOutLook()
                                + "--" + data.getTemperatur() + "--" + data.getHumadity() + "--"
                                + data.getWind() + "--" + data.getPlayTennis());
                    }
                }

            }

            ///run main logic
            if (mainNode.getNode() == null) {
                System.out.println("");

                modelGains.setParentEntropy(parent);
                //   modelGains.setTargetEntropy(allEnt);
                modelGains.setSubSet(mainDataSet);
                modelGains.countGains();

                for (GainsEntity data : modelGains.getGains()) {
                    System.out.println("--------->> gain => " + HelpAttribute.getAtribut().get(data.getNumField()).getAttribute() + " : " + data.getGains());
                }

                GainsEntity biggestGains = modelGains.biggestValue();

                System.out.println("------------>>>biggest gains : " + HelpAttribute.getAtribut().get(modelGains.biggestValue().getNumField()).getAttribute()
                        + " with gains = " + biggestGains.getGains());

                System.out.println("hasil dari biggest val : " + modelGains.biggestValue().getNumField());

                mainNode.setNumField(modelGains.biggestValue().getNumField());
              
                //mainNode.setGainParent(biggestGains);
                //mainNode.setEntropyParent(biggestGains.getEntropyParent());
                mainNode.setChecking(true);

                List<TreeNode> childs = new ArrayList<TreeNode>();

                numOfNode = biggestGains.getEntropyTarget().size();

             

                for (int i = 0; i < numOfNode; i++) {
                    TreeNode tempNode = new TreeNode();
                    possible++;
                    //check direct value that not need any leaf
                    //set information value
                    tempNode.setEntropyParent(biggestGains.getEntropyTarget().get(i));
                    tempNode.setGainParent(biggestGains);
                    //parent value

                    tempNode.setTotalOfValue(numOfNode);
                    //alternative that this not done                
                    tempNode.setResultValue(null);
                    tempNode.setChecking(false);
                    tempNode.setDeepLevel(mainNode.getDeepLevel() + 1);

                    int temp = 0;
                    boolean solidVal = false;
                 
                    for (int j = 0; j < biggestGains.getEntropyTarget().get(i).getSpecVal().size(); j++) {

                       // System.out.println(biggestGains.getEntropyTarget().get(i).getSpecVal().size());

                        temp += biggestGains.getEntropyTarget().get(i).getSpecVal().get(j);

                     //   System.out.println("val part  " + j + " : " + biggestGains.getEntropyTarget().get(i).getSpecVal().get(j));

                        if (biggestGains.getEntropyTarget().get(i).getSpecVal().get(j) == 0) {
                       //     System.out.println(" ada nol");
                            solidVal = true;
                        }
                        if (solidVal) {
                            tempNode.setChecking(true);
                            tempNode.setNode(null);
                            tempNode.setNumField(null);
                            tempNode.setResultValue(temp);
                     
                        }
                       
                    }
                   
                    tempNode.setParentNode(mainNode);
                    childs.add(tempNode);
                }

                mainNode.setNode(childs);
               

            }

            boolean doneCon = false;
            int iterator = 0;
         

            for (iterator = 0; iterator < mainNode.getNode().size(); iterator++) {
         
                if (mainNode.getNode().get(iterator).getResultValue() == null) {
               //     System.out.println(" result null " + mainNode.getNode().get(iterator).getEntropyParent().getValueName());
                    if (!mainNode.getNode().get(iterator).isChecking()) {
                 //       System.out.println(" result false " + mainNode.getNode().get(iterator).getEntropyParent().getValueName());
                        break;
                    } else {
                        possible--;
                        if (iterator < mainNode.getNode().size() - 1) {
                   //         System.out.println("next");

                            continue;
                        }
                  //      System.out.println("pass");
                    }
                } else {

                    if (iterator < (mainNode.getNode().size() - 1)) {
                        System.out.println("next");
                        possible--;
                        continue;
                    }
                }
                doneCon = true;

            }
           // System.out.println("iterator after = " + iterator);


            if (!doneCon) {
                System.out.println("forward");
                mainNode = mainNode.getNode().get(iterator);

            } else {
                System.out.println("backward");

                mainNode = mainNode.getParentNode();
                //System.out.println(HelpAttribute.getAtribut().get(mainNode.getNumField()).getAttribute());
            }

            System.out.println("end");
            step++;
        }
    }
}
