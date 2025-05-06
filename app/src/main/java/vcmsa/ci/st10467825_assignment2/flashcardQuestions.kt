package vcmsa.ci.st10467825_assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class flashcardQuestions : AppCompatActivity() {

    val questionsArray = arrayOf("Is the sun blue?",
                            "Is Cyril Ramaphosa the president?",
                            "Is the ocean orange",
                            "Do Dogs bark?",
                            "Can humans fly of their own power?")

    val answersArray = arrayOf(false, true, false, true, false)

    val userAnswersArray = BooleanArray(5)

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
        val questionView = findViewById< TextView>(R.id.questionTextView)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val buttonTrue = findViewById<Button>(R.id.buttonTrue)
        val buttonFalse = findViewById<Button>(R.id.buttonFalse)

        questionView.text = questionsArray[counter]

        buttonFalse.setOnClickListener{
            trueFalse = false
            wasClicked = true
        }
        buttonTrue.setOnClickListener{
            trueFalse = true
            wasClicked = true
        }

        nextButton.setOnClickListener{
            if (wasClicked == true){
               userAnswersArray[counter] = trueFalse

                if(userAnswersArray[counter] == answersArray[counter]){
                    score++
                    scoreTextView.text = "your score here"
                }
                //update counter and question
                if (userAnswersArray[counter] == answersArray[counter]){
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                }

                //reset wasclicked
                wasClicked = false

                if(counter == questionsArray.size-1){
                    nextButton.text = "Go to Results"
                    nextButton.setOnClickListener{
                        val intent = Intent(this, feedback:: class.java)
                        intent.putExtra("questionsArray", questionsArray)
                        intent.putExtra("answersArray", answersArray)
                        intent.putExtra("userAnswersArray", userAnswersArray)

                        startActivity(intent)
                    }
                }
                counter++
                questionView.text = questionsArray[counter]

            }else{
                Toast.makeText(this, "You have not answered, idiot", Toast.LENGTH_SHORT).show()
            }



        }





    }
}