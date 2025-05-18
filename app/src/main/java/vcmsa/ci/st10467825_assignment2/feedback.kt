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
import androidx.appcompat.resources.Compatibility.Api21Impl
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class feedback : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feedback)

        //Declarations
        val buttonExit = findViewById<Button>(R.id.buttonExit)
        val buttonReview = findViewById<Button>(R.id.buttonReview)
        val FeedbackTable = findViewById<TableLayout>(R.id.FeedbackTable)
        val scoreView = findViewById<TextView>(R.id.scoreView)

        val Q0 = findViewById<TextView>(R.id.Q0)
        val Q1 = findViewById<TextView>(R.id.Q1)
        val Q2 = findViewById<TextView>(R.id.Q2)
        val Q3 = findViewById<TextView>(R.id.Q3)
        val Q4 = findViewById<TextView>(R.id.Q4)

        val A0 = findViewById<TextView>(R.id.A0)
        val A1 = findViewById<TextView>(R.id.A1)
        val A2 = findViewById<TextView>(R.id.A2)
        val A3 = findViewById<TextView>(R.id.A3)
        val A4 = findViewById<TextView>(R.id.A4)

        val user0 = findViewById<TextView>(R.id.user0)
        val user1 = findViewById<TextView>(R.id.user1)
        val user2 = findViewById<TextView>(R.id.user2)
        val user3 = findViewById<TextView>(R.id.user3)
        val user4 = findViewById<TextView>(R.id.user4)

        // Populate values dynamically:
        //questionsArray?.forEachIndexed { index, question ->
       //     if (index < questionViews.size) questionViews[index].text = question
        //}


        val questionsArray = intent.getStringArrayExtra("questionsArray") ?: arrayOf()
        val answersArray = intent.getBooleanArrayExtra("answersArray") ?: booleanArrayOf()
        val userAnswersArray = intent.getBooleanArrayExtra("usersAnswerArray") ?: booleanArrayOf()



        buttonReview.setOnClickListener{
           FeedbackTable.visibility = View.VISIBLE
        }



        buttonExit.setOnClickListener {
            finish()
        }

        }
            //explicit intent
            //val intent = Intent(this, WelcomeActivity::class.java)
            //startActivity(intent)

    }
//}