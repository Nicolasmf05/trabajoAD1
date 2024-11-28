package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Clase que permite exportar la información de un entrenador y sus torneos a un archivo XML.
 */
public class Exportar {

    private String nombre;
    private String nacionalidad;
    private long puntos;
    private LocalDate fechaCreacion;
    private ArrayList<Torneo> torneos = new ArrayList<>();
    private long idEntrenador;
    private Entrenador entrenador;

    /**
     * Constructor de la clase Exportar.
     *
     * @param entrenador Entrenador cuyos datos se exportarán a XML
     */
    public Exportar(Entrenador entrenador) {
        this.entrenador = entrenador;
        this.nombre = entrenador.getNombre();
        this.idEntrenador = entrenador.getId();
        this.nacionalidad = entrenador.getNacionalidad();
        this.puntos = entrenador.getPuntos();
        this.fechaCreacion = entrenador.getFechaCreacion();
        this.torneos = entrenador.getTorneos();
    }

    /**
     * Ejecuta el proceso de exportación, creando un archivo XML con la información del entrenador.
     */
    public void ejecutar() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document document = docBuilder.getDOMImplementation().createDocument(null, "carnet", null);
            crearXML(document);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea el documento XML con la estructura de los datos del entrenador y sus torneos.
     *
     * @param doc Documento XML donde se agregarán los elementos
     */
    public void crearXML(Document doc) {
        doc.setXmlVersion("1.0");

        // Formateo de fechas
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        String fechaExpiracion = LocalDate.now().format(dateTimeFormatter);
        String fechaCreacionStr = fechaCreacion.format(dateTimeFormatter);

        // Crear elementos en el documento XML
        crearElemento("id", Long.toString(idEntrenador), doc, doc.getDocumentElement());
        crearElemento("fechaexp", fechaExpiracion, doc, doc.getDocumentElement());

        // Crear nodo de entrenador
        Element elementEntrenador = doc.createElement("entrenador");
        doc.getDocumentElement().appendChild(elementEntrenador);
        crearElemento("nombre", nombre, doc, elementEntrenador);
        crearElemento("nacionalidad", nacionalidad, doc, elementEntrenador);
        crearElemento("fechaCreacion", fechaCreacionStr, doc, elementEntrenador);
        crearElemento("puntos", Long.toString(puntos), doc, elementEntrenador);

        // Crear nodo de torneos
        Element elementoTorneos = doc.createElement("torneos");
        doc.getDocumentElement().appendChild(elementoTorneos);
        for (int i = 0; i < entrenador.getTorneos().size(); i++) {
            Element elementoTorneo = doc.createElement("torneo");
            elementoTorneos.appendChild(elementoTorneo);
            crearElemento("nombre", torneos.get(i).getNombre(), doc, elementoTorneo);
            String regionTorneo = Character.toString(torneos.get(i).getCodRegion());
            crearElemento("region", regionTorneo, doc, elementoTorneo);
        }


        // Guardar el archivo XML
        Source source = new DOMSource(doc);
        Result result = new StreamResult(new File(nombre + ".xml"));

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            try {
                transformer.transform(source, result);
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Crea un elemento XML y lo añade a un nodo raíz.
     *
     * @param datos      Nombre del elemento
     * @param valor     Valor del elemento
     * @param documento  Documento XML
     * @param raiz      Nodo raíz donde se insertará el elemento
     */
    private static void crearElemento(String datos, String valor, Document documento, Element raiz) {
        Element element = documento.createElement(datos);
        Text text = documento.createTextNode(valor);
        raiz.appendChild(element);
        element.appendChild(text);
    }

    /**
     * Guarda el documento XML en un archivo.
     *
     * @param doc   Documento XML a guardar
     * @param path  Ruta y nombre del archivo a crear
     */
    private void guardarXML(Document doc, String path) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(new File(path)));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public long getPuntos() {
        return puntos;
    }

    public void setPuntos(long puntos) {
        this.puntos = puntos;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Torneo> getTorneos() {
        return torneos;
    }

    public void setTorneos(ArrayList<Torneo> torneos) {
        this.torneos = torneos;
    }

    public long getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }
}
