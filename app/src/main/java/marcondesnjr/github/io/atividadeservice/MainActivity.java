package marcondesnjr.github.io.atividadeservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import marcondesnjr.github.io.atividadeservice.services.CepService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BroadcastReceiver  bReceiver = new BroadcastReceiver(){

            @Override
            public void onReceive(Context context, Intent intent) {
                EditText editTextLog = findViewById(R.id.editTextLog);
                EditText editTextComp = findViewById(R.id.editTextComp);
                EditText editTextBairro = findViewById(R.id.editTextBairro);
                EditText editTextCidade = findViewById(R.id.editTextCidade);
                EditText editTextUF = findViewById(R.id.editTextUF);

                editTextLog.setText(intent.getStringExtra("logradouro"));
                editTextComp.setText(intent.getStringExtra("complemento"));
                editTextBairro.setText(intent.getStringExtra("bairro"));
                editTextCidade.setText(intent.getStringExtra("localidade"));
                editTextUF.setText(intent.getStringExtra("uf"));

            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(bReceiver, new IntentFilter("cepfound"));

        findViewById(R.id.buttonEnviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editTextCEP);
                String cep = editText.getText().toString();
                Intent service = new Intent(v.getContext(),CepService.class);
                service.putExtra("cep",cep);
                startService(service);
            }
        });

    }



}
