package net.iescierva.jgg.musica.Listeners.BroadcastReceiver;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import net.iescierva.jgg.musica.Iintents.IntentManager;

class OnBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        IntentManager intentManager = new IntentManager(context);
        String action = intent.getAction();

       //Pongo algunos ejemplos, el que nos importa realmente es el de la llamada y la camara, el microfono no lo he encontrado por ninguna parte
        switch (action) {
            case TelephonyManager.ACTION_PHONE_STATE_CHANGED:
                String estadoLlamada = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
                telefonoReceiver(estadoLlamada, intentManager);
                break;
            //Se graba un video
            case MediaStore.ACTION_VIDEO_CAPTURE:
                intentManager.pause();
                break;
            //Se reproduce contenido multimedia desde una aplicacion externa (Youtube, Google...)
            case MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH:
                intentManager.pause();

            ///////DE PRUEBA - IRRELEVANTE///////
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                // Obtener el estado actual del modo avión
                boolean airplaneMode = intent.getBooleanExtra("state", false);
                avionReceiver(context, airplaneMode);
                break;
            case WifiManager.NETWORK_STATE_CHANGED_ACTION:
                NetworkInfo networkInfo = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
                networkReceiver(context, networkInfo);

            case BluetoothAdapter.ACTION_STATE_CHANGED:
                int estadoBluetooth = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
                bluetoothReceiver(context, estadoBluetooth);
                break;
            //Asi podemos seguir hasta que nos cansemos... El que nos importa es el de la llamada
        }
    }

    private void telefonoReceiver(String estadoLlamada, IntentManager intentManager) {
        if (estadoLlamada.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            intentManager.pause();
        } else if (estadoLlamada.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            //Coloco tambien el pausa aqui, dado que puede que sea una llamada saliente
            intentManager.pause();
        } else if (estadoLlamada.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            intentManager.reanude();
        }
    }

    private void avionReceiver(Context context, boolean airplaneMode) {
        if (airplaneMode) {
            // Si el modo avión está activado, mostrar un mensaje
            Toast.makeText(context, "Modo avión activado", Toast.LENGTH_SHORT).show();
        } else {
            // Si el modo avión está desactivado, mostrar un mensaje
            Toast.makeText(context, "Modo avión desactivado", Toast.LENGTH_SHORT).show();
        }
    }

    private void networkReceiver(Context context, NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            // El WiFi se ha conectado
            Toast.makeText(context, "WiFi conectado", Toast.LENGTH_SHORT).show();
        } else {
            // El WiFi se ha desconectado
            Toast.makeText(context, "WiFi desconectado", Toast.LENGTH_SHORT).show();
        }
    }

    private void bluetoothReceiver(Context context, int estadoBluetooth) {
        switch (estadoBluetooth) {
            case BluetoothAdapter.STATE_OFF:
                // Bluetooth desactivado
                Toast.makeText(context, "Bluetooth desactivado", Toast.LENGTH_SHORT).show();
                break;
            case BluetoothAdapter.STATE_ON:
                // Bluetooth activado
                Toast.makeText(context, "Bluetooth activado", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}