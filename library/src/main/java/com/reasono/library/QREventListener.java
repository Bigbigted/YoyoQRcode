package com.reasono.library;/**
 * Created by reasono on 15/6/9.
 */

import android.graphics.Bitmap;

/**
 * @author Reason
 * @title com.reasono.library
 * @description
 * @modifier
 * @date
 * @since 15/6/9 10:13
 **/
public interface QREventListener {
    void onDecodeComplete(String mDecodedContent);
    void onDecodeError(Exception e);
    void onDecodeCancel();
}
