/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.process;

import com.kiemanh.vn.common.AppLogger;
import dev.hiepdv.file.ReadMessage;
import dev.hiepdv.file.ReadStruct;
import dev.hiepdv.message.CuPhapTinNhan;
import dev.hiepdv.message.TinNhan;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Hell
 */
public class Execute {

    private ArrayList<CuPhapTinNhan> cuPhaps = new ArrayList<CuPhapTinNhan>();
    private ArrayList<TinNhan> tinNhans = new ArrayList<TinNhan>();

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
        
        
    }

    public void filter() {
        ArrayList<TinNhan> filter = new ArrayList<>();
        Iterator<TinNhan> itr = tinNhans.iterator();
        TinNhan temp = null;
        while(itr.hasNext()) {
            temp = itr.next();
            if(checkCuPhap(temp) && checkThoiGian(temp))
               filter.add(temp);
        }
        
        Iterator<TinNhan> itr1 = filter.iterator();
        while(itr1.hasNext()) {
            System.out.println(itr1.next());
        }
        
//        Iterator<CuPhapTinNhan> itr2 = cuPhaps.iterator();
//        while(itr2.hasNext()) {
//            System.out.println(itr2.next());
//        }
    }
    
    public boolean checkCuPhap(TinNhan tinNhan) {
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

    public boolean checkThoiGian(TinNhan tinNhan) {
        Date today = new Date();
        boolean check1 = today.after(tinNhan.getThoiGianGui())
                || today.equals(tinNhan.getThoiGianGui());
        if (hasDoubleTinNhan(tinNhan)) {
            boolean check2 = false;
            TinNhan tn;

            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();

            Iterator<TinNhan> itr = tinNhans.iterator();
            while (itr.hasNext()) {
                tn = itr.next();
                if (tn.getDauSo().equals(tinNhan.getDauSo())
                        && tn.getThueBao().equals(tinNhan.getThueBao())) {

                    calendar1.setTime(tinNhan.getThoiGianGui());
                    calendar2.setTime(tn.getThoiGianGui());
                    if (calendar1.after(calendar2)) {
                        calendar2.add(Calendar.MONTH, 1);
                    } else {
                        calendar1.add(Calendar.MONTH, 1);
                    }

                    if (calendar1.equals(calendar2)) {
                        check2 = true;
                    }

                }
            }

            return (check1 && check2);
        } else {
            return check1;
        }
    }

    public boolean hasDoubleTinNhan(TinNhan tinNhan) {
        Iterator<TinNhan> itr = tinNhans.iterator();
        TinNhan temp;
        while (itr.hasNext()) {
            temp = itr.next();
            if (temp.getDauSo().equals(tinNhan.getDauSo())
                    && temp.getThueBao().equals(tinNhan.getThueBao())) {
                return true;
            }
        }
        return false;
    }
    
    private void test() {
        Iterator<TinNhan> itr = tinNhans.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        
//        Iterator<CuPhapTinNhan> itr2 = cuPhaps.iterator();
//        while(itr2.hasNext()) {
//            System.out.println(itr2.next());
//        }
    }
}
