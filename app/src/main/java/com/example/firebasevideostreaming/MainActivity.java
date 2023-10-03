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
    private ImageView tenet;
    private ImageView interstellar;
    private ImageView NinjaTurtles;
    private ImageView dangal;
    private ImageView sultan;
    private ImageView chennai;
    private ImageView three;
    private ImageView kgf;
    private ImageView vr;
    private ImageView kantara;
    private ImageView kirik;
    ConstraintLayout l;


    public void run_movie(Uri videouri, String title, String description)
    {
        Toast.makeText(MainActivity.this,"ENJOY WATCHING "+ title+"!", Toast.LENGTH_SHORT).show();
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
        ImageView inception = findViewById(R.id.inception);
        tenet=findViewById(R.id.tenet);
        interstellar=findViewById(R.id.intersteller);
        NinjaTurtles=findViewById(R.id.NinjaTurtles);
        dangal=findViewById(R.id.dangal);
        sultan=findViewById(R.id.sultan);
        chennai=findViewById(R.id.chennai);
        three=findViewById(R.id.three_ediots);
        kgf=findViewById(R.id.kgf);
        vr=findViewById(R.id.vr);
        kirik=findViewById(R.id.kirik_party);
        kantara=findViewById(R.id.kantara);
        mov_title=findViewById(R.id.movi_title);
        l=findViewById(R.id.l);
        l.setBackgroundColor(Color.WHITE);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
        videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/file_example_MP4_480_1_5MG.mp4?alt=media&token=e881ce97-a15b-45f5-969d-f622bed41afd");
        run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");

        inception.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate%5B1%5D.mp4?alt=media&token=10943525-92dc-4545-8836-84b81cb8983e");
            String mtitle="INCEPTION";
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");

        });
        tenet.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is%20-%20TENET%20-%20NEW%20TRAILER-L3pk_TBkihU-480p-1657868329709.mp4?alt=media&token=ef8a29ed-7cc7-4122-aed8-421c14d17d24");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        interstellar.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is%20-%20Interstellar%20-%20Trailer%20-%20Official%20Warner%20Bros.%20UK-zSWdZVtXT7E-480p-1655590373689.mp4?alt=media&token=c03ed3eb-8392-45a5-8ec9-10bff13aec32");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        NinjaTurtles.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/androidcourseproject-7ac69.appspot.com/o/Teenage-Mutant-Ninja-Turtles-2.mp4?alt=media&token=bd148923-6b8d-426c-8c8f-4d1d115365eb");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        dangal.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is%20-%20Dangal%20%20Official%20Trailer%20%20Aamir%20Khan%20%20In%20Cinemas%20Dec%2023%2C%202016-x_7YlGv9u1g-480p-1654047960072.mp4?alt=media&token=1a9d1330-3923-4d00-b0f6-0acd463c4704");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        sultan.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is%20-%20Sultan%20%20Official%20Trailer%20%20Salman%20Khan%2C%20Anushka%20Sharma%20%20Ali%20Abbas%20Zafar%20%20New%20Movie%20Trailer-wPxqcq6Byq0-480p-1655590739518.mp4?alt=media&token=486585f8-099e-40ef-ac48-dc59b6f3bcfb");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        chennai.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is%20-%20Chennai%20Express%20Trailer%20(Official)%20%20ShahRukh%20Khan%2C%20Deepika%20Padukone-rARol7Dk2zo-480p-1655591051947.mp4?alt=media&token=b9eb1a9d-4c68-43b5-9723-735269bb2376");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        three.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is_-_What_is_a_machine__3_Idiots__Netflix-DKzBmRRdPXo-480p-1655595299167%5B1%5D.mp4?alt=media&token=1b984717-08d3-49fd-b97c-8c6340b3e32a");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        kgf.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is%20-%20KGF%20Chapter%202%20TrailerHindiYashSanjay%20DuttRaveena%20TandonSrinidhiPrashanth%20NeelVijay%20Kiragandur-JKa05nyUmuQ-480p-1655591001995.mp4?alt=media&token=c992052b-2dc3-4804-ae4c-b8ef5f9c7d6c");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        vr.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is%20-%20Vikrant%20Rona%20Official%20Trailer%20%20English%20%20Kichcha%20Sudeep%20%20Anup%20Bhandari%20%20Ajaneesh%20%20Shalini%20Artss-Ylte9v30UcY-480p-1657868906229.mp4?alt=media&token=db8d0ef1-6c7c-4be6-b7eb-a40ed88007c0");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        kantara.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is%20-%20Kantara%20(Hindi)%20%20Official%20Trailer%20%20Rishab%20Shetty%2C%20Sapthami%20Gowda%2C%20Kishore%20%20Netflix%20India-6oKFao0aISA-480p-1654048534497.mp4?alt=media&token=a7a44348-6a63-44b6-8c22-774ef97ffb19");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
        });
        kirik.setOnClickListener(v -> {
            videouri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-video-streaming-a6a47.appspot.com/o/Y2Mate.is%20-%20Kirik%20Party%20%20Official%20Trailer%20with%20English%20Subtitles%20-%20Rakshit%20Shetty%20%20Rashmika%20%20Samyuktha-IfvnbER_6sQ-480p-1655591222141.mp4?alt=media&token=36ea03a1-70e6-4857-8670-70555783e720");
            run_movie(videouri,"Red Dead Redemption", "Category: 'Action'\nConsole: PlayStation 4, Xbox One, Windows\nRelease year: 2018\nLaunching Company:Rockstar Games\n");
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