/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maihuutai
 */
public class TinTuc {
    private String id;
    private String title;
    private String content;
    private int view;
    private double cost;

    public TinTuc() {
    }

    public TinTuc(String id, String title, String content, int view, double cost) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.view = view;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "TinTuc{" + "id=" + id + ", title=" + title + ", content=" + content + ", view=" + view + ", cost=" + cost + '}';
    }
    
    
}
