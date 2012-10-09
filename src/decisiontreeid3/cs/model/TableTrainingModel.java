/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeid3.cs.model;

import decisiontreeid3.cs.entities.TrainingSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hendri
 */
public class TableTrainingModel extends AbstractTableModel {

    private List<TrainingSet> list = new ArrayList<TrainingSet>();

    public void setList(List<TrainingSet> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;

    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getDay();
            case 1:
                return list.get(rowIndex).getOutLook();
            case 2:
                return list.get(rowIndex).getTemperatur();
            case 3:
                return list.get(rowIndex).getHumadity();
            case 4:
                return list.get(rowIndex).getWind();
            case 5:
                return list.get(rowIndex).getPlayTennis();

            default:
                return null;

        }
    }

    public TrainingSet set(int index, TrainingSet element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }

    }

    public TrainingSet remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public TrainingSet get(int index) {
        return list.get(index);
    }

    public boolean add(TrainingSet e) {
        try {
            return list.add(e);

        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "Day";
            case 1:
                return "OutLook";
            case 2:
                return "Temperatur";
            case 3:
                return "Humidity";
            case 4:
                return "Wind";
            case 5:
                return "PlayTennis";

            default:
                return null;

        }

    }
}
