
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maihuutai
 */
public class Manager {
    private ArrayList<TinTuc> listTinTuc;
    
    public Manager() {
        this.listTinTuc = new ArrayList<TinTuc>();
        
    }

    public ArrayList<TinTuc> getListTinTuc() {
        return listTinTuc;
    }

    public void setListTinTuc(ArrayList<TinTuc> listTinTuc) {
        this.listTinTuc = listTinTuc;
    }
    
    public void create() {
        Scanner sc = new Scanner(System.in);
        String id = null;
        boolean check = true;
        do {
            try {
                System.out.println("Nhập id: ");
                id = sc.nextLine();
                if (this.checkIDExists(id)) {
                    throw new IDExistException("IDEXistException.");
                }
                check = false;
            } catch(IDExistException o) {
                System.out.println("Lỗi: ID này đã tồn tại.");
                check = true;
            }
        
        } while (!id.matches("^N\\d{4}$") || check);
        
        //CheckTitle
        int countString = 0;
        String title = null;
        do {
            System.out.println("Nhập title: ");
            title = sc.nextLine();
            countString = title.length();
            if (countString < 10 || countString > 50) {
                System.out.println("Title tối thiểu 10 kí tự, tối đa 50 kí tự.");
            }
        } while (countString < 10 || countString > 50);
        
        //Check Content
        countString = 0;
        String content = null;
        do {
            System.out.println("Nhập content: ");
            content = sc.nextLine();
            countString = content.length();
            if (countString < 20 || countString > 250) {
                System.out.println("Content tối thiểu 20 kí tự, tối đa 250 kí tự.");
            }
        } while (countString < 20 || countString > 250);
        
        //Check View
        int view = 0;
        do {
            System.out.println("Nhập view: ");
            view = Integer.parseInt(sc.nextLine());
            if (view < 0) {
                System.out.println("Số lượng view không được nhỏ hơn 0.");
            }
        } while (view < 0);
        
        double cost = 0;
        do {
            System.out.println("Nhập cost: ");
            cost = Double.parseDouble(sc.nextLine());
        if (cost < 0) {
                System.out.println("Cost không được nhỏ hơn 0.");
            }
        } while (cost < 0);
        
          
        TinTuc tintuc = new TinTuc(id, title, content, view, cost);
        this.listTinTuc.add(tintuc);
        System.out.println("Add thành công.");
    }
    
    public boolean checkIDExists(String id) {
        for (TinTuc tintuc: this.listTinTuc) {
            if (tintuc.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public void read() {
        for (TinTuc tintuc: this.listTinTuc) {
            System.out.println(tintuc.toString());
        }
    }
    
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id tin tuc cần xoá: ");
        String id = sc.nextLine();
        
        if (!this.checkIDExists(id)) {
            System.out.println("Không có id trong list.");
        }
        for (int i = 0; i < this.listTinTuc.size(); i++) {
            if (listTinTuc.get(i).getId().equals(id)) {
                this.listTinTuc.remove(i);
                System.out.println("Xoá thành công.");
            }
        }
    }
    
    public void details() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id của tin tức cần tìm: ");
        String id = sc.nextLine();
        for (TinTuc tintuc: this.listTinTuc) {
            if (tintuc.getId().equals(id)) {
                System.out.println(tintuc.toString());
            }
        }
    }
    
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id tin tức cần update: ");
        String id = sc.nextLine();
        TinTuc temp = new TinTuc();
        
        for (TinTuc tintuc: this.listTinTuc) {
            if (tintuc.getId().equals(id)) {
                temp = tintuc;
            }
        }
        
        System.out.println("Nhập title: ");
        String title = sc.nextLine();
        if (!title.isEmpty()) {
            temp.setTitle(title);
        }
        System.out.println("Nhập content: ");
        String content = sc.nextLine();
        if (!content.isEmpty()) {
            temp.setContent(content);
        }
        
        System.out.println("Nhập view: ");
        String strView = sc.nextLine();
        if (!strView.isEmpty()) {
            temp.setView(Integer.parseInt(strView));
        }
        System.out.println("Nhập cost: ");
        String strCost = sc.nextLine();
        if (!strCost.isEmpty()) {
            temp.setCost(Double.parseDouble(strCost));
        }
    }
    
    public void write(String fileName) {
        
        try {
            File f = new File("/Users/maihuutai/Desktop/"+fileName+".txt");
            FileWriter fw = new FileWriter(f); // write()
            PrintWriter pw = new PrintWriter(fw);
            
            for (TinTuc tintuc: this.listTinTuc) {
                pw.println(tintuc.getId()+","+tintuc.getTitle()+","+tintuc.getContent()+
                        ","+tintuc.getView()+","+tintuc.getCost());
            }
            pw.close();
            fw.close();
        } catch (Exception o) {
            o.printStackTrace();
        }
    }
}

class IDExistException extends Exception {

    public IDExistException(String message) {
        super(message);
    }
    
    
}