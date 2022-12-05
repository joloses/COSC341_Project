package com.example.cosc341_project;

public class Global {
    private static Global instance = new Global();
    boolean firstTime = true;
    int one = 0;
    int two = 0;
    int three = 0;
    int point = 0;

    String fname = "";
    String lname = "";
    String age = "";
    String gender = "";
    String sport1 = "";
    String sport2 = "";
    String sport3 = "";
    String sport4 = "";
    String sport5 = "";

    public static Global getInstance() {
        return instance;
    }

    public static void setInstance(Global instance) {
        Global.instance = instance;
    }

    public boolean empty() {
        return (one == 0 && two == 0 && three == 0);
    }

    public boolean isFirst() { return firstTime; }

    public void changeFirst() { firstTime = false; }

    public void setPoint(int i) { point = i; }
    public void setOne() { one = 1; }
    public void setTwo() { two = 1; }
    public void setThree() { three = 1; }

    public int getPoint() { return point; }
    public int getOne() { return one; }
    public int getTwo() { return two; }
    public int getThree() { return three; }



}
