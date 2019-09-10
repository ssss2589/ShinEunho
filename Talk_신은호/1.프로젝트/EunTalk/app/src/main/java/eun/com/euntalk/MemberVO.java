package eun.com.euntalk;

import android.graphics.drawable.Drawable;

public class MemberVO {

    private Drawable icon;
    private String name;
    private String id;
    private String pw;
    private int frendStats = 0;
    public int getFrendStats() {
        return frendStats;
    }
    public void setFrendStats(int frendStats) {
        this.frendStats = frendStats;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}