package com.quake.simulasi_webtoon.view.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.User;
import com.quake.simulasi_webtoon.model.session.SessionManager;
import com.quake.simulasi_webtoon.view.Utility;
import com.quake.simulasi_webtoon.view.activity.AuthActivity;
import com.quake.simulasi_webtoon.view.activity.ParentActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Felix on 3/26/2017.
 */

public class FragmentMore extends Fragment{

    private User user;
    private Boolean isEdit = false;
    private Button logout;
    //AMBIL FOTO
    ImageView imageViewProfil;
    final private int REQUEST_CAMERA = 1;
    final private int SELECT_FILE = 2;
    final private int CROP_IMG = 3;
    String userChoosenTask;
    Uri uri;
    Intent CropIntent ;
    //AMBIL FOTO

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View _view = inflater.inflate(R.layout.fragment_more, container, false);
        user = SessionManager.with(this.getContext()).getuserloggedin();

        imageViewProfil = (ImageView) _view.findViewById(R.id.imageViewProfile);
        if(null!=SessionManager.getPic()){
            imageViewProfil.setImageBitmap(SessionManager.getPic());
        }
        event();

        final ProgressDialog progress = new ProgressDialog(this.getContext());
        progress.setMessage("loading ...");
        progress.show();

        Thread _thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    progress.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        _thread.start();

        //TextView id = (TextView) _view.findViewById(R.id.user_id);
        //id.setText(String.valueOf(user.getId()));
        final EditText nama = (EditText) _view.findViewById(R.id.user_nama);
        nama.setText(user.getName());
        final EditText email = (EditText) _view.findViewById(R.id.user_email);
        email.setText(user.getEmail());
        final EditText password = (EditText) _view.findViewById(R.id.user_password);
        password.setText(user.getPassword());

//        final EditText bio = (EditText) _view.findViewById(R.id.user_bio);

        final Button edit = (Button) _view.findViewById(R.id.edit_button);
        logout = (Button) _view.findViewById(R.id.user_logout);

        nama.setEnabled(isEdit);
        email.setEnabled(isEdit);
        password.setEnabled(isEdit);
//        bio.setEnabled(isEdit);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionManager.with(getContext().getApplicationContext()).clearsession();
                SessionManager.clearPic();
                ParentActivity.doChangeActivity(getContext().getApplicationContext(), AuthActivity.class);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////////////////////////////////////////////////////////////////////////////////////
                isEdit = !isEdit;
                nama.setEnabled(isEdit);
                email.setEnabled(isEdit);
                password.setEnabled(isEdit);
//                bio.setEnabled(isEdit);

                if (isEdit) {
                    edit.setText("Save");
                } else {
                    edit.setText("Edit");
                    
                    // save perubahan ke session
                    user.setName(nama.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPassword(password.getText().toString());
                    SessionManager.with(_view.getContext()).createsession(user);

                    // save perubahan ke array User.users
                    for (User item : User.users) {
                        if (item.getId() == user.getId()) {
                            item.setName(nama.getText().toString());
                            item.setEmail(email.getText().toString());
                            item.setPassword(password.getText().toString());
                        }
                    }

                    // TOAST
//                    CharSequence msg;
//                    if (user.getName() == nama.getText().toString() && user.getEmail() == email.getText().toString()) {
//                        msg = "Successfully updated!";
//                    } else {
//                        msg = "Nothing changes!";
//                    }

                    Toast.makeText(_view.getContext(), "Successfully updated!", Toast.LENGTH_LONG).show();
                }

//                if (isEdit) {
//                    nama.setFocusableInTouchMode(true);
//                    nama.setClickable(true);
//                    email.setFocusableInTouchMode(true);
//                    email.setClickable(true);
//                } else {
//                    nama.setFocusable(false);
//                    nama.setClickable(false);
//                    email.setFocusable(false);
//                    email.setClickable(false);
//                }


            }
        });

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);

        return _view;

    }

    private void event() {
        imageViewProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage(v);
            }
        });
    }
    private void selectImage(View v) {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result= Utility.checkPermission(getActivity().getApplicationContext());
                if (items[item].equals("Take Photo")) {
                    userChoosenTask="Take Photo";
                    if(result)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask="Choose from Library";
                    if(result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent()
    {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
//code for deny
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CROP_IMG) {
                onSelectFromGalleryResult(data);
            }

            else if (requestCode == SELECT_FILE) {
                uri = data.getData();

                ImageCropFunction();
            }

            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Bundle extras = data.getExtras();
        //get the cropped bitmap from extras
        Bitmap bm = extras.getParcelable("data");
        imageViewProfil.setImageBitmap(getCroppedBitmap(bm));
        SessionManager.setPic(getCroppedBitmap(bm));
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageViewProfil.setImageBitmap(thumbnail);
        SessionManager.setPic(thumbnail);
    }
    public void ImageCropFunction() {

        // Image Crop Code
        try {
            CropIntent = new Intent("com.android.camera.action.CROP");

            CropIntent.setDataAndType(uri, "image/*");

            CropIntent.putExtra("crop", "true");
            CropIntent.putExtra("outputX", 180);
            CropIntent.putExtra("outputY", 180);
            CropIntent.putExtra("aspectX", 3);
            CropIntent.putExtra("aspectY", 4);
            CropIntent.putExtra("scaleUpIfNeeded", false);
            CropIntent.putExtra("circleCrop",true);
            CropIntent.putExtra("return-data", true);

            startActivityForResult(CropIntent, CROP_IMG);

        } catch (ActivityNotFoundException e) {

        }
    }

    public Bitmap getCroppedBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        //Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
        //return _bmp;
        return output;
    }
}

