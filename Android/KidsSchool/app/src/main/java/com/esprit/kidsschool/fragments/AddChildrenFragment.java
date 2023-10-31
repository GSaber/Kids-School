package com.esprit.kidsschool.fragments;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.files.BackendlessFile;
import com.backendless.persistence.BackendlessDataQuery;
import com.esprit.kidsschool.R;
import com.esprit.kidsschool.adapters.childrenAdapter;
import com.esprit.kidsschool.entities.Children;
import com.esprit.kidsschool.utils.Utility;
import com.facebook.Profile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class AddChildrenFragment extends Fragment {


    Button btnPic,btnSave;
    EditText etName;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private String userChoosenTask;
    final Profile profile = Profile.getCurrentProfile();
    private ImageButton btnBack;
    String urlImage="";
    String picturePath="";
    private ArrayList<Children> childrens;
    private int verify=0;

    public AddChildrenFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_children, container, false);

        etName = (EditText) view.findViewById(R.id.et_name);
        btnPic = (Button) view.findViewById(R.id.btn_pic);
        btnSave = (Button) view.findViewById(R.id.btn_save);
        btnBack = (ImageButton) view.findViewById(R.id.btn_back_addchild);

        if(profile!=null){

            String whereClause = "idParent = "+profile.getId();
            BackendlessDataQuery dataQuery = new BackendlessDataQuery();
            dataQuery.setWhereClause( whereClause );

            Backendless.Persistence.of( Children.class).find(dataQuery,new AsyncCallback<BackendlessCollection<Children>>(){
                @Override
                public void handleResponse( BackendlessCollection<Children> foundContacts )
                {
                    childrens= (ArrayList<Children>) foundContacts.getData();
                }
                @Override
                public void handleFault( BackendlessFault fault )
                {

                }
            });

        } else{
            Toast.makeText(getActivity(),"You must logged in",Toast.LENGTH_LONG).show();
        }

        btnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new SettingFragment()).commit();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(profile!=null){
                    verify=0;
                    for(Children c:childrens)
                    {
                        if(c.getNom().toString().equals(etName.getText().toString()))
                        {
                            verify=1;
                        }
                    }

                if(urlImage.equals("") && etName.getText().toString().equals("")){

                    Toast.makeText(getActivity(),"Name or picture is empty",Toast.LENGTH_LONG).show();
                }
                else if(urlImage.equals("")) {
                    Toast.makeText(getActivity(),"Picture is empty",Toast.LENGTH_LONG).show();
                }
                else if(etName.getText().toString().equals("")) {
                    Toast.makeText(getActivity(),"Name is empty",Toast.LENGTH_LONG).show();
                }
                else if(verify==1) {
                    Toast.makeText(getActivity(),"Name already exist",Toast.LENGTH_LONG).show();
                }
                else{
                    Children ch=new Children();
                    ch.setIdParent(profile.getId());
                    ch.setNom(etName.getText().toString());
                    ch.setPhoto(urlImage);
                    System.out.println("ch"+ch.getPhoto());
                    ch.setAvancement("0");
                    ch.setNote("0");
                    Backendless.Persistence.save( ch, new AsyncCallback<Children>() {
                        public void handleResponse( Children response )
                        {
                            System.out.println("children saved.");
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, new SettingFragment()).commit();
                        }

                        public void handleFault( BackendlessFault fault )
                        {
                            System.out.println(fault.getMessage().toString());
                            Toast.makeText(getActivity(),"Error",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                }else{
                    Toast.makeText(getActivity(),"You must logged in",Toast.LENGTH_LONG).show();
                }
            }

        });

        return view;
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

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result= Utility.checkPermission(getActivity());
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

    private void galleryIntent()
    {
        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,SELECT_FILE);
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
        System.out.println(destination);

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();

            //save last captured picture to backendless
            picturePath = destination.getPath();

            System.out.println("ok "+picturePath);



            Backendless.Files.Android.upload( BitmapFactory.decodeFile(picturePath), Bitmap.CompressFormat.PNG, 100,
                    BitmapFactory.decodeFile(picturePath).toString(), "images", new AsyncCallback<BackendlessFile>()
                    {
                        @Override
                        public void handleResponse( final BackendlessFile backendlessFile )
                        {
                            System.out.println( "File has been uploaded. File URL is - " + backendlessFile.getFileURL() );
                            urlImage=backendlessFile.getFileURL();
                        }
                        @Override
                        public void handleFault( BackendlessFault backendlessFault )
                        {
                            System.out.println(backendlessFault.toString());
                            Toast.makeText( getActivity(), "File not supported", Toast.LENGTH_SHORT ).show();
                        }
                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OutOfMemoryError E) {
            Toast.makeText( getActivity(), "File not supported", Toast.LENGTH_SHORT ).show();
        }

    }


    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA };

        Cursor cursor = getActivity().getContentResolver().query(selectedImage,filePathColumn, null, null, null);
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

        picturePath = cursor.getString(columnIndex);
        System.out.println("ok "+picturePath);
        cursor.close();
        try {
        Backendless.Files.Android.upload( BitmapFactory.decodeFile(picturePath), Bitmap.CompressFormat.PNG, 100,
                BitmapFactory.decodeFile(picturePath).toString(), "images", new AsyncCallback<BackendlessFile>()
                {
                    @Override
                    public void handleResponse( final BackendlessFile backendlessFile )
                    {
                        System.out.println( "File has been uploaded. File URL is - " + backendlessFile.getFileURL() );
                        urlImage=backendlessFile.getFileURL();
                    }
                    @Override
                    public void handleFault( BackendlessFault backendlessFault )
                    {
                        System.out.println(backendlessFault.toString());
                        Toast.makeText( getActivity(), "Connection failed", Toast.LENGTH_SHORT ).show();
                    }
                });
        } catch (OutOfMemoryError E) {
            Toast.makeText( getActivity(), "File not supported", Toast.LENGTH_SHORT ).show();
        }
    }

}
