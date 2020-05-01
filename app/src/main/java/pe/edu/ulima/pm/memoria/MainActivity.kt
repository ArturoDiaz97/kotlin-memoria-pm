package pe.edu.ulima.pm.memoria

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.graphics.drawable.DrawableCompat

class MainActivity : AppCompatActivity() {
    var p_boton: Button? = null
    var p_text:String = ""

    var s_boton: Button? = null
    var s_text:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initGame()
    }

    fun initGame() {
        val emojis: List<String> = listOf(
            "\uD83D\uDE00",
            "\uD83D\uDE03",
            "\uD83D\uDE04",
            "\uD83D\uDE01",
            "\uD83D\uDE06",
            "\uD83D\uDE05",
            "\uD83D\uDC7D",
            "\uD83D\uDC7E",
            "\uD83D\uDC7B",
            "\uD83D\uDCA9",
            "\uD83D\uDC4D",
            "\uD83D\uDE4D",
            "\uD83C\uDF66",
            "\uD83C\uDF70",
            "\uD83C\uDF7A",
            "\uD83C\uDF0D",
            "\uD83C\uDFD8"
        ).shuffled().take(6)

        val colors: List<String> = listOf( "#EDB458", "#80CED7", "#6EEB83", "#D7263D")

        val randomEmojis: List<String> = (emojis + emojis).shuffled()

        val randomColor: String = colors.shuffled().take(1)[0]

        val buttons: Array<Button> = arrayOf(
            findViewById(R.id.but1),
            findViewById(R.id.but2),
            findViewById(R.id.but3),
            findViewById(R.id.but4),
            findViewById(R.id.but5),
            findViewById(R.id.but6),
            findViewById(R.id.but7),
            findViewById(R.id.but8),
            findViewById(R.id.but9),
            findViewById(R.id.but10),
            findViewById(R.id.but11),
            findViewById(R.id.but12)
        )

        buttons.forEachIndexed { index, but ->
            but.text = randomEmojis[index]
            val background = but.background as RippleDrawable
            val backgroundGradient = background.findDrawableByLayerId(R.id.item_shape) as GradientDrawable
            backgroundGradient.setColor(Color.parseColor(randomColor))
        }
    }

    fun BotonClick(view: View) {
        val but: Button = view as Button
        if (but.textSize == 0F){
            but.setTextSize(40F)
        }
        else{
            but.setTextSize(0F)
        }

        if(p_text == "") {
            p_text = but.text as String
            p_boton = but
            p_boton?.isClickable = false
        }else if(s_text == ""){
            s_text = but.text as String
            s_boton = but
        }

        if (s_text !== "" && p_text!==""){
            comparar()
        }

    }

    fun comparar(){
            Log.i("memoria", "entro")
            if (p_text == s_text) {
                s_boton?.isClickable = false
            } else {
                s_boton?.setTextSize(0f)
                p_boton?.setTextSize(0f)
                p_boton?.isClickable = true
                p_boton = null
                s_boton = null
                s_text = ""
                p_text = ""
            }

    }



}
