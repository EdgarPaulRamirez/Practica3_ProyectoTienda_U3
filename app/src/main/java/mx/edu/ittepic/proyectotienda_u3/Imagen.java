package mx.edu.ittepic.proyectotienda_u3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Imagen {
    Bitmap icono;
    float x,y;
    boolean visible;

    public Imagen(int resource, float _x, float _y, Lienzo l){
        icono = BitmapFactory.decodeResource(l.getResources(),resource);
        x = _x;
        y = _y;

        visible = true;
    }

    public void pintar(Canvas c, Paint p){
       if (visible) c.drawBitmap(icono,x,y,p);

    }

    public void hacerVisible(boolean v){
        visible = v;
    }

    public boolean estaEnArea (float xp, float yp){
        if(!visible) return false;
        float x2,y2;

        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();

        if (xp >= x && xp <= x2){
            if (yp >= y && yp <= y2){
                return true;
            }
        }
        return false;
    }

    public void mover(float xp){
        x = xp - (icono.getWidth()/2);
    }


}
