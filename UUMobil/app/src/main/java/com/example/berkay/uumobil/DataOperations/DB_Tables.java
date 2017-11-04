package com.example.berkay.uumobil.DataOperations;


enum DB_Tables {
    FOODLIST("FOODLIST", new String[]{"ID", "Date", "Food_1", "Food_2", "Food_3", "Food_4"},
            "CREATE TABLE FOODLIST (ID INT PRIMARY_KEY AUTO_INCREMENT," +
                    "Date TEXT," +
                    "Food_1 TEXT," +
                    "Food_2 TEXT," +
                    "Food_3 TEXT," +
                    "Food_4 TEXT)"),

    SETTINGS("SETTINGS", new String[]{"ID", "Key", "Value"},
            "CREATE TABLE SETTINGS (ID INT PRIMARY_KEY AUTO_INCREMENT," +
                    "Key TEXT," +
                    "Value TEXT)"),

    RESULTS("RESULTS", new String[]{"ID", "Name", "Type", "Mark"},
            "CREATE TABLE RESULTS (ID INT PRIMARY_KEY AUTO_INCREMENT," +
                    "Name TEXT," +
                    "Type TEXT," +
                    "Mark TEXT)"),

    PERSONAL("PERSONAL", new String[]{"ID", "Name", "Number", "Period", "UnitName", "Statue", "DateLogin", "Username", "Password"},
            "CREATE TABLE PERSONAL (ID INT PRIMARY_KEY AUTO_INCREMENT," +
                    "Name TEXT," +
                    "Number TEXT," +
                    "Period TEXT," +
                    "UnitName TEXT," +
                    "Statue TEXT," +
                    "DateLogin TEXT," +
                    "Username TEXT," +
                    "Password TEXT)"),

    TRANSCRIPT("TRANSCRIPT", new String[]{"ID", "Lesson_Code", "Lesson_Name", "Credit", "Mark", "Average"},
            "CREATE TABLE TRANSCRIPT(ID INT PRIMARY_KEY AUTO_INCREMENT," +
            "Lesson_Code TEXT," +
            "Lesson_Name TEXT," +
            "Credit TEXT," +
            "Mark TEXT," +
            "Average TEXT)");

    private String tableName;
    private String[] columns;
    private String query;

    DB_Tables(String table_name, String[] columns, String query){
        this.tableName = table_name;
        this.columns = columns;
        this.query = query;
    }

    public String getTableName() {
        return tableName;
    }

    public String[] getColumns() {
        return columns;
    }

    public String getQuery() {
        return query;
    }
}
