/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.file;

import com.kiemanh.vn.common.AppLogger;
import dev.hiepdv.message.TinNhan;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hell
 */
public class ReadMessage extends ReadFile {

    public ReadMessage(String filePath) {
        try {
            setReader(filePath);
            AppLogger.getInstance().debug("- Mo file message");
        } catch (FileNotFoundException ex) {
            AppLogger.getInstance().debug("- Loi  duong dan file message");
        }
    }

    private String getThueBao() {
        Matcher match = Pattern.compile("\\d{10,12}").matcher(line);
        match.find();
        return line.substring(match.start() + 1, match.end());
    }

    private String getNoidung() {
        Matcher match = Pattern.compile("\\(\\w*\\|").matcher(line);
        match.find();
        return line.substring(match.start() + 1, match.end() - 1);
    }

    private Date getThoiGianGui() throws ParseException {
        Matcher match = Pattern.compile("\\|.*\\|").matcher(line);
        match.find();
        String temp = line.substring(match.start() + 1, match.end() - 1);
        return new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").parse(temp);
    }

    private String getDauSo() {
        Matcher match = Pattern.compile("\\|[0-9]*\\)").matcher(line);
        match.find();
        return line.substring(match.start() + 1, match.end() - 1);
    }

    @Override
    public TinNhan getNext() {

        try {
            TinNhan tinNhan = new TinNhan();
            readLine();
            tinNhan.setThueBao(getThueBao());
            tinNhan.setNdTin(getNoidung());
            tinNhan.setThoiGianGui(getThoiGianGui());
            tinNhan.setDauSo(getDauSo());

            return tinNhan;
        } catch (IOException ex) {
            AppLogger.getInstance().debug("-Doc message bi loi");
        } catch (ParseException ex) {
            AppLogger.getInstance().debug("-Loi dinh dang ngay");
        }
        return null;

    }

}
