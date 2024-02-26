package com.example.hello2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class ReceiveSmsBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Object[] pdus = (Object[]) intent.getExtras().get("pdus");
            if (pdus != null) {
                for (Object pdu : pdus) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
                    String message = smsMessage.getMessageBody();
                    String sender = smsMessage.getDisplayOriginatingAddress();

                    Toast.makeText(context, "SMS Received from " + sender + ": " + message, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
