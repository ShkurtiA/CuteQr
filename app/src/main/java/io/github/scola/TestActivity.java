package io.github.scola;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.akelius.cuteqr.CuteR;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.github.scola.qart.R;

public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_test);

        convert();
        findViewById(R.id.convertBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                convert();

            }
        });


        findViewById(R.id.clearBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageView) findViewById(R.id.imageView)).setImageDrawable(null);
            }
        });
    }

    private void convert() {
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.modigliani);

        startConvert(icon,
                "Let's " +
                        "you wanted to dream ",
                ((ImageView) findViewById(R.id.imageView)));
    }

    private void startConvert(final Bitmap mCropImage, final String qrText, final ImageView target) {
        final int color = Color.BLACK;
        final boolean colorful = false;


        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... voids) {

                return CuteR.ProductLogo(mCropImage, qrText, colorful, color);
//                return CuteR.ProductNormal(qrText, colorful, color);
            }

            @Override
            protected void onPostExecute(Bitmap post) {
                super.onPostExecute(post);
                target.setImageBitmap(post);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
        }.execute();
    }

}
