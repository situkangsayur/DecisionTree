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
public class ResultEntity {

    private static List<String> val;
    private static int pos;
    private static boolean done;

    public static boolean isDone() {
        return done;
    }

    public static void setDone(boolean done) {
        ResultEntity.done = done;
    }
    
    
    private static void setDefault() {
        if (val == null) {
            val = new ArrayList<String>();
        }
    }

    public static List<String> getVal() {
        if (val == null) {
            setDefault();
        }
        return val;
    }

    public static void setVal(List<String> val) {
        ResultEntity.val = val;
    }

    public static int findResult(String input) {

        if (val == null) {
            setDefault();
        }

        ResultEntity.pos = 0;

        for (int i = 0; i < val.size(); i++) {
            if (val.get(i).equalsIgnoreCase(input)) {
                ResultEntity.pos = i;
                break;
            }
        }
        return ResultEntity.pos;

    }
}
