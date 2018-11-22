package mx.edu.ittepic.proyectotienda_u3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoPants extends View {
    ImagenPants pants1,pants2,pants3,pants4,icono,fondo3, scroll2, puntero,
            fotopants1, fotopants2, fotopants3,fotopants4, descpants1,descpants2, descpants3, descpants4;
    public LienzoPants(Context context) {
        super(context);

        icono = new ImagenPants(R.drawable.icono,25,50,this);
        fondo3 = new ImagenPants(R.drawable.fondo2,0,0,this);
        scroll2 = new ImagenPants(R.drawable.scroll2,10,0,this);

        pants1 = new ImagenPants(R.drawable.pants1,25,400,this);
        pants2 = new ImagenPants(R.drawable.pants2,25,700,this);
        pants3 = new ImagenPants(R.drawable.pants3, 25,1000, this);
        pants4 = new ImagenPants(R.drawable.pants4,25,1300,this);

        //-------------------------------------------------------------------------

        fotopants1 = new ImagenPants(R.drawable.fotopants1, 370, 50, this);
        fotopants1.hacerVisible(true);

        fotopants2 = new ImagenPants(R.drawable.fotopants2, 370, 50, this);
        fotopants2.hacerVisible(false);

        fotopants3 = new ImagenPants(R.drawable.fotopants3, 370, 50, this);
        fotopants3.hacerVisible(false);

        fotopants4 = new ImagenPants(R.drawable.fotopants4, 370, 50, this);
        fotopants4.hacerVisible(false);

        //---------------------------------------------------------------------------

        descpants1 = new ImagenPants(R.drawable.descpants1, 360, 750, this);
        descpants1.hacerVisible(true);

        descpants2 = new ImagenPants(R.drawable.descpants2, 360, 750, this);
        descpants2.hacerVisible(false);

        descpants3 = new ImagenPants(R.drawable.descpants3, 360, 750, this);
        descpants3.hacerVisible(false);

        descpants4 = new ImagenPants(R.drawable.descpants4, 360, 750, this);
        descpants4.hacerVisible(false);


        puntero = null;

    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        fondo3.pintar(canvas, p);
        scroll2.pintar(canvas,p);
        icono.pintar(canvas,p);

        fotopants1.pintar(canvas,p);
        fotopants2.pintar(canvas,p);
        fotopants3.pintar(canvas,p);
        fotopants4.pintar(canvas,p);

        descpants1.pintar(canvas,p);
        descpants2.pintar(canvas,p);
        descpants3.pintar(canvas,p);
        descpants4.pintar(canvas,p);


        pants1.pintar(canvas,p);
        pants2.pintar(canvas,p);
        pants3.pintar(canvas,p);
        pants4.pintar(canvas,p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las x (lo ancho de la pantalla)
        float yp = e.getY(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las y (lo alto de la pantalla)


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:


                if (pants1.estaEnArea(xp,yp)){
                    puntero = pants1;
                    fotopants1.hacerVisible(true);
                    descpants1.hacerVisible(true);


                    fotopants2.hacerVisible(false);
                    descpants2.hacerVisible(false);
                    fotopants3.hacerVisible(false);
                    descpants3.hacerVisible(false);
                    fotopants4.hacerVisible(false);
                    descpants4.hacerVisible(false);

                }

                if (pants2.estaEnArea(xp,yp)){
                    puntero = pants2;
                    fotopants2.hacerVisible(true);
                    descpants2.hacerVisible(true);

                    fotopants1.hacerVisible(false);
                    descpants1.hacerVisible(false);
                    fotopants3.hacerVisible(false);
                    descpants3.hacerVisible(false);
                    fotopants4.hacerVisible(false);
                    descpants4.hacerVisible(false);

                }

                if (pants3.estaEnArea(xp,yp)){
                    puntero = pants3;
                    fotopants3.hacerVisible(true);
                    descpants3.hacerVisible(true);

                    fotopants2.hacerVisible(false);
                    descpants2.hacerVisible(false);
                    fotopants1.hacerVisible(false);
                    descpants1.hacerVisible(false);
                    fotopants4.hacerVisible(false);
                    descpants4.hacerVisible(false);
                }

                if (pants4.estaEnArea(xp,yp)){
                    puntero = pants4;
                    fotopants4.hacerVisible(true);
                    descpants4.hacerVisible(true);

                    fotopants3.hacerVisible(false);
                    descpants3.hacerVisible(false);
                    fotopants2.hacerVisible(false);
                    descpants2.hacerVisible(false);
                    fotopants1.hacerVisible(false);
                    descpants1.hacerVisible(false);

                }

                break;

            case MotionEvent.ACTION_MOVE:

                if (puntero==pants1){
                    pants1.mover(yp);
                    pants2.mover(yp+300);
                    pants3.mover(yp+600);
                    pants4.mover(yp+900);

                    if (puntero.colision(icono) && puntero == pants1){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 400){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==pants2){
                    pants2.mover(yp);
                    pants1.mover(yp-300);
                    pants3.mover(yp+300);
                    pants4.mover(yp+600);

                    if (xp >= 25 && yp <= 690){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 700){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==pants3){
                    pants3.mover(yp);
                    pants1.mover(yp-600);
                    pants2.mover(yp-300);
                    pants4.mover(yp+300);

                    if (xp >= 25 && yp <= 990){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 1000){
                        icono.hacerVisible(true);
                    }
                }

                if (puntero==pants4){
                    pants4.mover(yp);
                    pants1.mover(yp-900);
                    pants2.mover(yp-600);
                    pants3.mover(yp-300);

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
