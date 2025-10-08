package com.iesvdc.dam.acceso;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.hpsf.Property;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        Properties p = getProperties("config.properties");
    }

    public static Properties getProperties(String nombreArchivo) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(nombreArchivo)) {
            props.load(fis);
        } catch (Exception e) {
            System.err.println("Error al cargar el properties.");
        }
        return props;
    }
}
