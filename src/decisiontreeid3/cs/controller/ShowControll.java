/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeid3.cs.controller;

import decisiontreeid3.cs.gui.ShowPanel;
import decisiontreeid3.cs.model.ShowModel;

/**
 *
 * @author hendri
 */
public class ShowControll {

    private ShowPanel view;
    private ShowModel model;

    public void setModel(ShowModel model) {
        this.model = model;
    }

    public void setView(ShowPanel view) {
        this.view = view;
    }

    public void startTree() {
        model.startIDTree();
    }
}
