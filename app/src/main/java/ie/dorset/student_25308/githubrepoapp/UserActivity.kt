package ie.dorset.student_25308.githubrepoapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.second_activity.*
import okhttp3.*
import java.io.IOException
import java.text.DecimalFormat
import kotlin.math.pow


const val USER_ACT_KEY = "Github User"


class UserActivity : AppCompatActivity() {
 private val picasso = Picasso.get()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)


        // variables

        val avatarImg = findViewById<ImageView>(R.id.imageView_avatar)
        val userName = findViewById<TextView>(R.id.name_main)
        val login = findViewById<TextView>(R.id.user_name)
        val followers = findViewById<TextView>(R.id.followers)
        val following = findViewById<TextView>(R.id.following)
        val company = findViewById<TextView>(R.id.organization_textView)
        val location = findViewById<TextView>(R.id.location)


        recyclerView_main.layoutManager = LinearLayoutManager(this)


        // get user input
        val userInput = intent.getStringExtra("User name")
        val urlRepo = "https://api.github.com/users/$userInput/repos"
        val urlUser = "https://api.github.com/users/$userInput"










        // create OkHTTP Client
        val clientUser = OkHttpClient()
        val requestUser = Request.Builder().url(urlUser).build()

        clientUser.newCall(requestUser).enqueue(object : Callback {
            var mainHandler = Handler(this@UserActivity.getMainLooper())
            override fun onFailure(call: Call, e: IOException) {
                Log.e(USER_ACT_KEY, "Exception: $e")
               // avatarImg.setImageResource(R.drawable.ic_baseline_error_outline_24)
               // userName.setText("User doesn't exist")
                //userName.setTextColor(Color.RED)
            }

            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    mainHandler.post{
                        val body = response.body?.string()
                        val gson = GsonBuilder().create()
                        val userInfo = gson.fromJson(body,UserInfo::class.java)
                        println(userInfo)

                        userName.text = userInfo.name
                        login.text = userInfo.login
                        followers.text= prettyCount(userInfo.followers)
                        following.text= prettyCount(userInfo.following)
                        company.text= userInfo.company
                        location.text= userInfo.location
                        val imageUrl = userInfo.avatar_url
                        Picasso.get().load(imageUrl).placeholder(getDrawable(R.drawable.ic_baseline_error_outline_24)!!).error(
                            getDrawable( R.drawable.ic_baseline_error_outline_24)!!).memoryPolicy(
                            MemoryPolicy.NO_CACHE).into(avatarImg)
                    }




                }else{
                    userName.setText("User doesn't exist")
                    userName.setTextColor(Color.RED)


                }

            }

        })








        // create OkHTTP Client
        val clientRecycler = OkHttpClient()
        val requestRecyler= Request.Builder().url(urlRepo).build()

        clientRecycler.newCall(requestRecyler).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
               // imageView_avatar.setImageResource(R.drawable.ic_baseline_error_outline_24)
                Log.e(USER_ACT_KEY, "Exception: $e")
                }
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val myResponse = response.body?.string()
                    println(myResponse)
                   val gson= Gson()
                    val info = gson.fromJson(myResponse, Array<Repo>::class.java)
                    info.forEach { Log.i(USER_ACT_KEY, it.toString()) }


                    Handler(Looper.getMainLooper()).post {
                        val mainAdapter = MainAdapter(info)
                        recyclerView_main.adapter = mainAdapter
                    }

                }
            }

        })


    }

    fun prettyCount(number: Number): String? {
        val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        val numValue = number.toLong()
        val value = Math.floor(Math.log10(numValue.toDouble())).toInt()
        val base = value / 3
        return if (value >= 3 && base < suffix.size) {
            DecimalFormat("#0.0").format(
                numValue / 10.0.pow((base * 3).toDouble())
            ) + suffix[base]
        } else {
            DecimalFormat("#,##0").format(numValue)
        }
    }

}



















