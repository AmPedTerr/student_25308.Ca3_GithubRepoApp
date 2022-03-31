package ie.dorset.student_25308.githubrepoapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_template.view.*
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

class MainAdapter (private val info : Array<Repo>): RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {


    override fun getItemCount(): Int {
        return info.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val repoRow = layoutInflater.inflate(R.layout.recycler_template, parent, false)
        return CustomViewHolder(repoRow)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {


        //  val repoTitle= repoTitles.get(position)
        val repo = info[position]
        holder.itemView.findViewById<TextView>(R.id.repo_title).text = repo.name
        holder.itemView.findViewById<TextView>(R.id.repo_description).text = repo.description
        holder.itemView.findViewById<TextView>(R.id.repo_language).text = repo.language
        holder.itemView.findViewById<TextView>(R.id.repo_watchers_count).text = prettyCount(repo.watchers_count)
        holder.itemView.findViewById<TextView>(R.id.repor_forks_count).text = prettyCount(repo.forks_count)


       val languageCircle = holder.itemView.findViewById<TextView>(R.id.imageView_language)

        if (repo.language == "C") {

            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.SRC_IN);

        } else if (repo.language== "C++") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#FF00FF"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "Kotlin") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#00FF00"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "HTML") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#800080"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "JavaScript") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "Java") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#FF0000"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "Shell") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#E833845"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "PHP") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#33FFDA"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "Go") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#4F33FF"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "TypeScript") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#161420"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "Python") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#E355A0"), PorterDuff.Mode.SRC_IN);
        }else if (repo.language== "Ruby") {
            (languageCircle.getBackground()).setColorFilter(Color.parseColor("#8F1818"), PorterDuff.Mode.SRC_IN);
        }




    }


class CustomViewHolder(val view : View): RecyclerView.ViewHolder(view)


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