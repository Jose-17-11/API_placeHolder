package COM.josemanuel;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class Principal {
	
    public static void main(String[] args) throws Exception {
    	String username = "Bret";
        // Se instancia la clase URL para ingresar a un URL
        URL url = new URL("https://jsonplaceholder.typicode.com/users");
        // Se llama la función openConnection para poder hacer una petición externa
        HttpURLConnection cx = (HttpURLConnection) url.openConnection();
        // Se llama el método GET que extrae los datos de la URL
        cx.setRequestMethod("GET");

        // Se crea el objeto strm que se le asignan todos los datos extraídos
        InputStream strm = cx.getInputStream();
        // Se convierten todos los datos extraídos a un arreglo de tipo byte
        byte[] arrStream = strm.readAllBytes();

        // Se crea una variable que almacenará los datos más específicamente
        String cntJson = "";

        // Se crea un for each para mostrar en pantalla todos los datos en formato numérico
        for (byte tmp : arrStream) {
            cntJson += (char) tmp;
        }

        // Parsear el JSON y extraer los emails
        JSONArray jsonArray = new JSONArray(cntJson);
        //Cree la variable j y user inicializadas en cero y vacias
        int j = 0;
        String user = "";
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String obj = jsonObject.getString("username");
            //La condicion if compara la cadena extraida del JSON y la compara con el usuario que hemos ingresado, si es el mismo hace lo siguiente
            if(username.equals(obj)) {
            	//Aunmenta un 1 en la variable j y la cadena user toma el valor del dato extraido del JSON
            	j++;
            	user = obj;
            }
            
        }
//        Esta condicion fuera del ciclo es la que nos deja acceder ya que si el contador aumento el usuario ingresado es correcto por lo tanto 
//        puede iniciar sesion
        if(j!=0) {
        	System.out.println("Haz iniciado sesion");
        	System.out.println("Usuario: " + user);
        }else {
        	System.out.println("Usuario no encontrado");
        }
    }
}
