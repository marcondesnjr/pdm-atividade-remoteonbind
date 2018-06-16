package marcondesnjr.github.io.atividadeservice.services;

import android.os.RemoteException;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import shared.CepServiceAidl;

public class CepServiceAidlImpl extends CepServiceAidl.Stub {

    @Override
    public Map getInformation(String cep) throws RemoteException {
        HttpURLConnection urlConnection = null;
        HashMap<String,String> result = new HashMap<>();
        try {
            URL url = new URL("https://viacep.com.br/ws/"+cep+"/json/");
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line = null;
            StringBuilder sBuilder = new StringBuilder();

            while ((line = br.readLine()) == null){
                sBuilder.append(line);
            }

            JSONObject json = new JSONObject(sBuilder.toString());


            result.put("logradouro", json.getString("logradouro"));
            result.put("complemento", json.getString("complemento"));
            result.put("bairro", json.getString("bairro"));
            result.put("localidade", json.getString("localidade"));
            result.put("uf", json.getString("uf"));


        }catch ( Exception ex ){
            Log.e("services", ex.getMessage(), ex);
        }
        finally {
            urlConnection.disconnect();
        }
        return result;
    }
}
