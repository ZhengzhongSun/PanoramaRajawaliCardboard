package com.eje_c.rajawalicardboard;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;

import org.rajawali3d.cardboard.RajawaliCardboardRenderer;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.StreamingTexture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;

/**
 * Created by Dobbie on 2015/9/12.
 */
public class VideoRenderer extends RajawaliCardboardRenderer {

    private MediaPlayer mMediaPlayer;
    private StreamingTexture mVideoTexture;

    public VideoRenderer(Context context) {
        super(context);
    }

    @Override
    protected void initScene() {

        //mMediaPlayer = MediaPlayer.create(getContext(), R.raw.video);
        Uri videoUri = Uri.parse("http://kolor.com/360-videos-files/kolor-fighter-aircraft-full-hd.mp4");
        mMediaPlayer = MediaPlayer.create(getContext(),videoUri);

        mMediaPlayer.setLooping(true);

        mVideoTexture = new StreamingTexture("video", mMediaPlayer);
        Sphere sphere = createSphereWithTexture(mVideoTexture);

        getCurrentScene().addChild(sphere);

        getCurrentCamera().setPosition(Vector3.ZERO);
        getCurrentCamera().setFieldOfView(75);

        mMediaPlayer.start();
    }

    private static Sphere createSphereWithTexture(ATexture texture) {

        Material material = new Material();
        material.setColor(0);

        try {
            material.addTexture(texture);
        } catch (ATexture.TextureException e) {
            throw new RuntimeException(e);
        }

        Sphere sphere = new Sphere(50, 64, 32);
        sphere.setScaleX(-1);
        sphere.setMaterial(material);

        return sphere;
    }

    @Override
    protected void onRender(long ellapsedRealtime, double deltaTime) {
        super.onRender(ellapsedRealtime, deltaTime);
        mVideoTexture.update();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMediaPlayer != null)
            mMediaPlayer.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mMediaPlayer != null)
            mMediaPlayer.start();
    }

    @Override
    public void onRenderSurfaceDestroyed(SurfaceTexture surfaceTexture) {
        super.onRenderSurfaceDestroyed(surfaceTexture);
        mMediaPlayer.stop();
        mMediaPlayer.release();
    }
}
