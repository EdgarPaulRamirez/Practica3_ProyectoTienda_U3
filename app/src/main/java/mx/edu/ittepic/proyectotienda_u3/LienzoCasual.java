package mx.edu.ittepic.proyectotienda_u3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoCasual extends View {
    ImagenCasual tenisc1,tenisc2,tenisc3,tenisc4,icono,fondo3, scroll2, puntero,
            fototenis1, fototenis2, fototenis3,fototenis4, desccasual1,desccasual2, desccasual3, desccasual4;
    public LienzoCasual(Context context) {
        super(context);

        icono = new ImagenCasual(R.drawable.icono,25,50,this);
        fondo3 = new ImagenCasual(R.drawable.fondo2,0,0,this);
        scroll2 = new ImagenCasual(R.drawable.scroll2,10,0,this);

        tenisc1 = new ImagenCasual(R.drawable.tenisc1,25,400,this);
        tenisc2 = new ImagenCasual(R.drawable.tenisc2,25,700,this);
        tenisc3 = new ImagenCasual(R.drawable.tenisc3, 25,1000, this);
        tenisc4 = new ImagenCasual(R.drawable.tenisc4,25,1300,this);

        //-------------------------------------------------------------------------

        fototenis1 = new ImagenCasual(R.drawable.fototenisc1, 370, 50, this);
        fototenis1.hacerVisible(true);

        fototenis2 = new ImagenCasual(R.drawable.fototenisc2, 370, 50, this);
        fototenis2.hacerVisible(false);

        fototenis3 = new ImagenCasual(R.drawable.fototenisc3, 370, 50, this);
        fototenis3.hacerVisible(false);

        fototenis4 = new ImagenCasual(R.drawable.fototenisc4, 370, 50, this);
        fototenis4.hacerVisible(false);

        //---------------------------------------------------------------------------

        desccasual1 = new ImagenCasual(R.drawable.desccasual1, 360, 750, this);
        desccasual1.hacerVisible(true);

        desccasual2 = new ImagenCasual(R.drawable.desccasual2, 360, 750, this);
        desccasual2.hacerVisible(false);

        desccasual3 = new ImagenCasual(R.drawable.desccasual3, 360, 750, this);
        desccasual3.hacerVisible(false);

        desccasual4 = new ImagenCasual(R.drawable.desccasual4, 360, 750, this);
        desccasual4.hacerVisible(false);


        puntero = null;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        fondo3.pintar(canvas, p);
        scroll2.pintar(canvas,p);
        icono.pintar(canvas,p);

        fototenis1.pintar(canvas,p);
        fototenis2.pintar(canvas,p);
        fototenis3.pintar(canvas,p);
        fototenis4.pintar(canvas,p);

        desccasual1.pintar(canvas,p);
        desccasual2.pintar(canvas,p);
        desccasual3.pintar(canvas,p);
        desccasual4.pintar(canvas,p);

        tenisc1.pintar(canvas,p);
        tenisc2.pintar(canvas,p);
        tenisc3.pintar(canvas,p);
        tenisc4.pintar(canvas,p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las x (lo ancho de la pantalla)
        float yp = e.getY(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las y (lo alto de la pantalla)


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:


                if (tenisc1.estaEnArea(xp,yp)){
                    puntero = tenisc1;
                    fototenis1.hacerVisible(true);
                    desccasual1.hacerVisible(true);


                    fototenis2.hacerVisible(false);
                    desccasual2.hacerVisible(false);
                    fototenis3.hacerVisible(false);
                    desccasual3.hacerVisible(false);
                    fototenis4.hacerVisible(false);
                    desccasual4.hacerVisible(false);

                }

                if (tenisc2.estaEnArea(xp,yp)){
                    puntero = tenisc2;
                    fototenis2.hacerVisible(true);
                    desccasual2.hacerVisible(true);

                    fototenis1.hacerVisible(false);
                    desccasual1.hacerVisible(false);
                    fototenis3.hacerVisible(false);
                    desccasual3.hacerVisible(false);
                    fototenis4.hacerVisible(false);
                    desccasual4.hacerVisible(false);

                }

                if (tenisc3.estaEnArea(xp,yp)){
                    puntero = tenisc3;
                    fototenis3.hacerVisible(true);
                    desccasual3.hacerVisible(true);

                    fototenis2.hacerVisible(false);
                    desccasual2.hacerVisible(false);
                    fototenis1.hacerVisible(false);
                    desccasual1.hacerVisible(false);
                    fototenis4.hacerVisible(false);
                    desccasual4.hacerVisible(false);
                }

                if (tenisc4.estaEnArea(xp,yp)){
                    puntero = tenisc4;
                    fototenis4.hacerVisible(true);
                    desccasual4.hacerVisible(true);

                    fototenis3.hacerVisible(false);
                    desccasual3.hacerVisible(false);
                    fototenis2.hacerVisible(false);
                    desccasual2.hacerVisible(false);
                    fototenis1.hacerVisible(false);
                    desccasual1.hacerVisible(false);

                }

                break;

            case MotionEvent.ACTION_MOVE:

                if (puntero==tenisc1){
                    tenisc1.mover(yp);
                    tenisc2.mover(yp+300);
                    tenisc3.mover(yp+600);
                    tenisc4.mover(yp+900);

                    if (puntero.colision(icono) && puntero == tenisc1){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 400){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==tenisc2){
                    tenisc2.mover(yp);
                    tenisc1.mover(yp-300);
                    tenisc3.mover(yp+300);
                    tenisc4.mover(yp+600);

                    if (xp >= 25 && yp <= 690){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 700){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==tenisc3){
                    tenisc3.mover(yp);
                    tenisc1.mover(yp-600);
                    tenisc2.mover(yp-300);
                    tenisc4.mover(yp+300);

                    if (xp >= 25 && yp <= 990){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 1000){
                        icono.hacerVisible(true);
                    }
                }

                if (puntero==tenisc4){
                    tenisc4.mover(yp);
                    tenisc1.mover(yp-900);
                    tenisc2.mover(yp-600);
                    tenisc3.mover(yp-300);

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
