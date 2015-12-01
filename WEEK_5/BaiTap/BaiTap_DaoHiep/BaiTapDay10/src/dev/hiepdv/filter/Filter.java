/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hellb
 */
public class Filter {
    protected List<String> tinNhans;
    protected List<String> tinDaLoc;

    public Filter(List<String> tinNhans) {
        this.tinNhans = tinNhans;
        this.tinDaLoc = new ArrayList<>();
    }
    
    public boolean checkForm(String line) {
            Matcher match1 = Pattern.compile("84\\d{9}").matcher(line);
            Matcher match2 = Pattern.compile("fuck|shit|DCM").matcher(line);
            return match1.find()&& !match2.find();
    }
}
