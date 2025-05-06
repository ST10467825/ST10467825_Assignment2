package vcmsa.ci.st10467825_assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        //Declarations
        val startButton = findViewById<Button>(R.id.startButton)


        startButton.setOnClickListener {
            //explicit intent
            val intent = Intent(this, flashcardQuestions::class.java)
            startActivity(intent)
        }
    }
}