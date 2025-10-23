package com.iesvdc.dam.acceso.modelo;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * El modelo que almacena información de un campo y sus propiedades.
 */

public class FieldModel {
    private final String name;

    public FieldModel() {
        this.name = "";
        this.type = FieldType.UNKNOWN;
    }

    public FieldModel(String name, FieldType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public FieldType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
    private final FieldType type;

}
