/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pens.imageRetrival.model;

/**
 *
 * @author faizalami
 */
public class ImageFeature {
    
    private String name;
    private int[] LBP;

    public ImageFeature(String name, int[] LBP) {
        this.name = name;
        this.LBP = LBP;
    }

    /**
     * Get the value of LBP
     *
     * @return the value of LBP
     */
    public int[] getLBP() {
        return LBP;
    }

    /**
     * Set the value of LBP
     *
     * @param LBP new value of LBP
     */
    public void setLBP(int[] LBP) {
        this.LBP = LBP;
    }


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

}
