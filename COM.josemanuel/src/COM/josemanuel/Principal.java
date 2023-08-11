package COM.josemanuel;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;
public class Principal {

	public static void main(String[] args) throws Exception {
//		Se instancia la clase url para ingresar a un URL
		URL url = new URL("https://jsonplaceholder.typicode.com/users");
//		Se llama la fucncion openConection para poder hacer una peticion externa
		HttpURLConnection cx = (HttpURLConnection) url.openConnection();
//		Se llama el metodo GET que extrae los datos de la URL 
		cx.setRequestMethod("GET");
		
//		se crea el objeto strm que se le asignan todos los datos extraidos
		InputStream strm = cx.getInputStream();
//		se convierten todos los datos extraidos a un arreglo de tipo byte
		byte[] arrStream = strm.readAllBytes();
//		Se crea un for each para mostrar en pantalla todos los datos en formato numerico
		for(byte tmp: arrStream) {
//			System.out.println(tmp);
/*			Aqui se hizo un cast a tipo char para que de esta forma pueda imprimir en consola exactamente igual a como se observa 
 * 			visualmente el original JSON
 * **/
			System.out.print((char)tmp);
		}
		
	}

}
