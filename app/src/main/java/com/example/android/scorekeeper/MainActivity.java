package com.example.android.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //member variables for holding the score
    private int mScore1;
    private int mScore2;

    //member variables for holding the references to the textview elements
    private TextView mScoreText1;
    private TextView mScoreText2;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the textviews by id
        mScoreText1 = (TextView)findViewById(R.id.score_1);
        mScoreText2 = (TextView)findViewById(R.id.score_2);

        if(savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore1 = savedInstanceState.getInt(STATE_SCORE_2);

            //set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    //handles the onClick of both decrement buttons
    public void decreaseScore(View view) {
        //get id of button that was clicked
        int viewID = view.getId();
        switch (viewID) {
            //if it was team 1
            case R.id.decreaseTeam1:
                //decrement the score and update the textview
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //if it was team 2
            case R.id.decreaseTeam2:
                //decrement the score and update the textview
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    //handles the onClick of both increment buttons
    public void increaseScore(View view) {
        //get id of button that was clicked
        int viewID = view.getId();
        switch (viewID) {
            //if it was team 1
            case R.id.increaseTeam1:
                //increment the score and update the textview
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //if it was team 2
            case R.id.increaseTeam2:
                //increment the score and update the textview
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //check if the correct item was clicked
        if(item.getItemId() == R.id.night_mode) {
            //get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            //recreate the activity for the theme change to take effect
            recreate();
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //save the scores
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}