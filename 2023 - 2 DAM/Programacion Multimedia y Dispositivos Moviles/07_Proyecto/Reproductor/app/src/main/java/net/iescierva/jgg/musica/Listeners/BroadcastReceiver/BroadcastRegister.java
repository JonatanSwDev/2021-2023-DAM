package net.iescierva.jgg.musica.Listeners.BroadcastReceiver;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;

public class BroadcastRegister {

    public BroadcastRegister (Context context){
        OnBroadcastReceiver onBroadcastReceiver = new OnBroadcastReceiver();
        IntentFilter filter = new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(MediaStore.ACTION_VIDEO_CAPTURE);
        filter.addAction(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        context.registerReceiver(onBroadcastReceiver, filter);
    }

}
