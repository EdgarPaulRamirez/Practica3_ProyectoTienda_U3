package mx.edu.ittepic.proyectotienda_u3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
public class Lienzo extends View {
    Imagen pans,sudadera,taquetes,teniscasual,tenisdeporte,fondo3,flecha,icono,scroll1, puntero, descpans, descsudadera, desctaquetes, descteniscasual, desctenisdeporte;
    Imagen deporte;
    MainActivity punteroMain;
    Integer numero=0;
    public Lienzo(Context context) {
        super(context);

        fondo3 = new Imagen(R.drawable.fondo3,0,0,this);
        icono = new Imagen(R.drawable.icono,60,30,this);
        flecha = new Imagen(R.drawable.flecha, 790, 1250, this);
        scroll1 = new Imagen(R.drawable.scroll1,0,400,this);
        deporte = new Imagen(R.drawable.deporte, 710, 30, this);

        pans = new Imagen(R.drawable.pans, -150, 415, this);//inicio
        sudadera = new Imagen(R.drawable.sudadera, 100, 415, this);//200 de diferencia
        taquetes = new Imagen(R.drawable.taquetes, 400, 410, this);//300 de diferencia
        teniscasual = new Imagen(R.drawable.teniscasual, 700, 410, this);//300 de diferencia
        tenisdeporte = new Imagen(R.drawable.tenisdeporte, 1000, 410, this);//300 de diferencia

        descpans = new Imagen(R.drawable.descpans, 20, 795, this);
        descpans.hacerVisible(false);

        descsudadera = new Imagen(R.drawable.descsudadera, 20, 795, this);
        descsudadera.hacerVisible(false);

        desctaquetes = new Imagen(R.drawable.desctaquetes, 20, 795, this);
        desctaquetes.hacerVisible(false);

        descteniscasual = new Imagen(R.drawable.descteniscasual, 20, 795, this);
        descteniscasual.hacerVisible(false);

        desctenisdeporte = new Imagen(R.drawable.desctenisdeporte, 20, 795, this);
        desctenisdeporte.hacerVisible(false);

        punteroMain = (MainActivity) context;
        puntero = null;

        flecha.hacerVisible(false);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        fondo3.pintar(canvas, p);
        icono.pintar(canvas,p);
        scroll1.pintar(canvas,p);
        flecha.pintar(canvas, p);
        deporte.pintar(canvas,p);

        descpans.pintar(canvas,p);
        descsudadera.pintar(canvas,p);
        desctaquetes.pintar(canvas,p);
        descteniscasual.pintar(canvas,p);
        desctenisdeporte.pintar(canvas,p);

        pans.pintar(canvas, p);
        sudadera.pintar(canvas,p);
        taquetes.pintar(canvas,p);
        teniscasual.pintar(canvas,p);
        tenisdeporte.pintar(canvas, p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las x (lo ancho de la pantalla)
        float yp = e.getY(); //recuperando la posicion en donde se encuentra el "touch" en el eje de las y (lo alto de la pantalla)


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:

                if (flecha.estaEnArea(xp,yp)){
                    puntero = flecha;

                    if (numero == 1){
                        Intent otraventana = new Intent(punteroMain,Main2Activity.class);
                        punteroMain.startActivity(otraventana);
                    }

                    if (numero == 2){
                        Intent otraventana = new Intent(punteroMain,Main3Activity.class);
                        punteroMain.startActivity(otraventana);
                    }

                    if (numero == 3){
                        Intent otraventana = new Intent(punteroMain,Main4Activity.class);
                        punteroMain.startActivity(otraventana);
                    }

                    if (numero == 5){
                        Intent otraventana = new Intent(punteroMain,Main5Activity.class);
                        punteroMain.startActivity(otraventana);
                    }

                    if (numero == 4){
                        Intent otraventana = new Intent(punteroMain,Main6Activity.class);
                        punteroMain.startActivity(otraventana);
                    }

                }

                if (pans.estaEnArea(xp,yp)){
                    puntero = pans;
                    descpans.hacerVisible(true);
                    descsudadera.hacerVisible(false);
                    desctaquetes.hacerVisible(false);
                    descteniscasual.hacerVisible(false);
                    desctenisdeporte.hacerVisible(false);
                    flecha.hacerVisible(true);
                    numero = 1;
                }

                if (sudadera.estaEnArea(xp,yp)){
                    puntero = sudadera;
                    descsudadera.hacerVisible(true);
                    descpans.hacerVisible(false);
                    desctaquetes.hacerVisible(false);
                    descteniscasual.hacerVisible(false);
                    desctenisdeporte.hacerVisible(false);
                    flecha.hacerVisible(true);
                    numero = 2;

                }

                if (taquetes.estaEnArea(xp,yp)){
                    puntero = taquetes;
                    desctaquetes.hacerVisible(true);
                    descsudadera.hacerVisible(false);
                    descpans.hacerVisible(false);
                    descteniscasual.hacerVisible(false);
                    desctenisdeporte.hacerVisible(false);
                    flecha.hacerVisible(true);
                    numero = 3;
                }

                if (teniscasual.estaEnArea(xp,yp)){
                    puntero = teniscasual;
                    descteniscasual.hacerVisible(true);
                    desctaquetes.hacerVisible(false);
                    descsudadera.hacerVisible(false);
                    descpans.hacerVisible(false);
                    desctenisdeporte.hacerVisible(false);
                    flecha.hacerVisible(true);
                    numero = 4;
                }

                if (tenisdeporte.estaEnArea(xp,yp)){
                    puntero = tenisdeporte;
                    desctenisdeporte.hacerVisible(true);
                    descteniscasual.hacerVisible(false);
                    desctaquetes.hacerVisible(false);
                    descsudadera.hacerVisible(false);
                    descpans.hacerVisible(false);
                    flecha.hacerVisible(true);
                    numero = 5;

                }

                break;
                
            case MotionEvent.ACTION_MOVE:

                if (puntero==pans){
                    pans.mover(xp);

                    sudadera.mover(xp+250);
                    taquetes.mover(xp+550);
                    teniscasual.mover(xp+850);
                    tenisdeporte.mover(xp+1150);
                }

                if (puntero==sudadera){
                    sudadera.mover(xp);

                    pans.mover(xp-250);
                    taquetes.mover(xp+300);
                    teniscasual.mover(xp+600);
                    tenisdeporte.mover(xp+900);
                }

                if (puntero==taquetes){
                    taquetes.mover(xp);

                    pans.mover(xp-550);
                    sudadera.mover(xp-300);
                    teniscasual.mover(xp+300);
                    tenisdeporte.mover(xp+600);
                }

                if (puntero==teniscasual){
                    teniscasual.mover(xp);

                    pans.mover(xp-850);
                    sudadera.mover(xp-600);
                    taquetes.mover(xp-300);
                    tenisdeporte.mover(xp+300);
                }

                if (puntero==tenisdeporte){
                    tenisdeporte.mover(xp);

                    pans.mover(xp-1150);
                    sudadera.mover(xp-900);
                    taquetes.mover(xp-600);
                    teniscasual.mover(xp-300);

                }

                break;

            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }
}
