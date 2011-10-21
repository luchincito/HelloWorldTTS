package br.android.HelloWorldTTS;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

/**
 * TTS (Text-to-Speech) do GPS android. Implementa a OnInitListener
 * @author Glauber
 * 
 */

public class HelloWorldTTSActivity extends Activity implements OnInitListener {

	private TextToSpeech tts;

	
    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, 0);
        tts = new TextToSpeech(this, this);

    }

    
    /**
     * Função responsável por pegar as strings e converter para fala
     * @param arg0
     */
    public void onInit(int arg0) {
    	//Strings que serão faladas ao iniciar o programa
	    String speech1 = "Google maps";
	    String speech2 = "Hello World, people";
	    //Define qual a linguagem que será utilizada para falar a frase contida na string
	    tts.setLanguage(Locale.US);
	    //Chamada da função de conversão da string para a fala
	    tts.speak(speech1, TextToSpeech.QUEUE_FLUSH, null);
	    tts.speak(speech2, TextToSpeech.QUEUE_ADD, null);
    }

}