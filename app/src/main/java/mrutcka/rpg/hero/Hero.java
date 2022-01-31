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

        ImageView a = (ImageView) findViewById(R.id.imageView1);
        TextView b = (TextView) findViewById(R.id.textView2);

        if(getIntent().hasExtra("byteArray")) {
            Bitmap bit = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            a.setImageBitmap(bit);
        }

        if(getIntent().hasExtra("story")) {
            String story = getIntent().getStringExtra("story");
            b.setText(story);
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