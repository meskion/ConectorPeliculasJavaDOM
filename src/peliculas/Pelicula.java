package peliculas;
/**
 * Pequeña clase para almacenar los strings a mostrar de una pelicula segun el xml
 * @author manuf
 *
 */
public class Pelicula {

	private String tipo, titulo, autor, productora, duracion;
	private String[] verb = { "\n Tipo: ", "\n Titulo: ", "\n Autor: ", "\n Productora: ", "\n Duración: " };

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = verb[0] + tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = verb[1] + titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = verb[2] + autor;
	}

	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = verb[3] + productora;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = verb[4] + duracion;
	}
/**
 * Segun el nombre de un nodo elemento del xml, setea el atributo equivalente en la clase.
 * @param nodeName
 * @param textContent
 */
	public void setData(String nodeName, String textContent) {

		switch (nodeName) {
		case "Titulo":
			setTitulo(textContent);
			break;
		case "Autor":
			setAutor(textContent);
			break;
		case "Productora":
			setProductora(textContent);
			break;
		case "Duracion":
			setDuracion(textContent);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + nodeName);
		}

	}

	public String verbose() {
		String res = "";
		String[] datos = { tipo, titulo, autor, productora, duracion };
		for (String s : datos) {
			if (s != null)
				res += s;
		}
		res += "\n ____________________";

		return res;
	}

}
