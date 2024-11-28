package org.example;

import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class Nacionalidad {

    public static ArrayList<String> listaPaises = new ArrayList<>();

    public static void show () {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser;

        try {
            parser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = parser.getXMLReader();

            GestorDeContenidos gestorDeContenidos = new GestorDeContenidos();
            xmlReader.setContentHandler(gestorDeContenidos);
            InputSource inputSource = new InputSource("proyectopokemonadt\\src\\main\\java\\com\\proyectopokemonadt\\archviosComplementarios\\paises.xml");
            try {
                xmlReader.parse(inputSource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Error en la preparacion para la lectura");
        }
    }

    public static boolean validarNacionalidad (String userNacionalidad) {
        for (int i = 0; i < listaPaises.size(); i++) {
            if (listaPaises.get(i).equals(userNacionalidad)) {
                return true;
            }
        }
        return false;
    }
}
