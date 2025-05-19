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
        val questionsArray = intent.getStringArrayExtra("questionsArray") ?: arrayOf()
        val answersArray = intent.getBooleanArrayExtra("answersArray") ?: booleanArrayOf()
        val userAnswersArray = intent.getBooleanArrayExtra("userAnswersArray") ?: booleanArrayOf()
        val score = intent.getIntExtra("score", 0)

        // Declarations
        val buttonExit = findViewById<Button>(R.id.buttonExit)
        val buttonReview = findViewById<Button>(R.id.buttonReview)
        val scoreView = findViewById<TextView>(R.id.scoreView)
        val FeedbackTable = findViewById<TableLayout>(R.id.FeedbackTable)

        // Set score text
        scoreView.text = "Score: $score/${questionsArray.size}"

        FeedbackTable.visibility = View.INVISIBLE

        buttonReview.setOnClickListener {
            FeedbackTable.visibility = View.VISIBLE
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

        for (i in 0 until itemsToShow) {
            questionViews[i].text = questionsArray[i]
            answerViews[i].text = answersArray[i].toString()
            userAnswerViews[i].text = userAnswersArray[i].toString()
        }

        // Hide any unused rows
        for (i in itemsToShow until questionViews.size) {
            questionViews[i].visibility = View.GONE
            answerViews[i].visibility = View.GONE
            userAnswerViews[i].visibility = View.GONE
        }

        // Exit button
        buttonExit.setOnClickListener {
            finish()
        }
    }
}