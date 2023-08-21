package com.example.demolistview;

import androidx.annotation.NonNull;

public class information {
    private String subjectName;
    private String stc;
    private String nameTeacher;
    public information(){

    }
    public information(String subjectName,String nameTeacher, String stc){
        this.nameTeacher = nameTeacher;
        this.stc = stc;
        this.subjectName = subjectName;
    }

    @NonNull
    @Override
    public String toString() {
        return subjectName + ": " + nameTeacher+ ": " + stc;
    }
}
