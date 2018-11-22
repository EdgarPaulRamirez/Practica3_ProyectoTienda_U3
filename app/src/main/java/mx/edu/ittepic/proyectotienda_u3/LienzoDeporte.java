package mx.edu.ittepic.proyectotienda_u3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoDeporte extends View {
    ImagenDeporte tenisdeporte1,tenisdeporte2,tenisdeporte3,tenisdeporte4,icono,fondo3, scroll2, puntero,
            fotodepo1, fotodepo2, fotodepo3,fotodepo4, descdepo1,descdepo2, descdepo3, descdepo4;

    public LienzoDeporte(Context context) {
        super(context);

        icono = new ImagenDeporte(R.drawable.icono,25,50,this);
        fondo3 = new ImagenDeporte(R.drawable.fondo2,0,0,this);
        scroll2 = new ImagenDeporte(R.drawable.scroll2,10,0,this);

        tenisdeporte1 = new ImagenDeporte(R.drawable.tenisdeporte1,25,400,this);
        tenisdeporte2 = new ImagenDeporte(R.drawable.tenisdeporte2,25,700,this);
        tenisdeporte3 = new ImagenDeporte(R.drawable.tenisdeporte3, 25,1000, this);
        tenisdeporte4 = new ImagenDeporte(R.drawable.tenisdeporte4,25,1300,this);

        //-------------------------------------------------------------------------

        fotodepo1 = new ImagenDeporte(R.drawable.fotodepo1, 370, 50, this);
        fotodepo1.hacerVisible(true);

        fotodepo2 = new ImagenDeporte(R.drawable.fotodepo2, 370, 50, this);
        fotodepo2.hacerVisible(false);

        fotodepo3 = new ImagenDeporte(R.drawable.fotodepo3, 370, 50, this);
        fotodepo3.hacerVisible(false);

        fotodepo4 = new ImagenDeporte(R.drawable.fotodepo4, 370, 50, this);
        fotodepo4.hacerVisible(false);

        //---------------------------------------------------------------------------

        descdepo1 = new ImagenDeporte(R.drawable.descdepo1, 360, 750, this);
        descdepo1.hacerVisible(true);

        descdepo2 = new ImagenDeporte(R.drawable.descdepo2, 360, 750, this);
        descdepo2.hacerVisible(false);

        descdepo3 = new ImagenDeporte(R.drawable.descdepo3, 360, 750, this);
        descdepo3.hacerVisible(false);

        descdepo4 = new ImagenDeporte(R.drawable.descdepo4, 360, 750, this);
        descdepo4.hacerVisible(false);


        puntero = null;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        fondo3.pintar(canvas, p);
        scroll2.pintar(canvas,p);
        icono.pintar(canvas,p);

        fotodepo1.pintar(canvas,p);
        fotodepo2.pintar(canvas,p);
        fotodepo3.pintar(canvas,p);
        fotodepo4.pintar(canvas,p);

        descdepo1.pintar(canvas,p);
        descdepo2.pintar(canvas,p);
        descdepo3.pintar(canvas,p);
        descdepo4.pintar(canvas,p);

        tenisdeporte1.pintar(canvas,p);
        tenisdeporte2.pintar(canvas,p);
        tenisdeporte3.pintar(canvas,p);
        tenisdeporte4.pintar(canvas,p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las x (lo ancho de la pantalla)
        float yp = e.getY(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las y (lo alto de la pantalla)


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:


                if (tenisdeporte1.estaEnArea(xp,yp)){
                    puntero = tenisdeporte1;
                    fotodepo1.hacerVisible(true);
                    descdepo1.hacerVisible(true);


                    fotodepo2.hacerVisible(false);
                    descdepo2.hacerVisible(false);
                    fotodepo3.hacerVisible(false);
                    descdepo3.hacerVisible(false);
                    fotodepo4.hacerVisible(false);
                    descdepo4.hacerVisible(false);

                }

                if (tenisdeporte2.estaEnArea(xp,yp)){
                    puntero = tenisdeporte2;
                    fotodepo2.hacerVisible(true);
                    descdepo2.hacerVisible(true);

                    fotodepo1.hacerVisible(false);
                    descdepo1.hacerVisible(false);
                    fotodepo3.hacerVisible(false);
                    descdepo3.hacerVisible(false);
                    fotodepo4.hacerVisible(false);
                    descdepo4.hacerVisible(false);

                }

                if (tenisdeporte3.estaEnArea(xp,yp)){
                    puntero = tenisdeporte3;
                    fotodepo3.hacerVisible(true);
                    descdepo3.hacerVisible(true);

                    fotodepo2.hacerVisible(false);
                    descdepo2.hacerVisible(false);
                    fotodepo1.hacerVisible(false);
                    descdepo1.hacerVisible(false);
                    fotodepo4.hacerVisible(false);
                    descdepo4.hacerVisible(false);
                }

                if (tenisdeporte4.estaEnArea(xp,yp)){
                    puntero = tenisdeporte4;
                    fotodepo4.hacerVisible(true);
                    descdepo4.hacerVisible(true);

                    fotodepo3.hacerVisible(false);
                    descdepo3.hacerVisible(false);
                    fotodepo2.hacerVisible(false);
                    descdepo2.hacerVisible(false);
                    fotodepo1.hacerVisible(false);
                    descdepo1.hacerVisible(false);

                }

                break;

            case MotionEvent.ACTION_MOVE:

                if (puntero==tenisdeporte1){
                    tenisdeporte1.mover(yp);
                    tenisdeporte2.mover(yp+300);
                    tenisdeporte3.mover(yp+600);
                    tenisdeporte4.mover(yp+900);

                    if (puntero.colision(icono) && puntero == tenisdeporte1){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 400){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==tenisdeporte2){
                    tenisdeporte2.mover(yp);
                    tenisdeporte1.mover(yp-300);
                    tenisdeporte3.mover(yp+300);
                    tenisdeporte4.mover(yp+600);

                    if (xp >= 25 && yp <= 690){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 700){
                        icono.hacerVisible(true);
                    }

                }

                if (puntero==tenisdeporte3){
                    tenisdeporte3.mover(yp);
                    tenisdeporte1.mover(yp-600);
                    tenisdeporte2.mover(yp-300);
                    tenisdeporte4.mover(yp+300);

                    if (xp >= 25 && yp <= 990){
                        icono.hacerVisible(false);
                    }

                    if (xp >= 25 && yp >= 1000){
                        icono.hacerVisible(true);
                    }
                }

                if (puntero==tenisdeporte4){
                    tenisdeporte4.mover(yp);
                    tenisdeporte1.mover(yp-900);
                    tenisdeporte2.mover(yp-600);
                    tenisdeporte3.mover(yp-300);

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
