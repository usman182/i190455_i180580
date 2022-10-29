package com.ass2.i190455_i180580;

import static com.ass2.i190455_i180580.R.drawable.ic_baseline_play_arrow_24;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class activity5 extends AppCompatActivity {

    ImageView hamburger, img2;
    TextView song, playlistname;
    ImageView plalist1;
    ImageView plusimage;
    ImageButton imgbtn1, addbutton, play, previoussong, nextsong;
    String title;
    String downloadLink;
    String playlistName;
    List<Upload> songsList;
    Upload currentSong;
    MediaPlayer mediaPlayer = MyMediaPlayer.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);


        hamburger = findViewById(R.id.hamburger1);
        img2 = findViewById(R.id.personicon);
        plalist1 = findViewById(R.id.playlist1);
        song = findViewById(R.id.song);
        addbutton = findViewById(R.id.addbutton);
        playlistname = findViewById(R.id.playlistname);
        plusimage = findViewById(R.id.plusimage);
        play = findViewById(R.id.play);
        previoussong = findViewById(R.id.previoussong);
        nextsong = findViewById(R.id.nextsong);

        song.setSelected(true);

        imgbtn1 = findViewById(R.id.play);

        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userFullName = getIntent().getStringExtra("userFullName");

                Intent intent = new Intent(activity5.this, activity8.class);
                intent.putExtra("userFullName", userFullName);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity5.this, activity6.class));
            }
        });



        // to open the add playlist activity
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity5.this, activity10.class));
            }
        });



        plalist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                songsList = (List<Upload>) getIntent().getSerializableExtra("list");

                Intent intent = new Intent(activity5.this, activity16.class);
                intent.putExtra("list3", (Serializable) songsList);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }




        }