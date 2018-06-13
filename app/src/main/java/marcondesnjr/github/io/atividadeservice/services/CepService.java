package marcondesnjr.github.io.atividadeservice.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

public class CepService extends Service{


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String cep = intent.getStringExtra("cep");
        String url = "https://viacep.com.br/ws/"+cep+"/json/";

        Ion.with(getApplicationContext()).load(url).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                try {
                    JSONObject json = new JSONObject(result);
                    Intent intent = new Intent("cepfound");
                    intent.putExtra("logradouro", json.getString("logradouro"));
                    intent.putExtra("complemento", json.getString("complemento"));
                    intent.putExtra("bairro", json.getString("bairro"));
                    intent.putExtra("localidade", json.getString("localidade"));
                    intent.putExtra("uf", json.getString("uf"));
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                    stopSelf();
                }catch (JSONException ex){
                    Log.e("My App", "Could not parse malformed JSON: \"" + ex + "\"");
                }
            }

        });
        return START_STICKY;
    }
}
