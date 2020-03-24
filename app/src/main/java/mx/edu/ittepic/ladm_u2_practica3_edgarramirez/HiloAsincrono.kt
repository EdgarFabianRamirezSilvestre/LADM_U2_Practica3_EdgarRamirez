package mx.edu.ittepic.ladm_u2_practica3_edgarramirez

import android.os.AsyncTask

import kotlinx.android.synthetic.main.activity_main.*

class HiloAsincrono(p: MainActivity) : AsyncTask<Int, String, Int>() {
    var puntero = p
    override fun onPreExecute() {
        super.onPreExecute()

    }//onPreExecute
    override fun doInBackground(vararg params: Int?): Int {
        publishProgress(params[0].toString())
        return params[0]!!
    }//doInBackground

    override fun onProgressUpdate(vararg values: String?) {
        super.onProgressUpdate(*values)

        if(values[0].toString()=="1"){
            puntero.image1.setImageResource(R.drawable.jugadoron)
            puntero.estado1.setText("Jugando")
            puntero.estado2.setText("En espera")
            puntero.estado3.setText("En espera")
            puntero.estado4.setText("En espera")
            puntero.image2.setImageResource(R.drawable.jugadoroff)
            puntero.image3.setImageResource(R.drawable.jugadoroff)
            puntero.image4.setImageResource(R.drawable.jugadoroff)
        }//if

        if(values[0].toString()=="2"){
            puntero.image2.setImageResource(R.drawable.jugadoron)
            puntero.estado2.setText("Jugando")
            puntero.estado1.setText("En espera")
            puntero.estado3.setText("En espera")
            puntero.estado4.setText("En espera")
            puntero.image1.setImageResource(R.drawable.jugadoroff)
            puntero.image3.setImageResource(R.drawable.jugadoroff)
            puntero.image4.setImageResource(R.drawable.jugadoroff)
        }//if

        if(values[0].toString()=="3"){
            puntero.image3.setImageResource(R.drawable.jugadoron)
            puntero.estado3.setText("Jugando")
            puntero.estado1.setText("En espera")
            puntero.estado2.setText("En espera")
            puntero.estado4.setText("En espera")
            puntero.image1.setImageResource(R.drawable.jugadoroff)
            puntero.image2.setImageResource(R.drawable.jugadoroff)
            puntero.image4.setImageResource(R.drawable.jugadoroff)
        }//if

        if(values[0].toString()=="4"){
            puntero.image4.setImageResource(R.drawable.jugadoron)
            puntero.estado4.setText("Jugando")
            puntero.estado1.setText("En espera")
            puntero.estado2.setText("En espera")
            puntero.estado3.setText("En espera")
            puntero.image1.setImageResource(R.drawable.jugadoroff)
            puntero.image2.setImageResource(R.drawable.jugadoroff)
            puntero.image3.setImageResource(R.drawable.jugadoroff)
        }//if
    }//onProgressUpdate

    override fun onPostExecute(result: Int?) {

        super.onPostExecute(result)
        if(result==1){
            puntero.txtturno.setText("Turno: "+(puntero.titulo))
            puntero.titulo++
            puntero.valorDados()
            puntero.puntos1.setText((puntero.puntos1.text.toString().toInt() + puntero.sumDados).toString())
            puntero.pJ1=puntero.puntos1.text.toString().toInt()


        }//if

        if(result==2){
            puntero.valorDados()
            puntero.puntos2.setText((puntero.puntos2.text.toString().toInt() + puntero.sumDados).toString())
            puntero.pJ2=puntero.puntos2.text.toString().toInt()
        }//if

        if(result==3){
            puntero.valorDados()
            puntero.puntos3.setText((puntero.puntos3.text.toString().toInt() + puntero.sumDados).toString())
            puntero.pJ3=puntero.puntos3.text.toString().toInt()

        }//if

        if(result==4){
            puntero.valorDados()
            puntero.puntos4.setText((puntero.puntos4.text.toString().toInt() + puntero.sumDados).toString())
            puntero.pJ4=puntero.puntos4.text.toString().toInt()

            if(puntero.titulo>4){

                puntero.ganador.add(puntero.pJ1)
                puntero.ganador.add(puntero.pJ2)
                puntero.ganador.add(puntero.pJ3)
                puntero.ganador.add(puntero.pJ4)
                puntero.image1.setImageResource(R.drawable.jugadoroff)
                puntero.image2.setImageResource(R.drawable.jugadoroff)
                puntero.image3.setImageResource(R.drawable.jugadoroff)
                puntero.image4.setImageResource(R.drawable.jugadoroff)
                puntero.estado1.setText("Terminado")
                puntero.estado2.setText("Terminado")
                puntero.estado3.setText("Terminado")
                puntero.estado4.setText("Terminado")
                puntero.eleccionGanador()
            }//if
        }//if

        Thread.sleep(1000)
    }//onPostExecute
}//class