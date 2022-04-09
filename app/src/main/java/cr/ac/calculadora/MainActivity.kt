package cr.ac.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression

    var dis : TextView ?= null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dis = findViewById(R.id.dis)
    }

    fun crearExprecion(texto: View){
        val button = texto as Button
        val textoButton = button.text.toString()
        if(dis?.text.toString() == "0" || dis?.text.toString() == "0.0"){
            dis?.text = ""
        }else{
            dis?.text = dis?.text.toString()
        }
        var concatenate = dis?.text.toString() + textoButton
        dis?.text =  concatenate


    }

    fun restart(texto: View){
        dis?.text = "0"
    }

    fun signo(texto: View){
        var expression = Expression(dis?.text.toString() + " * -1")
        dis?.text = expression.calculate().toString()
    }

    fun igual(texto: View){
        var resultado = Expression(dis?.text.toString())
        dis?.text = resultado.calculate().toString()
    }

    fun porcentaje(texto: View){
        var resultado = Expression(dis?.text.toString() + " / 100")
        dis?.text = resultado.calculate().toString()
    }
}