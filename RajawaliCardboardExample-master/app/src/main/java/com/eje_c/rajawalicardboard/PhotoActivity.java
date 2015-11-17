package com.eje_c.rajawalicardboard;

import android.os.Bundle;

import com.google.vrtoolkit.cardboard.CardboardActivity;

import org.rajawali3d.cardboard.RajawaliCardboardRenderer;
import org.rajawali3d.cardboard.RajawaliCardboardView;

/**
 * Created by p300 on 2015/9/12.
 */
public class PhotoActivity extends CardboardActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RajawaliCardboardView view = new RajawaliCardboardView(this);
        setContentView(view);
        setCardboardView(view);

        RajawaliCardboardRenderer renderer = new PhotoRenderer(this);
        view.setRenderer(renderer);
        view.setSurfaceRenderer(renderer);
    }
}
