package com.losgangnamstyle.proyectoesiimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
 
public class SplashScreen extends Activity {
 
 /** Se le llama cuando la actividad es creada por primera vez*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
 
        super.onCreate(savedInstanceState);
         
        //Creamos un objeto de tipo SplashHandler
        SplashHandler mHandler = new SplashHandler();
        //Le decimos cual es el XML que va a usar como configurador de la actividad
        setContentView(R.layout.splash_activity);
        //Creamos un objeto de tipo Message
        Message msg = new Message();
        //Asignamos un codigo unico al mensaje
        //Despues este codigo sera utilizado para identificar el mensaje.
        msg.what = 0;
        //Enviamos el mensaje que durara 3 segundos (3000 = 3 seg)
        mHandler.sendMessageDelayed(msg, 3000);
    }     
     
    //La clase Handler implementa 'handle' el manejador de los mensajes
    private class SplashHandler extends Handler {
         
     //Este metodo se usa para manejar los mensajes recibidos. 
        public void handleMessage(Message msg)
          {
 
            final Intent intent = new Intent();
            //switch del identificador del mensaje segun su codigo
            switch (msg.what) {
            case 0:
             super.handleMessage(msg);
             //Creamos un intent para arrancar la actividad
             //Nuestra intención es comenzar MainActivity
             intent.setClass(SplashScreen.this,MainActivity.class);
             startActivity(intent);
             // finalizamos la actual actividad
             SplashScreen.this.finish();
             break;
            default:
             //Duplicamos el codigo por que solo tenemos un splash screen
             //si tuvieramos alguno que tuviera que salir en caso de fallo lo pondriamos aquí
                super.handleMessage(msg);
                intent.setClass(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                SplashScreen.this.finish();
                break;
            }
          }
    }    
    
 
}
