package marcondesnjr.github.io.atividadeservice.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class CepServiceAidlS extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new CepServiceAidlImpl();
    }
}
