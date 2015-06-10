package com.reasono.library;/**
 * Created by reasono on 15/6/9.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.zxing.WriterException;
import com.reasono.library.zxing.activity.CaptureActivity;
import com.reasono.library.zxing.encoding.EncodingHandler;

/**
 * @author Reason
 * @title com.reasono.library
 * @description
 * @modifier
 * @date
 * @since 15/6/9 09:43
 **/
public class QRcodeEncoder {
    public final static int ACTIVITY_SQ_ACTIVITION = 0x999999;

    public static Bitmap encoder(String content, int width, int height) {
        try {
            return EncodingHandler.createQRCode(content, width, height);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void decoder(Activity activity) {
        Intent openCameraIntent = new Intent(activity, CaptureActivity.class);
        activity.startActivityForResult(openCameraIntent, ACTIVITY_SQ_ACTIVITION);
    }

    public static void handleResult(QREventListener eventListener, int requestCode, int
            resultCode, Intent data) {
        if (eventListener != null) {
            eventListener.onDecodeError(new Exception("error"));
        }

        if (resultCode == Activity.RESULT_CANCELED) {
            if (eventListener != null) {
                eventListener.onDecodeCancel();
            }
        } else if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            switch (requestCode) {
                case ACTIVITY_SQ_ACTIVITION:
                    String scanResult = bundle.getString("result");
                    if (eventListener != null) {
                        eventListener.onDecodeComplete(scanResult);
                    }
                    break;
            }
        }
    }
}
