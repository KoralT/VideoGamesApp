package com.example.firebasevideostreaming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private VideoView videoView;
    private ImageView playbutton;
    private TextView currentTimer;
    private TextView durationTimer;
    private ProgressBar currentProgress;
    private ProgressBar bufferprogress;
    private Uri videouri;
    private boolean isPlaying;
    private int current=0;
    private int duration=0;
    private TextView mov_title,description;
    private ImageView crashbandicoot;
    private ImageView assianscreed;
    private ImageView supermario;
    private ImageView reddeadredemption;
    private ImageView gta;
    private ImageView starwars;
    private ImageView finalfantasy;
    private ImageView nba;
    private ImageView mlbtheshow;
    private ImageView fc24;
    private ImageView ufc;
    ConstraintLayout l;


    public void run_movie(Uri videouri, String title, String description)
    {
        Toast.makeText(MainActivity.this,"ENJOY WATCHING "+ title +"!", Toast.LENGTH_SHORT).show();
        bufferprogress.setVisibility(View.VISIBLE);
        new VideoProgress().execute();
        mov_title.setText(title);
        videoView.setVideoURI(videouri);
        videoView.requestFocus();
        videoView.setOnPreparedListener(mp -> {
            videoView.start();
            bufferprogress.setVisibility(View.GONE);
            duration = mp.getDuration() / 1000;
            @SuppressLint("DefaultLocale") String durationstring = String.format("%02d:%02d", duration / 60, duration % 60);
            durationTimer.setText(durationstring);
            showDescriptionModal(title, description);
        });
    }

    private void showDescriptionModal(String title, String description) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.modal_description, null);

        TextView modalTitle = dialogView.findViewById(R.id.modalTitle);
        TextView modalDescription = dialogView.findViewById(R.id.modalDescription);

        modalTitle.setText(title);
        modalDescription.setText(description);

        builder.setView(dialogView);
        builder.setPositiveButton("Close", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isPlaying=false;
        videoView=findViewById(R.id.videoView);
        playbutton=findViewById(R.id.playbtn);
        currentTimer=findViewById(R.id.currentTimer);
        durationTimer=findViewById(R.id.durationTimer);
        currentProgress=findViewById(R.id.videoProgress);
        currentProgress.setMax(100);
        bufferprogress=findViewById(R.id.progressBar3);
        ImageView dragonballz = findViewById(R.id.dragonballz);
        crashbandicoot=findViewById(R.id.crashbandicoot);
        assianscreed=findViewById(R.id.assianscreed);
        supermario=findViewById(R.id.supermario);
        reddeadredemption=findViewById(R.id.reddeadredemption);
        gta=findViewById(R.id.gta);
        starwars=findViewById(R.id.starwars);
        finalfantasy=findViewById(R.id.finalfantasy);
        nba=findViewById(R.id.nba);
        mlbtheshow=findViewById(R.id.mlbtheshow);
        ufc=findViewById(R.id.ufc);
        fc24=findViewById(R.id.fc24);
        mov_title=findViewById(R.id.movie_title);
        l=findViewById(R.id.l);
        l.setBackgroundColor(Color.WHITE);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);

        dragonballz.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Adventure_dragon.mp4?alt=media&token=e4ac860f-a42b-4fa0-bf1c-ef3531479540");
            run_movie(videouri,"Dragon Ball Z", "Console:  PS4, PS5, Xbox One, Xbox Series S/X, PC, and Nintendo Switch\nRelease year: 2020\nLaunching Company:Bandai Namco Entertainment\n");

        });
        crashbandicoot.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Action_Crash_Bandicoot.mp4?alt=media&token=8484e3ef-1cdc-474d-befb-4c7cbd53e0df");
            run_movie(videouri,"Crash Bandicoot", "Console: PlayStation 4, Xbox One, Windows\nRelease year: 2021\nLaunching Company:Vivendi Games\n");
        });
        assianscreed.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Action_Assassins_Creed.mp4?alt=media&token=f05fc748-0879-4e75-8823-7a2fb2db260a");
            run_movie(videouri,"Assians Creed", "Console: PlayStation 4, Windows, Xbox One, Nintendo Switch, Stadia\nRelease year: 2018\nLaunching Company:Ubisoft\n");
        });
        supermario.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Adventure_Super_Mario.mp4?alt=media&token=acb3d04a-143c-45e7-bb65-6898660651ba");
            run_movie(videouri,"Super Mario", "Console: Nintendo Switch\nRelease year: 2023\nLaunching Company: Nintendo\n");
        });
        reddeadredemption.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Action_Red_Dead_Redemption.mp4?alt=media&token=54751e64-7f2a-4cbe-8bdb-52dc1c209e6b");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        gta.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Action_Grand_Theft_Auto.mp4?alt=media&token=20cebae4-5736-4102-9868-f6ce479e3278");
            run_movie(videouri,"GTA", "Console: PlayStation 3, Xbox 360, PlayStation 4, Xbox One, Windows, PlayStation 5, Xbox Series X/S\nRelease year: 2013\nLaunching Company:Rockstar Games\n");
        });
        starwars.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Adventure_Star_Wars.mp4?alt=media&token=2a0a12e0-f87a-4935-a472-0db074baf87b");
            run_movie(videouri,"Star Wars", "Console: PlayStation 4, Windows, Xbox One, Stadia, PlayStation 5, Xbox Series X/S\nRelease year: 2020\nLaunching Company:Electronic Arts\n");
        });
        finalfantasy.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Adventure_Final_Fantasy_XVI.mp4?alt=media&token=abdff521-9c4f-452a-bbb2-66678b57d859");
            run_movie(videouri,"Final Fantasy", "Console: PlayStation 5, Windows\nRelease year: 2023\nLaunching Company:Square Enix\n");
        });
        nba.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Sports_NBA%202K24.mp4?alt=media&token=a22b9461-7492-4baf-862f-f80d05d59ada");
            run_movie(videouri,"NBA 2K24", "Console: Nintendo Switch, PlayStation 4, PlayStation 5, Windows, Xbox One, Xbox Series X/S\nRelease year: 2024\nLaunching Company:2K\n");
        });
        mlbtheshow.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Sports_MLB_The_Show.mp4?alt=media&token=ad76acd5-04b3-4246-b507-ff132ddda4b6");
            run_movie(videouri,"MLB The Show", "Console: PlayStation 4, Xbox One, Windows\nRelease year: 2024\nLaunching Company:San Diego Studio\n");
        });
        fc24.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Sports_FIFA22.mp4?alt=media&token=fe7796f3-fb2f-4390-b13d-baa00beaf407");
            run_movie(videouri,"FC 2024", "Console: Nintendo Switch, PlayStation 4, PlayStation 5, Stadia, Windows, Xbox One, Xbox Series X/S\nRelease year: 2024\nLaunching Company:EA Sports\n");
        });
        ufc.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Sports_UFC_4.mp4?alt=media&token=4b6cdda9-9f6c-40ba-b0bd-c9f0b68c579a");
            run_movie(videouri,"UFC 2022", "Console: PlayStation 4, Xbox One\nRelease year: 2022\nLaunching Company:EA Sports\n");
        });

        isPlaying=true;
        playbutton.setImageResource(R.drawable.img);
        new VideoProgress().execute();
        playbutton.setOnClickListener(v -> {
            if(isPlaying)
            {
                videoView.pause();
                isPlaying=false;
                playbutton.setImageResource(R.drawable.img_1);
            }
            else
            {
                videoView.start();
                isPlaying=true;
                playbutton.setImageResource(R.drawable.img);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        isPlaying=false;
    }

    public class VideoProgress extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            while (isPlaying) {
                try {
                    int currentPosition = videoView.getCurrentPosition() / 1000;

                    // Check if duration is zero to avoid divide by zero error
                    if (duration == 0) {
                        // Handle this case, e.g., by skipping progress updates
                        continue;
                    }

                    int currentPercent = (currentPosition * 100) / duration;
                    publishProgress(currentPercent);
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int currentPercent = values[0];
            currentProgress.setProgress(currentPercent);
            @SuppressLint("DefaultLocale") String currentString = String.format("%02d:%02d", currentPercent / 60, currentPercent % 60);
            currentTimer.setText(currentString);
        }

    }
}