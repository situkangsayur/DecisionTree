/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontreeid3.cs.gui.widget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.DefaultListModel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author hendri
 */
public class Tree extends JTree {

    private TreeNode tree;

    public TreeNode getTree() {
        return tree;
    }

    public void setTree(TreeNode tree) {
        this.tree = tree;
    }

    public Tree() {

        setOpaque(false);
        
        setBackground(new Color(0.0F, 0.0F, 0.0F, 0.0F));
        setBorder(new EmptyBorder(4, 4, 4, 4));
        setForeground(new Color(255, 255, 255));
        //setSelectionBackground(new Color(255, 0, 0));

    }

    public void setModelTree(TreeNode root) {
        this.tree = root;
        setModel(new DefaultTreeModel(this.tree));
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g);
    }
}
