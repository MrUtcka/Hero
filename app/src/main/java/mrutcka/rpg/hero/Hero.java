package mrutcka.rpg.hero;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

public class Hero extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_content);

        if(getIntent().hasExtra("byteArray")) {
            ImageView imageView = new ImageView(this);
            Bitmap bit = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            imageView.setImageBitmap(bit);
        }


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    Button button;
    Intent i;

    @Override
    public void onClick(View v) {
        i = new Intent(Hero.this, MainActivity.class);
        startActivity(i);
    }
}