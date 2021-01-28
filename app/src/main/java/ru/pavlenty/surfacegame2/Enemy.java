package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
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

    private int position;
    private Rect detectCollision;


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
        position = gen.nextInt(maxY);

        detectCollision =  new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }

    public void update(int playerSpeed){
        Random gen = new Random();
        if(x < -this.bitmap.getWidth()){
            x = 3000;
            if(y < maxY / 2){
                position = maxY / 2 + gen.nextInt(maxY / 2);
            }
            else{
                position = gen.nextInt(maxY / 2);
            }
        }
        x -= playerSpeed * 8;
        position -= gen.nextInt(50) - 25;
        if(position < 30){position += 30;}
        if(position > (maxY - 30)){position -= 30;}
        if(position < 60){position += 30;}
        if(position > (maxY - 60)){position -= 30;}
        y = position;
        Log.d("Enemy Y=", Integer.toString(y));
        Log.d("Enemy X=", Integer.toString(x));

        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();
    }

    public int getSpeed() {
        return speed;
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

    public Rect getDetectCollision() {
        return detectCollision;
    }
}
