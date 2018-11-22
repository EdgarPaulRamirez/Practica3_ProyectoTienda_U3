package mx.edu.ittepic.proyectotienda_u3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoTaquetes extends View {
    ImagenTaquetes taquete1,taquete2,taquete3,taquete4,icono,fondo3, scroll2, puntero,
            fototaque1, fototaque2, fototaque3,fototaque4, desctaquete1,desctaquete2, desctaquete3, desctaquete4;

    public LienzoTaquetes(Context context) {
        super(context);

        icono = new ImagenTaquetes(R.drawable.icono,25,50,this);
        fondo3 = new ImagenTaquetes(R.drawable.fondo2,0,0,this);
        scroll2 = new ImagenTaquetes(R.drawable.scroll2,10,0,this);

        taquete1 = new ImagenTaquetes(R.drawable.taquete1,25,400,this);
        taquete2 = new ImagenTaquetes(R.drawable.taquete2,25,700,this);
        taquete3 = new ImagenTaquetes(R.drawable.taquete3, 25,1000, this);
        taquete4 = new ImagenTaquetes(R.drawable.taquete4,25,1300,this);

        //-------------------------------------------------------------------------

        fototaque1 = new ImagenTaquetes(R.drawable.fototaque1, 370, 50, this);
        fototaque1.hacerVisible(true);

        fototaque2 = new ImagenTaquetes(R.drawable.fototaque2, 370, 50, this);
        fototaque2.hacerVisible(false);

        fototaque3 = new ImagenTaquetes(R.drawable.fototaque3, 370, 50, this);
        fototaque3.hacerVisible(false);

        fototaque4 = new ImagenTaquetes(R.drawable.fototaque4, 370, 50, this);
        fototaque4.hacerVisible(false);

        //---------------------------------------------------------------------------

        desctaquete1 = new ImagenTaquetes(R.drawable.desctaquete1, 360, 750, this);
        desctaquete1.hacerVisible(true);

        desctaquete2 = new ImagenTaquetes(R.drawable.desctaquete2, 360, 750, this);
        desctaquete2.hacerVisible(false);

        desctaquete3 = new ImagenTaquetes(R.drawable.desctaquete3, 360, 750, this);
        desctaquete3.hacerVisible(false);

        desctaquete4 = new ImagenTaquetes(R.drawable.desctaquete4, 360, 750, this);
        desctaquete4.hacerVisible(false);


        puntero = null;

    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        fondo3.pintar(canvas, p);
        scroll2.pintar(canvas,p);
        icono.pintar(canvas,p);

        fototaque1.pintar(canvas,p);
        fototaque2.pintar(canvas,p);
        fototaque3.pintar(canvas,p);
        fototaque4.pintar(canvas,p);

        desctaquete1.pintar(canvas,p);
        desctaquete2.pintar(canvas,p);
        desctaquete3.pintar(canvas,p);
        desctaquete4.pintar(canvas,p);

        taquete1.pintar(canvas,p);
        taquete2.pintar(canvas,p);
        taquete3.pintar(canvas,p);
        taquete4.pintar(canvas,p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las x (lo ancho de la pantalla)
        float yp = e.getY(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las y (lo alto de la pantalla)


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:


                if (taquete1.estaEnArea(xp,yp)){
                    puntero = taquete1;
                    fototaque1.hacerVisible(true);
                    desctaquete1.hacerVisible(true);


                    fototaque2.hacerVisible(false);
                    desctaquete2.hacerVisible(false);
                    fototaque3.hacerVisible(false);
                    desctaquete3.hacerVisible(false);
                    fototaque4.hacerVisible(false);
                    desctaquete4.hacerVisible(false);

                }

                if (taquete2.estaEnArea(xp,yp)){
                    puntero = taquete2;
                    fototaque2.hacerVisible(true);
                    desctaquete2.hacerVisible(true);

                    fototaque1.hacerVisible(false);
                    desctaquete1.hacerVisible(false);
                    fototaque3.hacerVisible(false);
                    desctaquete3.hacerVisible(false);
                    fototaque4.hacerVisible(false);
                    desctaquete4.hacerVisible(false);

                }

                if (taquete3.estaEnArea(xp,yp)){
                    puntero = taquete3;
                    fototaque3.hacerVisible(true);
                    desctaquete3.hacerVisible(true);

                    fototaque2.hacerVisible(false);
                    desctaquete2.hacerVisible(false);
                    fototaque1.hacerVisible(false);
                    desctaquete1.hacerVisible(false);
                    fototaque4.hacerVisible(false);
                    desctaquete4.hacerVisible(false);
                }

                if (taquete4.estaEnArea(xp,yp)){
                    puntero = taquete4;
                    fototaque4.hacerVisible(true);
                    desctaquete4.hacerVisible(true);

                    fototaque3.hacerVisible(false);
                    desctaquete3.hacerVisible(false);
                    fototaque2.hacerVisible(false);
                    desctaquete2.hacerVisible(false);
                    fototaque1.hacerVisible(false);
                    desctaquete1.hacerVisible(false);

                }

                break;

            case MotionEvent.ACTION_MOVE:

                if (puntero==taquete1){
                    taquete1.mover(yp);
                    taquete2.mover(yp+300);
                    taquete3.mover(yp+600);
                    taquete4.mover(yp+900);

                    if (puntero.colision(icono) && puntero == taquete1){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 400){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==taquete2){
                    taquete2.mover(yp);
                    taquete1.mover(yp-300);
                    taquete3.mover(yp+300);
                    taquete4.mover(yp+600);

                    if (xp >= 25 && yp <= 690){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 700){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==taquete3){
                    taquete3.mover(yp);
                    taquete1.mover(yp-600);
                    taquete2.mover(yp-300);
                    taquete4.mover(yp+300);

                    if (xp >= 25 && yp <= 990){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 1000){
                        icono.hacerVisible(true);
                    }
                }

                if (puntero==taquete4){
                    taquete4.mover(yp);
                    taquete1.mover(yp-900);
                    taquete2.mover(yp-600);
                    taquete3.mover(yp-300);

                    if (xp >= 25 && yp <= 1290){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 1300){
                        icono.hacerVisible(true);
                    }
                }

                break;

            case MotionEvent.ACTION_UP:
                puntero = null;

                break;
        }
        invalidate();
        return true;
    }
}
