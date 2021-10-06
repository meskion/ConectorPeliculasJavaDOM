package utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import peliculas.Pelicula;
/**
 * Clase de utilidad para crear y manejar documentos xml
 * @author manuf
 *
 */
public class Docs {
/**
 * Abre el archivo xml con la ruta file.
 * @param file
 * @return
 */
	public static Document openXML(String file) {
		Document doc = null;
		try {
			File f = new File(file);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// para que ignore comentarios en xml
			factory.setIgnoringComments(true);
			// para que ignore espacios en blanco redundantes en el xml
			factory.setIgnoringElementContentWhitespace(true);
			// para que no valide el documento xml segun un schema
			factory.setValidating(false);
			// Creamos el builder con la factoria recien creada
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Construimos el documento pasado por parametro
			doc = builder.parse(f);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;

	}
/**
 * Devuelve un string bonito con los datos de peliculas de un xml.
 * @param doc
 * @return
 */
	public static String stringPeliculas(Document doc) {
		
		Pelicula datosNodos = null;
		String salida = "";
		Node node;
		// nodo raiz del documento
		Node raiz = doc.getFirstChild();
		// Hijos del nodo raiz
		NodeList nodosHijos = raiz.getChildNodes();
		// recorremos los nodos hijos
		for (int i = 0; i < nodosHijos.getLength(); i++) {
			node = nodosHijos.item(i);
			// comprobamos que el nodo es un elemento y no texto
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// procesamos el nodo libro en un string
				datosNodos = procesarPelis(node);
				// construimos un string con todos los libros del xml
				salida += datosNodos.verbose();
			}
		}
		return salida;
	}
/**
 * convierte un nodo Peli del xml en una instancia de la clase Pelicula
 * @param node
 * @return
 */
	private static Pelicula procesarPelis(Node node) {
		Pelicula p = new Pelicula();

		if (node.getAttributes().getLength() > 0)
			p.setTipo(node.getAttributes().item(0).getNodeValue());
		NodeList hijos = node.getChildNodes();
		Node ntm = null;
		for (int i = 0; i < hijos.getLength(); i++) {
			ntm = hijos.item(i);
			if (ntm.getNodeType() == Node.ELEMENT_NODE) {
				p.setData(ntm.getNodeName(), ntm.getTextContent());
			}
		}

		return p;

	}

}
