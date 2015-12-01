/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.process;

import com.kiemanh.vn.common.AppLogger;
import dev.hiepdv.file.ReadMessage;
import dev.hiepdv.file.ReadStruct;
import dev.hiepdv.file.WriteFile;
import dev.hiepdv.message.CuPhapTinNhan;
import dev.hiepdv.message.TinNhan;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Hell
 */
public class Execute {

    private ArrayList<CuPhapTinNhan> cuPhaps = new ArrayList<CuPhapTinNhan>();
    private ArrayList<TinNhan> tinNhans = new ArrayList<TinNhan>();
    private ArrayList<TinNhan> filter;
    private WriteFile writer =  null;

    public Execute() {
        ReadMessage readMessage = new ReadMessage("E:\\JC2\\message.txt");
        ReadStruct readStruct = new ReadStruct("E:\\JC2\\struct.txt");
        AppLogger.getInstance().debug("- Bat dau lay du lieu tu message");
        while (readMessage.hasNext()) {
                tinNhans.add(readMessage.getNext());
                AppLogger.getInstance().debug("- Them moi 1 TinNhan");
        }
        
        AppLogger.getInstance().debug("- Bat dau lay du lieu tu Struct.txt");
        while (readStruct.hasNext()) {            
            cuPhaps.add(readStruct.getNext());
            AppLogger.getInstance().debug("- Them moi 1 CuPhapTinNhan");
        }
        
        AppLogger.getInstance().debug("- Sap xep lai message theo thoi gian");
        
        Collections.sort(tinNhans, new Comparator<TinNhan>() {
            @Override
            public int compare(TinNhan tn1, TinNhan tn2) {
                return tn1.getThoiGianGui().compareTo(tn2.getThoiGianGui());
                
            }
        });
        
        Iterator<TinNhan> itr1 = tinNhans.iterator();
        while(itr1.hasNext()) {
            System.out.println(itr1.next().getThoiGianGui());
        }
        
    }

    public void filter() {
        filter = new ArrayList<>();
        Iterator<TinNhan> itr = tinNhans.iterator();
        TinNhan temp = null;
        while(itr.hasNext()) {
            temp = itr.next();
            if(checkCuPhap(temp) && checkThoiGian(temp)) {
               filter.add(temp);
               AppLogger.getInstance().debug("- Loc 1 message");
            }
        }
        
//        AppLogger.getInstance().debug("- Danh sach sau khi loc");
//        Iterator<TinNhan> itr1 = filter.iterator();
//        while(itr1.hasNext()) {
//            System.out.println(itr1.next().getThoiGianGui());
//        }        
    }
    
    public void writer(){
        writer = new WriteFile("E:/out.txt");
        Iterator<TinNhan> itr = filter.iterator();
        while (itr.hasNext()) {
            writer.write(itr.next());
        }
        writer.close();
    }
    
    
    private boolean checkCuPhap(TinNhan tinNhan) {
        boolean checkCuPhap;
        String dauSo = tinNhan.getDauSo();

        CuPhapTinNhan temp = null;
        Iterator<CuPhapTinNhan> itr = cuPhaps.iterator();
        while (itr.hasNext()) {
            temp = itr.next();
            if (dauSo.equals(temp.getDauSo())) {
                break;
            }
        }
        String[] cuPhap = temp.getCuPhap();
        for (int index = 0; index < cuPhap.length; index++) {
            if (tinNhan.getNdTin().equalsIgnoreCase(cuPhap[index])) {
                return true;
            }
        }

        return false;
    }
    
    private boolean checkThoiGian(TinNhan tinNhan) {
        Date today = new Date();
        boolean check1 = today.after(tinNhan.getThoiGianGui())
                || today.equals(tinNhan.getThoiGianGui());
        
        if (hasPrevious(tinNhan)) {
            boolean check2 = false;
            TinNhan temp;

            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();

            Iterator<TinNhan> itr = tinNhans.iterator();
            while (itr.hasNext()) {
                temp = itr.next();
                if (temp.getDauSo().equals(tinNhan.getDauSo())
                        && temp.getThueBao().equals(tinNhan.getThueBao())) {

                    calendar1.setTime(tinNhan.getThoiGianGui());
                    calendar2.setTime(temp.getThoiGianGui());
                    if (calendar1.after(calendar2)) {
                        calendar2.add(Calendar.MONTH, 1);
                        check2 = calendar1.after(calendar2);
                    } 
                }
            }

            return (check1 && check2);
        } else {
            return check1;
        }
    }

    private boolean hasPrevious(TinNhan tinNhan) {
        TinNhan temp;
        int index = tinNhans.indexOf(tinNhan);
        Iterator<TinNhan> itr = tinNhans.iterator();
        
        while(itr.hasNext()) {
            temp = itr.next();
            if (temp.getDauSo().equals(tinNhan.getDauSo())
                    && temp.getThueBao().equals(tinNhan.getThueBao())
                    && tinNhan.getThoiGianGui().after(temp.getThoiGianGui())) {
                return true;
            }
        }
        return false;
    }
    
}
