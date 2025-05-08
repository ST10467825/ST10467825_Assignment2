package vcmsa.ci.st10467825_assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class feedback : AppCompatActivity() {

    //Declarations




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feedback)

        val buttonExit = findViewById<Button>(R.id.buttonExit)
        val buttonReview = findViewById<Button>(R.id.buttonReview)

        val questionsArray = intent.getStringArrayExtra("questionsArray")
        val answersArray = intent.getBooleanArrayExtra("answersArray")
        val userAnswersArray = intent.getBooleanArrayExtra("usersAnswerArray")

        buttonExit.setOnClickListener {
            //explicit intent
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)

        }
    }
}