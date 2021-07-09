package re.etiennevaytilingom.patrickproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.json.responseJson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var idlivre = findViewById<EditText>(R.id.InputIdLivre)
        var btGet = findViewById<Button>(R.id.buttonGET)
        var auteur = findViewById<TextView>(R.id.textAuteur)
        var titre = findViewById<TextView>(R.id.textTitre)

        btGet.setOnClickListener {
            Fuel.get("https://module5.etienne-vaytilingom.re/livres/"+idlivre.text)
                .responseJson { request, response, result ->
                   // println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        val data = bytes.obj()
                        auteur.text = data["auteur"].toString()
                        titre.text = data["titre"].toString()
                    }
                }
        }

    }
}