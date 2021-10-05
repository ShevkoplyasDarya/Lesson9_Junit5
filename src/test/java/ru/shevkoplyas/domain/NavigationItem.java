package ru.shevkoplyas.domain;

public enum NavigationItem {
           OVERVIEW("Overview"),
           REPOSITORIES("Repositories"),
           PROJECTS("Projects"),
           PACKAGES("Packages");

           private String desc;

           NavigationItem(String desc) {this.desc = desc;}
    public String getDesc() {return  desc;}

}
