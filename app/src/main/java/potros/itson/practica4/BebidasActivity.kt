package potros.itson.practica4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class BebidasActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bebidas)

        agregarProductos()

        var listview: ListView = findViewById(R.id.listview) as ListView

        var adaptador : BebidasActivity.AdaptadorProductos = BebidasActivity.AdaptadorProductos(this, menu)
        listview.adapter = adaptador
    }

    fun agregarProductos(){
        menu.add(Product("Sodas 20oz", R.drawable.sodas, "", 2.99))
        menu.add(Product("Jarritos", R.drawable.jarritos, "", 2.35))
        menu.add(Product("Aguas Frescas", R.drawable.sodas, "", 2.99))
        menu.add(Product("Domestic Beer", R.drawable.domesticbeer, "", 3.55))
        menu.add(Product("Mexican Beer", R.drawable.mexicanbeer, "", 3.99))
        menu.add(Product("Micheladas", R.drawable.michelada,"", 6.75))
        menu.add(Product("Caguama", R.drawable.caguama,"", 8.99))
        menu.add(Product("Caguama Michelada", R.drawable.caguamamichelada,"", 10.99))
        menu.add(Product("Cubetazos", R.drawable.cubetazo,"", 21.99))
        menu.add(Product("Charolazo", R.drawable.charolazo,"", 15.75))
    }

    private class AdaptadorProductos: BaseAdapter {
        var productos= ArrayList<Product>()
        var contexto: Context?=null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.productos=productos
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflator= LayoutInflater.from(contexto)
            var vista = inflator.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}