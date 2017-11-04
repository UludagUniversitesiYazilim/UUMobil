package com.example.berkay.uumobil.results;


public final class Result {
    private String courseName;
    private String examType;
    private String point;

    public Result (String courseName, String examType, String point){
        this.courseName = courseName;
        this.examType = examType;
        this.point = point;
    }

    String getCourseName() {return courseName;}

    String getExamType() {return examType;}

    String getPoint() {return point;}

}
