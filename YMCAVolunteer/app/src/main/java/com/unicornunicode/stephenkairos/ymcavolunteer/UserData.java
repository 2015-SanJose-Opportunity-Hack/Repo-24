package com.unicornunicode.stephenkairos.ymcavolunteer;

import java.util.Date;

/**
 * Created by StephenKairos, VietHuynh, KevinQuin on 10/4/3015.
 */
public class UserData {
    public int gradeLevel;
    public int numStudents;
    public int hours;

    public String teacher;
    public String location;
    public String bookName;
    public String comments;

    public Date volunteerDate;

    public UserData(int gradeLevel, int numStudents, int hours, String teacher, String location, String bookName, String comments, Date volunteerDate) {
        if(bookName == null) {
            this.bookName = "";
        } else {
            this.bookName = bookName;
        }

        if(comments == null) {
            this.comments = "";
        } else {
            this.comments = comments;
        }

        if(teacher == null) {
            this.teacher = "";
        } else {
            this.teacher = teacher;
        }
        
        if(location == null) {
            this.location = "";
        } else {
            this.location = location;
        }

        this.gradeLevel = gradeLevel;
        this.numStudents = numStudents;
        this.hours = hours;

        this.volunteerDate = volunteerDate;
    }
}
