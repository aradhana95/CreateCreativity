package com.example.createcreativity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.createcreativity.Helper.RecordVidio;
import com.example.createcreativity.Helper.VidioList;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VidioFragment extends Fragment {
    @BindView(R.id.record_vid)
    ImageButton recordVidio;
    @BindView(R.id.upload_vid)
    ImageButton uploadVidio;
    @BindView(R.id.vid_gallery)
    RecyclerView recylerView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Context context;
    FragmentActionListener fragmentActionListener;
    Uri vidioUri;
    String absolutePath;
    Uri mediaStoreUri;
    Cursor cursor;
    int column_index_data, column_index_folder_name, column_id, thumb;
    ArrayList<VidioList> all_vidio;
    VidioAdapter vidioAdapter;


    public VidioFragment() {
        // Required empty public constructor
    }

    public VidioFragment(Context context) {
        this.context = context;

    }


    public static VidioFragment newInstance(String param1, String param2) {
        VidioFragment fragment = new VidioFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_upload_vidio, container, false);
        ButterKnife.bind(this, rootView);
        initUI();

        return rootView;
    }

    public void initUI() {
        recylerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recylerView.hasFixedSize();

        mediaStoreUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        final String sortBy = MediaStore.Video.Media.DATE_TAKEN;
        String[] projection = {MediaStore.MediaColumns.DATA, MediaStore.Video.Media.BUCKET_DISPLAY_NAME, MediaStore.Video.Media._ID, MediaStore.Video.Thumbnails.DATA};
        cursor = context.getApplicationContext().getContentResolver().query(mediaStoreUri, projection, null, null, sortBy + "DESC");

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
        column_index_folder_name = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
        column_id = cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
        thumb = cursor.getColumnIndexOrThrow(MediaStore.Video.Thumbnails.DATA);

        while (cursor.moveToNext()) {
            absolutePath = cursor.getString(column_index_data);
            VidioList vidioList = new VidioList();
            vidioList.setVidioUri(absolutePath);
            all_vidio.add(vidioList);


        }
        vidioAdapter = new VidioAdapter(context.getApplicationContext(), all_vidio);
        recylerView.setAdapter(vidioAdapter);
        //onClick
        recordVidio.setOnClickListener(v -> {
            onClicklistener(this, 11);
        });

    }


    private void onClicklistener(VidioFragment context, int id) {
        switch (id) {
            case 11:
                if (fragmentActionListener != null) {
                    fragmentActionListener.OnClickId(11);

                }
        }
    }

}