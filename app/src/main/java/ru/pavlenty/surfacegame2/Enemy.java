package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.util.Random;

public class Enemy {

    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 0;

    private int maxX;
    private int maxY;

    private int minX;
    private int minY;

    private int sr;

    public Enemy(Context context, int screenX, int screenY) {
        Log.d("RRR screenX",Integer.toString(screenX));

        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        this.maxX = screenX;
        this.maxY = screenY;
        this.minX = 0;
        this.minY = 0;
        Random r = new Random();
        speed = r.nextInt(6);
        x = screenX;
        y = r.nextInt(this.maxY);
        Log.d("Y=", Integer.toString(y));
        Random gen = new Random();;
        sr = gen.nextInt(maxY);
    }

    public void update(int playerSpeed){
        Random gen = new Random();
        if(x < -this.bitmap.getWidth()){
            x = 5000;
            if(y < maxY / 2){
                sr = maxY / 2 + gen.nextInt(maxY / 2);
            }
            else{
                sr = gen.nextInt(maxY / 2);
            }
        }
        x -= playerSpeed * 4;
        sr -= gen.nextInt(50) - 25;
        if(sr < 30){sr += 30;}
        if(sr > (maxY - 30)){sr -= 30;}
        if(sr < 60){sr += 30;}
        if(sr > (maxY - 60)){sr -= 30;}
        y = sr;
        Log.d("Y=", Integer.toString(y));
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
