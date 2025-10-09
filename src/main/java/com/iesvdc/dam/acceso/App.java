package com.iesvdc.dam.acceso;

import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.InputStream;
import java.sql.Connection;
// import java.util.Enumeration;
import java.util.Properties;

import com.iesvdc.dam.acceso.conexion.Conexion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Leer Fichero de Propiedades:" );
        Properties p = getProperties("config.properties");

        try (Connection conexion = Conexion.getConection(p)) {
            if (conexion!=null) 
                System.out.println("Conectado correctamente.");
            else 
                System.out.println("Imposible conectar");
        } catch (Exception e) {
            System.err.println("No se pudo conectar.");
            e.printStackTrace();
        }

    
        
        /*
        // Así podríamos recorrer las propiedades:

        Enumeration e = p.propertyNames();

        while (e.hasMoreElements()){
            String nombre = e.nextElement().toString();
            System.out.println(
                "Propiedad: " + nombre +
                " valor: "+p.getProperty(nombre));

        }
        */

        /*
        // Así guardamos en XML las propiedades.

        try (FileOutputStream fos = new FileOutputStream("propiedades.xml")){
            p.storeToXML(fos, "Fichero de configuración");
        } catch (Exception e) {
            
        }*/


        
    }

    static public Properties getProperties(String nombreArchivo) {
        Properties props = new Properties();
        try (FileInputStream is = new FileInputStream(nombreArchivo)) {
            props.load(is);            
        } catch (Exception e) {
            System.out.println("Imposible cargar el archivo de propiedades.");
        }
        
        return props;
    }
}

