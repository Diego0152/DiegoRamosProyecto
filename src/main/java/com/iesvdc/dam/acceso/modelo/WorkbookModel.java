package com.iesvdc.dam.acceso.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;


/**
 * El modelo que almacena el libro o lista de tablas.
 */
public class WorkbookModel {
    private List<TableModel> tables = new ArrayList<>();

    public WorkbookModel() {
        this.tables = null;
    }

    public WorkbookModel(List<TableModel> tables) {
        this.tables = tables;
    }

    public List<TableModel> getTables() {
        return this.tables;
    }


    @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        return "{" +
            " tables='" + getTables() + "'" +
            "}";
    }

    

}
