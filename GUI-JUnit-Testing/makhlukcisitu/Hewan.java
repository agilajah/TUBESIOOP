/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makhlukcisitu;

/**
 *
 * @author Amal Qurany / 13514078
 */
public abstract class Hewan extends Makhluk{
    /**
     * Konstruktor hewan
     * @param id parameter input id hewan
     * @param x parameter input koordinat x
     * @param y parameter input koordinat y
     * @param karakter parameter input karakter hewan
     */
    public Hewan(int id, int x, int y, char karakter){
            super(id, x, y, karakter, 0);
    }
    
    /**
     * prosedur gerak sebagi parent dari turunannya.
     * prosedur ini kosong dan akan di implementasikan di kelas turunannya.
     */
    public abstract void gerak();
}