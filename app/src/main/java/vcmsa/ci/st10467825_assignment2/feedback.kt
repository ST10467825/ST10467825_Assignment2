package vcmsa.ci.st10467825_assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.resources.Compatibility.Api21Impl
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class feedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feedback)

        // Get data from intent with null checks and logging
        val questionsArray = intent.getStringArrayExtra("questionsArray") ?: arrayOf()
        val answersArray = intent.getBooleanArrayExtra("answersArray") ?: booleanArrayOf()
        val userAnswersArray = intent.getBooleanArrayExtra("userAnswersArray") ?: booleanArrayOf()
        val score = intent.getIntExtra("score", 0)

        // Log the received data for debugging
        Log.d("FEEDBACK_DEBUG", "Questions: ${questionsArray.contentToString()}")
        Log.d("FEEDBACK_DEBUG", "Correct Answers: ${answersArray.contentToString()}")
        Log.d("FEEDBACK_DEBUG", "User Answers: ${userAnswersArray.contentToString()}")
        Log.d("FEEDBACK_DEBUG", "Score: $score"

        // View declarations
        val buttonExit = findViewById<Button>(R.id.buttonExit)
        val buttonReview = findViewById<Button>(R.id.buttonReview)
        val scoreView = findViewById<TextView>(R.id.scoreView)
        val FeedbackTable = findViewById<TableLayout>(R.id.FeedbackTable)

        // Set score text
        scoreView.text = "Score: $score/${questionsArray.size}"

        // Initialize all TextView arrays
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

        // Determine how many rows to show (minimum of all array sizes)
        val itemsToShow = minOf(
            questionsArray.size,
            answersArray.size,
            userAnswersArray.size,
            questionViews.size,
            answerViews.size,
            userAnswerViews.size
        )

        Log.d("FEEDBACK_DEBUG", "Items to show: $itemsToShow")

        // Populate the visible rows
        for (i in 0 until itemsToShow) {
            questionViews[i].text = questionsArray[i]
            answerViews[i].text = answersArray[i].toString()
            userAnswerViews[i].text = userAnswersArray[i].toString()

            // Make sure these rows are visible
            questionViews[i].visibility = View.VISIBLE
            answerViews[i].visibility = View.VISIBLE
            userAnswerViews[i].visibility = View.VISIBLE
        }

        // Hide any unused rows
        for (i in itemsToShow until questionViews.size) {
            // Get the parent TableRow and hide it
            (questionViews[i].parent as? View)?.visibility = View.GONE
        }



// Initially hide the table (will be shown when review button is clicked)
        FeedbackTable.visibility = View.GONE

        // Review button click handler
        buttonReview.setOnClickListener {
            Log.d("FEEDBACK_DEBUG", "Review button clicked")
            FeedbackTable.visibility = View.VISIBLE
        }

        // Exit button click handler
        buttonExit.setOnClickListener {
            Log.d("FEEDBACK_DEBUG", "Exit button clicked")
            finish()
        }
    }
}