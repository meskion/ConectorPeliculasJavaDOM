package peliculas;

import org.w3c.dom.Document;

import utils.Docs;

public class TestPeliculas {

	public static void main(String[] args) {
		Document pelis = Docs.openXML("data/pelis.xml");
		System.out.println(Docs.stringPeliculas(pelis));
		Pelicula p = new Pelicula();

	}

}
