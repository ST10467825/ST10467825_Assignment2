package vcmsa.ci.st10467825_assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

val questionsArray = arrayOf(
    "Cleopatra was Egyptian by birth.",
    "The Berlin Wall fell in the late 1980s.",
    "Julius Caesar was the first Roman Emperor.",
    "The Black Death occurred in the 14th century.",
    "Javascript was made before Java"
)

val answersArray = arrayOf(false, true, false, true, false)

val userAnswersArray = BooleanArray(5)

class flashcardQuestions : AppCompatActivity() {



    var score = 0
    var counter = 0
    var trueFalse = false
    var wasClicked = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard_questions)

        //Declarations
        val questionView = findViewById<TextView>(R.id.questionTextView)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val buttonTrue = findViewById<Button>(R.id.buttonTrue)
        val buttonFalse = findViewById<Button>(R.id.buttonFalse)

        questionView.text = questionsArray[counter]

        buttonFalse.setOnClickListener {
            trueFalse = false
            wasClicked = true
            buttonFalse.setBackgroundColor(Color.YELLOW)
        }
        buttonTrue.setOnClickListener {
            trueFalse = true
            wasClicked = true
            buttonTrue.setBackgroundColor(Color.YELLOW)
        }

        nextButton.setOnClickListener {
            if (!wasClicked) {
                Toast.makeText(this, "Please select an answer first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Record the user's answer
            userAnswersArray[counter] = trueFalse

            // Update score if correct
            if (userAnswersArray[counter] == answersArray[counter]) {
                score++
                scoreTextView.text = "Score: $score/${questionsArray.size}"
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }

            // Reset UI for next question
            wasClicked = false
            buttonTrue.setBackgroundColor(Color.CYAN)
            buttonFalse.setBackgroundColor(Color.CYAN)

            // Move to next question or go to results
            if (counter == questionsArray.size - 1) {
                // Ensure the last answer is recorded before proceeding
                val intent = Intent(this, feedback::class.java).apply {
                    putExtra("questionsArray", questionsArray)
                    putExtra("answersArray", answersArray)
                    putExtra("userAnswersArray", userAnswersArray)
                    putExtra("score", score)
                }
                startActivity(intent)
                finish()
            } else {
                counter++
                questionView.text = questionsArray[counter]
            }
        }
    }
}