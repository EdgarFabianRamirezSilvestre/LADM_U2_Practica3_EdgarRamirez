package mx.edu.ittepic.ladm_u2_practica3_edgarramirez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var dados = arrayOf(
        R.drawable.dado1,
        R.drawable.dado2,
        R.drawable.dado3,
        R.drawable.dado4,
        R.drawable.dado5,
        R.drawable.dado6
    )

    var sumDados=0
    var lanzamiento=0
    var turno=1
    var titulo=1
    var pJ1 = 0
    var pJ2 = 0
    var pJ3 = 0
    var pJ4 = 0
    var ganador=ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciar.setOnClickListener {

            while (turno<5){
                while (lanzamiento<5){
                    var hiloAsincrono = HiloAsincrono(this)
                    hiloAsincrono.execute(lanzamiento, lanzamiento, lanzamiento)
                    lanzamiento++
                }//while

                turno++
                lanzamiento=1

            }//while

        }//seOnClickListener
    }//onCreate

    fun valorDados() {
        var d1 = (0..5).random()
        var d2 = (0..5).random()
        dado1.setImageResource(dados[d1])
        dado2.setImageResource(dados[d2])
        sumDados = (d1 + d2) + 2

    }//valorDados

    fun eleccionGanador(){
        if(ganador[0]==ganador.max()){
            Mensaje("JUGADOR 1")
        }//if
        if(ganador[1]==ganador.max()){
            Mensaje("JUGADOR 2")
        }//if
        if(ganador[2]==ganador.max()){
            Mensaje("JUGADOR 3")
        }//if
        if(ganador[3]==ganador.max()){
            Mensaje("JUGADOR 4")
        }//if

    }//eleccionGanador

    private fun Mensaje(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("GANADOR")
            .setPositiveButton("OK"){d,i->}
            .show()
    }//mensaje


}//main