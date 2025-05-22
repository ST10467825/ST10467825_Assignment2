package vcmsa.ci.st10467825_assignment2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class feedback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feedback)

        // Get data from intent with null checks
        val score = intent.getIntExtra("score", 0)

        // Declarations
        val buttonExit = findViewById<Button>(R.id.buttonExit)
        val scoreView = findViewById<TextView>(R.id.scoreView)
        val userScorefeedback = findViewById<TextView>(R.id.userScoreFeedback)
        val buttonReview = findViewById<Button>(R.id.buttonReview)

        // Set score text
        scoreView.text = "Score: $score/${questionsArray.size}"

        //score feedback
        when (score) {
            in 0 .. 2 -> userScorefeedback.text = "You need to study more";
            in 3 .. 4 -> userScorefeedback.text = "You did well!";
            5 -> userScorefeedback.text = "Perfect Score! ${score}/5";
        }

        // Create arrays of TextViews
        val questionViews = arrayOf(
            findViewById<TextView>(R.id.Q0),
            findViewById<TextView>(R.id.Q1),
            findViewById<TextView>(R.id.Q2),
            findViewById<TextView>(R.id.Q3),
            findViewById<TextView>(R.id.Q4)
        )

        val answerViews = arrayOf(
            findViewById<TextView>(R.id.A0),
            findViewById<TextView>(R.id.A1),
            findViewById<TextView>(R.id.A2),
            findViewById<TextView>(R.id.A3),
            findViewById<TextView>(R.id.A4)
        )

        val userAnswerViews = arrayOf(
            findViewById<TextView>(R.id.user0),
            findViewById<TextView>(R.id.user1),
            findViewById<TextView>(R.id.user2),
            findViewById<TextView>(R.id.user3),
            findViewById<TextView>(R.id.user4)
        )

        // Populate the table safely
        val itemsToShow = minOf(
            questionsArray.size,
            answersArray.size,
            userAnswersArray.size,
            questionViews.size,
            answerViews.size,
            userAnswerViews.size
        )

        //review buttton
        buttonReview.setOnClickListener {


            for (i in 0 until itemsToShow) {
                questionViews[i].text = questionsArray[i]
                answerViews[i].text = answersArray[i].toString()
                userAnswerViews[i].text = userAnswersArray[i].toString()
            }
        }

        // Exit button
        buttonExit.setOnClickListener {
            finish()
        }
    }
}