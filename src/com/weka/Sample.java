/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weka;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

/**
 *
 * @author hendri_k
 */
public class Sample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    
        J48 classifier =null;
        try {
        //Classifier deserialization
        classifier = (J48) weka.core.SerializationHelper.read(args[0]);
      
        }catch(Exception ex){
            ex.printStackTrace();
        }
//        J48 cls = (J48) classifier.getCurrentModel();
//        Instances data = null;
//        try {
//            data = new Instances(new BufferedReader(new FileReader(args[0])));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        data.setClassIndex(data.numAttributes() - 1);
//        try {
//            cls.buildClassifier(data);
//        } catch (Exception ex) {
//            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
//        }

        // display classifier
        final javax.swing.JFrame jf
                = new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");
        jf.setSize(1024, 640);
        jf.getContentPane().setLayout(new BorderLayout());
        TreeVisualizer tv = null;
        try {
            tv = new TreeVisualizer(null,
                    classifier.graph(),
                    new PlaceNode2());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jf.getContentPane().add(tv, BorderLayout.CENTER);
        jf.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                jf.dispose();
            }
        });

        jf.setVisible(true);
        tv.fitToScreen();
    }
    
}
