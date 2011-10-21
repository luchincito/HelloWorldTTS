package br.android.HelloWorldTTS;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * TTS (Text-to-Speech) do GPS android
 * @author Glauber
 * 
 */

public class HelloWorldTTSActivity extends Activity implements OnInitListener {

	private TextToSpeech tts;

	
    /** 
     * Apresenta o layout e , de acordo com a opção escolhida, seleciona o idioma.
     * @param savedInstanceState
     */

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button buttonUK = (Button) findViewById(R.id.button1);
        Button buttonUS = (Button) findViewById(R.id.button2);
        Button buttonFrances = (Button) findViewById(R.id.button3);
        Button buttonAlemao = (Button) findViewById(R.id.button4);
        Button buttonTestar = (Button) findViewById(R.id.button5);
        
        tts = new TextToSpeech(this, this);
        
        buttonUK.setOnClickListener(new OnClickListener() { 
			
			public void onClick(View v){ 
				tts.setLanguage(Locale.UK);
			}
		});
        
        buttonUS.setOnClickListener(new OnClickListener() { 
			
			public void onClick(View v){ 
				tts.setLanguage(Locale.US);
			}
		});
        
        buttonFrances.setOnClickListener(new OnClickListener() { 
			
			public void onClick(View v){ 
				tts.setLanguage(Locale.FRENCH);
			}
		});
        
        buttonAlemao.setOnClickListener(new OnClickListener() { 
			
			public void onClick(View v){ 	   
				tts.setLanguage(Locale.GERMAN);
				}
		});
        
        buttonTestar.setOnClickListener(new OnClickListener() { 
			
			public void onClick(View v){ 	   
				Speach();
				}
		});
    }
    
    
    /**
     * Função responsável por pegar as strings e converter para fala
     * @param arg0
     */
    public void Speach() {
    	
    	//Strings que serão faladas ao iniciar o programa
	    String speech1 = "Google maps";
	    String speech2 = "Hello World, people";
	    //Define qual a linguagem que será utilizada para falar a frase contida na string
	    //Chamada da função de conversão da string para a fala
	    tts.speak(speech1, TextToSpeech.QUEUE_FLUSH, null);
	    tts.speak(speech2, TextToSpeech.QUEUE_ADD, null);
    }
   
	/**
	 * Função executada ao iniciar o app
	 * @param status
	 */
	public void onInit(int status) {
		String speech1 = "Hello, buddy!! Choose you idioma. Thanks!!";
		tts.speak(speech1, TextToSpeech.QUEUE_FLUSH, null);
	}

}