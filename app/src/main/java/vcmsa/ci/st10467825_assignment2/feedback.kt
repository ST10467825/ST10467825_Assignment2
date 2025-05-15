package vcmsa.ci.st10467825_assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
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

        //val buttonExit = findViewById<Button>(R.id.buttonExit)
        val buttonReview = findViewById<Button>(R.id.buttonReview)
        val FeedbackTable = findViewById<TableLayout>(R.id.FeedbackTable)


        val questionsArray = intent.getStringArrayExtra("questionsArray")
        val answersArray = intent.getBooleanArrayExtra("answersArray")
        val userAnswersArray = intent.getBooleanArrayExtra("usersAnswerArray")

        buttonReview.setOnClickListener{
            FeedbackTable.visibility = View.VISIBLE
        }

        val q1 = findViewById<TextView>(R.id.q1)
        // q1.text = questionsArray[0]



        //buttonExit.setOnClickListener {
            //explicit intent
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)

        }
    }
//}