package com.example.android.youtubeplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    YouTubePlayerView mYouTubeplayer;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitialisedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button)findViewById(R.id.playbutton);
        mYouTubeplayer = (YouTubePlayerView)findViewById(R.id.youtubePlay);

        mOnInitialisedListener = new YouTubePlayer.OnInitializedListener(){
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadPlaylist("PLgCYzUzKIBE8TUoCyjomGFqzTFcJ05OaC");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYouTubeplayer.initialize(youtubeconfig.getApiKey(),mOnInitialisedListener);
            }
        });
    }
}
