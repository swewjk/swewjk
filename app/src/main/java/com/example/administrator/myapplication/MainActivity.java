package com.example.administrator.myapplication;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView im;
    Button bu;
    private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im=(ImageView)findViewById(R.id.im1);
        bu=(Button) findViewById(R.id.bu1);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File fp1 = new File(Environment.getExternalStorageDirectory(), "imge.jpg");
                try {
                    if (fp1.exists()) {
                        fp1.delete();
                    }
                    fp1.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                uri=Uri.fromFile(fp1);
                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK)
        }
    }
}
