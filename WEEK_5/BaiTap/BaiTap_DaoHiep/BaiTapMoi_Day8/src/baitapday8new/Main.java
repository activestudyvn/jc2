/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapday8new;

import java.io.FileNotFoundException;

/**
 *
 * @author Hell
 */
public class Main {
    public static void main(String[] args) {
        Execute execute = new Execute("D:/messages.txt");
        execute.setMap();
        execute.write();
    }
}
