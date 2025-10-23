package com.iesvdc.dam.acceso.modelo;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * El modelo que almacena información de una tabla y su lista de campos.
 */
public class TableModel {
    private final String name;
    private final List<FieldModel> fields = new ArrayList<>();

    public TableModel() {
        this.name = "";
    }

    public TableModel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public List<FieldModel> getFields() {
        return this.fields;
    }


    @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", fields='" + getFields() + "'" +
            "}";
    }
    
}
