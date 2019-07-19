package com.bytedance.camera.demo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bytedance.camera.demo.utils.Utils;

import java.io.File;

public class TakePictureActivity extends AppCompatActivity {

    private ImageView imageView;
    private File imgFIle;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private static final int REQUEST_EXTERNAL_STORAGE = 101;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);
        imageView = findViewById(R.id.img);
        findViewById(R.id.btn_picture).setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(TakePictureActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(TakePictureActivity.this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                System.out.println(1);
                //todo 在这里申请相机、存储的权限
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            } else {
                System.out.println(2);
                takePicture();
            }
        });

    }

    private void takePicture() {
        //todo 打开相机
        Intent takePictureintent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imgFIle=Utils.getOutputMediaFile(Utils.MEDIA_TYPE_IMAGE);
        if(imgFIle!=null) {
            Uri fileUri = FileProvider.getUriForFile(this, "com.bytedance.camera.demo", imgFIle);
            takePictureintent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(takePictureintent, REQUEST_IMAGE_CAPTURE);
        }
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            setPic();
        }
    }

    private void setPic() {
        //todo 根据imageView裁剪
        //todo 根据缩放比例读取文件，生成Bitmap

        //todo 如果存在预览方向改变，进行图片旋转

        //todo 如果存在预览方向改变，进行图片旋转\
        int targetW=imageView.getWidth();
        int targetH=imageView.getHeight();
        BitmapFactory.Options bmOptions=new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds=true;
        BitmapFactory.decodeFile(imgFIle.getAbsolutePath(),bmOptions);
        int photoW=bmOptions.outWidth;
        int photoH=bmOptions.outHeight;
        int scaleFactor=Math.min(photoW/targetW,photoH/targetH);
        bmOptions.inJustDecodeBounds=false;
        bmOptions.inSampleSize=scaleFactor;
        bmOptions.inPurgeable=true;
        Bitmap bmp=BitmapFactory.decodeFile(imgFIle.getAbsolutePath(),bmOptions);
        imageView.setImageBitmap(Utils.rotateImage(bmp,imgFIle.getAbsolutePath()));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE: {
                //todo 判断权限是否已经授予
                if (grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    takePicture();
                }else {
                    Toast.makeText(this, "You denied the permission of Storage", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case REQUEST_IMAGE_CAPTURE://权限2
                if (grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    takePicture();
                } else {
                    Toast.makeText(this, "You denied the permission of takephoto", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
