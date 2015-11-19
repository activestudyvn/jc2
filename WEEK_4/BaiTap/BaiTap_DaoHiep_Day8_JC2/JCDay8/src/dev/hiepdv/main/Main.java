/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.main;

import dev.hiepdv.file.ReadMessage;
import dev.hiepdv.file.ReadStruct;
import dev.hiepdv.message.TinNhan;
import dev.hiepdv.process.Execute;
import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;




/**
 *
 * @author Hell
 */
public class Main {
    public static void main(String[] args) throws ParseException {
//        ReadStruct readStruct = new ReadStruct("E:\\JC2\\struct.txt");
        ReadMessage readMessage = new ReadMessage("E:\\JC2\\message.txt");
        TinNhan t = readMessage.getNext();
        
        Execute execute = new Execute();
        //execute.filter();
        
        System.out.println(execute.checkThoiGian(t));
        
    }
}
