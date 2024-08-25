// MainActivity.java
package com.example.simplegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    private TextView scoreTextView;
    private Button tapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.scoreTextView);
        tapButton = findViewById(R.id.tapButton);

        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                scoreTextView.setText("Score: " + score);
            }
        });
    }
}

/* activity_main.xml */
<!-- Layout file -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <TextView
        android:id="@+id/scoreTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Score: 0"
        android:textSize="24sp" />

    <Button
        android:id="@+id/tapButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Tap Me!" />

</LinearLayout>
