package com.example.createcreativity;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MusicListFragment extends ListFragment {
  FragmentActionListener fragmentActionListener;
  String[] music_menu;
    public MusicListFragment() {
        // Required empty public constructor
    }

    public MusicListFragment(Context context){

    }
    public  void setFragmentActionListener(FragmentActionListener fragmentActionListener){
        this.fragmentActionListener = fragmentActionListener;
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
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_music_list, container, false);
        initUI();
        return  rootView;
    }

    public void initUI()  {
        music_menu = getResources().getStringArray(R.array.music_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),  android.R.layout.simple_list_item_1, music_menu);
        setListAdapter(arrayAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        PlayMusicFragment playMusicFragment = (PlayMusicFragment)getFragmentManager().findFragmentById(R.id.play_music_fragment);
        playMusicFragment.playMusic(music_menu[position]);
        getListView().setSelector(android.R.color.holo_purple);

    }
}