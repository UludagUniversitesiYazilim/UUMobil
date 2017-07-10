package com.example.berkay.uumobil.calendar;

public class CalendarContent {

    private String title;
    private String content;
    private String footer;

    public CalendarContent(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

}
