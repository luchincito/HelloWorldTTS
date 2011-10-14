package br.android.HelloWorldTTS;

import com.google.tts.TTS;
import android.app.Activity;
import android.os.Bundle;

public class HelloWorldTTSActivity extends Activity {

	private TTS myTts;

	
    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        myTts = new TTS(this, ttsInitListener, true);

    }

    
	private TTS.InitListener ttsInitListener = new TTS.InitListener() {

        public void onInit(int version) {

          myTts.speak("Hello world", 0, null);

        }

      };

}