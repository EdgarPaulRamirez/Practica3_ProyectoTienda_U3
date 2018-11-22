package mx.edu.ittepic.proyectotienda_u3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoSudadera extends View {
    ImagenSudadera sudadera1,sudadera2,sudadera3,sudadera4,icono,fondo3, scroll2, puntero, fotosuda1, fotosuda2, fotosuda3,fotosuda4, descsuda1,descsuda2, descsuda3, descsuda4;

    public LienzoSudadera(Context context) {
        super(context);

        icono = new ImagenSudadera(R.drawable.icono,25,50,this);
        fondo3 = new ImagenSudadera(R.drawable.fondo2,0,0,this);
        scroll2 = new ImagenSudadera(R.drawable.scroll2,10,0,this);

        sudadera1 = new ImagenSudadera(R.drawable.sudadera1,25,400,this);
        sudadera2 = new ImagenSudadera(R.drawable.sudadera2,25,700,this);
        sudadera3 = new ImagenSudadera(R.drawable.sudadera3, 25,1000, this);
        sudadera4 = new ImagenSudadera(R.drawable.sudadera4,25,1300,this);

        //-------------------------------------------------------------------------

        fotosuda1 = new ImagenSudadera(R.drawable.fotosuda1, 370, 50, this);
        fotosuda1.hacerVisible(true);

        fotosuda2 = new ImagenSudadera(R.drawable.fotosuda2, 370, 50, this);
        fotosuda2.hacerVisible(false);

        fotosuda3 = new ImagenSudadera(R.drawable.fotosuda3, 370, 50, this);
        fotosuda3.hacerVisible(false);

        fotosuda4 = new ImagenSudadera(R.drawable.fotosuda4, 370, 50, this);
        fotosuda4.hacerVisible(false);

        //---------------------------------------------------------------------------

        descsuda1 = new ImagenSudadera(R.drawable.descsuda1, 360, 750, this);
        descsuda1.hacerVisible(true);

        descsuda2 = new ImagenSudadera(R.drawable.descsuda2, 360, 750, this);
        descsuda2.hacerVisible(false);

        descsuda3 = new ImagenSudadera(R.drawable.descsuda3, 360, 750, this);
        descsuda3.hacerVisible(false);

        descsuda4 = new ImagenSudadera(R.drawable.descsuda4, 360, 750, this);
        descsuda4.hacerVisible(false);


        puntero = null;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        fondo3.pintar(canvas, p);
        scroll2.pintar(canvas,p);
        icono.pintar(canvas,p);

        fotosuda1.pintar(canvas,p);
        fotosuda2.pintar(canvas,p);
        fotosuda3.pintar(canvas,p);
        fotosuda4.pintar(canvas,p);

        descsuda1.pintar(canvas,p);
        descsuda2.pintar(canvas,p);
        descsuda3.pintar(canvas,p);
        descsuda4.pintar(canvas,p);

        sudadera1.pintar(canvas,p);
        sudadera2.pintar(canvas,p);
        sudadera3.pintar(canvas,p);
        sudadera4.pintar(canvas,p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las x (lo ancho de la pantalla)
        float yp = e.getY(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las y (lo alto de la pantalla)


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:


                if (sudadera1.estaEnArea(xp,yp)){
                    puntero = sudadera1;
                    fotosuda1.hacerVisible(true);
                    descsuda1.hacerVisible(true);


                    fotosuda2.hacerVisible(false);
                    descsuda2.hacerVisible(false);
                    fotosuda3.hacerVisible(false);
                    descsuda3.hacerVisible(false);
                    fotosuda4.hacerVisible(false);
                    descsuda4.hacerVisible(false);

                }

                if (sudadera2.estaEnArea(xp,yp)){
                    puntero = sudadera2;
                    fotosuda2.hacerVisible(true);
                    descsuda2.hacerVisible(true);

                    fotosuda1.hacerVisible(false);
                    descsuda1.hacerVisible(false);
                    fotosuda3.hacerVisible(false);
                    descsuda3.hacerVisible(false);
                    fotosuda4.hacerVisible(false);
                    descsuda4.hacerVisible(false);

                }

                if (sudadera3.estaEnArea(xp,yp)){
                    puntero = sudadera3;
                    fotosuda3.hacerVisible(true);
                    descsuda3.hacerVisible(true);

                    fotosuda2.hacerVisible(false);
                    descsuda2.hacerVisible(false);
                    fotosuda1.hacerVisible(false);
                    descsuda1.hacerVisible(false);
                    fotosuda4.hacerVisible(false);
                    descsuda4.hacerVisible(false);
                }

                if (sudadera4.estaEnArea(xp,yp)){
                    puntero = sudadera4;
                    fotosuda4.hacerVisible(true);
                    descsuda4.hacerVisible(true);

                    fotosuda3.hacerVisible(false);
                    descsuda3.hacerVisible(false);
                    fotosuda2.hacerVisible(false);
                    descsuda2.hacerVisible(false);
                    fotosuda1.hacerVisible(false);
                    descsuda1.hacerVisible(false);

                }

                break;

            case MotionEvent.ACTION_MOVE:

                if (puntero==sudadera1){
                    sudadera1.mover(yp);
                    sudadera2.mover(yp+300);
                    sudadera3.mover(yp+600);
                    sudadera4.mover(yp+900);

                    if (puntero.colision(icono) && puntero == sudadera1){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 400){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==sudadera2){
                    sudadera2.mover(yp);
                    sudadera1.mover(yp-300);
                    sudadera3.mover(yp+300);
                    sudadera4.mover(yp+600);

                    if (xp >= 25 && yp <= 690){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 700){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==sudadera3){
                    sudadera3.mover(yp);
                    sudadera1.mover(yp-600);
                    sudadera2.mover(yp-300);
                    sudadera4.mover(yp+300);

                    if (xp >= 25 && yp <= 990){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 1000){
                        icono.hacerVisible(true);
                    }
                }

                if (puntero==sudadera4){
                    sudadera4.mover(yp);
                    sudadera1.mover(yp-900);
                    sudadera2.mover(yp-600);
                    sudadera3.mover(yp-300);

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
