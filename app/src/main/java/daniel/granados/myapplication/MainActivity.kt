package daniel.granados.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtNombre = findViewById<TextView>(R.id.txtNombre)
        val txtCorreo = findViewById<TextView>(R.id.txtCorreo)
        val txtClave = findViewById<TextView>(R.id.txtClave)
        val txtEdad = findViewById<TextView>(R.id.txtEdad)
        val txtDUI = findViewById<TextView>(R.id.txtDUI)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        btnAgregar.setOnClickListener {
            //Validamos que no estén vacíos
            if (txtNombre.text.isEmpty() || txtCorreo.text.isEmpty() || txtClave.text.isEmpty() || txtEdad.text.isEmpty() || txtDUI.text.isEmpty()) {
                Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show()
            }
            else{
                if(!txtEdad.text.matches("[0-9]+".toRegex())){
                    Toast.makeText(this, "Ingrese solo números", Toast.LENGTH_SHORT).show()
                }
                else{
                    if(!txtCorreo.text.matches("[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+".toRegex())){
                        Toast.makeText(this, "Ingrese correo válido", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        if (txtClave.text.length < 6){
                            Toast.makeText(this, "La clave debe contener más de 6 dígitos", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        }
    }
}