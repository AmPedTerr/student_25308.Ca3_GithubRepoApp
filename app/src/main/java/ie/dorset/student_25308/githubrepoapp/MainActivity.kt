package ie.dorset.student_25308.githubrepoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*


const val MAIN_ACT_KEY = "mainAct"
const val NOTIFICATION_CHANNEL_ID = "General"
const val POST_INDEX = "PostIndex"


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val  radioGroup =findViewById<RadioGroup>(R.id.radioGroup)
        val textView = findViewById<TextView>(R.id.selection_name)
       val button_getRepo = findViewById<Button>(R.id.button)
        val inputUser =findViewById<EditText>(R.id.editText_input)
        val textView2=findViewById<TextView>(R.id.user_name)


    radioGroup.setOnCheckedChangeListener { radioGroup, i ->
        findViewById<RadioButton>(i)?.apply {
            textView.text= "Enter the "+text
        }
    }



    button_getRepo.setOnClickListener {
       var user = inputUser.text.toString()
        val intent = Intent(this, UserActivity::class.java)
       intent.putExtra("User name", user)
        startActivity(intent)
       // textView2.text= user
    }



    }

    override fun onStart() {
        super.onStart()
        Log.i(MAIN_ACT_KEY, "onStart called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(MAIN_ACT_KEY, "onPause called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(MAIN_ACT_KEY, "onResume called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(MAIN_ACT_KEY, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MAIN_ACT_KEY, "onDestroy called")
    }

}




