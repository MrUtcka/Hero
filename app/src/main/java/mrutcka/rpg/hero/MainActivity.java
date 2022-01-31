package mrutcka.rpg.hero;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager mViewPager;

    int[] images = {R.drawable.tabakov, R.drawable.sadakov, R.drawable.kobachev};

    ViewPaperAdapter mViewPaperAdapter;

    Intent i;
    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

        mViewPaperAdapter = new ViewPaperAdapter(MainActivity.this, images);
        mViewPager.setAdapter(mViewPaperAdapter);

        story = new Story();
        story.setStories();
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(this, Hero.class);

        Bitmap bit = BitmapFactory.decodeResource(getResources(), images[mViewPaperAdapter.pos - 1] /* В тут надо передавать картинку из ViewPaperAdapter */);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.PNG, 50, bs);
        i.putExtra("byteArray", bs.toByteArray());
        i.putExtra("story", story.getStories(mViewPaperAdapter.pos - 1));

        startActivity(i);
    }

}