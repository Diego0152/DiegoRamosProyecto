package com.iesvdc.dam.acceso;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.iesvdc.dam.acceso.conexion.Conexion;
import com.iesvdc.dam.acceso.conexion.Config;
import com.iesvdc.dam.acceso.modelo.FieldModel;
import com.iesvdc.dam.acceso.modelo.FieldType;
import com.iesvdc.dam.acceso.modelo.TableModel;
import com.iesvdc.dam.acceso.modelo.WorkbookModel;

/**
 * Este programa genérico en java (proyecto Maven) es un ejercicio 
 * simple que vuelca un libro Excel (xlsx) a una base de datos (MySQL) 
 * y viceversa. El programa lee la configuración de la base de datos 
 * de un fichero "properties" de Java y luego, con apache POI, leo 
 * las hojas, el nombre de cada hoja será el nombre de las tablas, 
 * la primera fila de cada hoja será el nombre de los atributos de 
 * cada tabla (hoja) y para saber el tipo de dato, tendré que 
 * preguntar a la segunda fila qué tipo de dato tiene. 
 * 
 * Procesamos el fichero Excel y creamos una estructura de datos 
 * con la información siguiente: La estructura principal es el libro, 
 * que contiene una lista de tablas y cada tabla contiene tuplas 
 * nombre del campo y tipo de dato.
 *
 */
public class Excel2Database {
    public static void main( String[] args ) {

        try (Connection conexion = Conexion.getConnection()) {
            if (conexion!=null) 
                System.out.println("Conectado correctamente.");
            else 
                System.out.println("Imposible conectar");

            XSSFWorkbook wb; 
            WorkbookModel wbm = new WorkbookModel();
            try (FileInputStream fis = new FileInputStream("datos/personas.xlsx")){
                
                wb = new XSSFWorkbook(fis);
                int nHojas = wb.getNumberOfSheets();

                TableModel tableModel = null;

                for (int i = 0; i < nHojas; i++) {
                    XSSFSheet hojas = wb.getSheetAt(i);
                    System.out.println(hojas.getSheetName());
                    XSSFRow primeraColumna = hojas.getRow(0);
                    if (primeraColumna == null) {
                        System.err.println("La columna sale vacía.");
                    }
                    int nCeldas = primeraColumna.getLastCellNum();
                    for (int j = 0; j < nCeldas; j++) {
                        XSSFCell celda = primeraColumna.getCell(j);
                        if (celda == null) {
                            System.err.println("La celda sale vacía.");
                        }
                        System.out.println(celda.toString());
                        
                        
                    }
                    
                }


            } catch (Exception e) {
                System.err.println("Ha habido un problema al leer el excel.");
            }
        } catch (Exception e) {
            System.err.println("No se pudo conectar.");            
        }

    }

}

