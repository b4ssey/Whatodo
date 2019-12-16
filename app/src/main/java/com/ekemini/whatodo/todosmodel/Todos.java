package com.ekemini.whatodo.todosmodel;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table(name = "what_to_do")
public class Todos extends SugarRecord {

    private String createTitle;
    private String createPlanning;
    private String createDate;

    public Todos(){

    }

    public Todos(String createTitle, String createPlanning, String createDate){
        this.createTitle = createTitle;
        this.createPlanning = createPlanning;
        this.createDate = createDate;
    }

    public String getCreateTitle() {
        return createTitle;
    }

    public void setCreateTitle(String createTitle) {
        this.createTitle = createTitle;
    }

    public String getCreatePlanning() {
        return createPlanning;
    }

    public void setCreatePlanning(String createPlanning) {
        this.createPlanning = createPlanning;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
