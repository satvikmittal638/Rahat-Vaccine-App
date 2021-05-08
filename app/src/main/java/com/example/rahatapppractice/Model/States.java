package com.example.rahatapppractice.Model;

public class States {
    private String name;
    private String helpline;

    public States(String name, String helpline_num) {
        this.name = name;
        this.helpline = helpline_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelpline() {
        return helpline;
    }

    public void setHelpline(String helpline) {
        this.helpline = helpline;
    }
}
