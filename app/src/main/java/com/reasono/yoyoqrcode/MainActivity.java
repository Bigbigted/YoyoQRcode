package com.reasono.yoyoqrcode;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.reasono.library.QRcodeEncoder;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView mQrImage = (ImageView) findViewById(R.id.qr_img);

        final EditText content = (EditText) findViewById(R.id.content);
        final EditText width = (EditText) findViewById(R.id.width);
        final EditText height = (EditText) findViewById(R.id.height);
        findViewById(R.id.encode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQrImage.setImageBitmap(QRcodeEncoder.encoder(content.getText().toString(),
                        Integer.parseInt(width.getText().toString()),
                        Integer.parseInt(height.getText().toString())));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
