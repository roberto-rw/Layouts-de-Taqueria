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

class CombinacionesActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combinaciones)

        agregarProductos()

        var listview: ListView = findViewById(R.id.listview) as ListView

        var adaptador : CombinacionesActivity.AdaptadorProductos =  CombinacionesActivity.AdaptadorProductos(this, menu)
        listview.adapter = adaptador

    }

    fun agregarProductos(){
        menu.add(Product("Traditional Taco Combo", R.drawable.combinationtaco, "Tortilla de Maiz, tu carne favorita, servido con arroz y frijoles Corn tortilla taco, your choice of meat, served with rice and beans", 6.99))
        menu.add(Product("Mexican Burritos", R.drawable.burritos, "Your choice of meat on a big burrito made of flour tortilla with rice, beans, lettuce, grilled onions, pico de gallo, guacamole and sour cream.", 11.99))
        menu.add(Product("Los Portales Burrito", R.drawable.burritosportales, "A flour tortilla wrapped around grilled cactus, steak, pastor, (Seasoned Pork) grilled onions, rice and beans. Served a side of lettuce salad, tomatoes, sour cream and guacamole.", 12.99))
        menu.add(Product("Cinco", R.drawable.cinco, "One hard sell taco with your choice of meat, lettuce and cheese. One burrito with your choice of meat, pico de gallo, sour cream, guacamole and beans. Served with rice and beans.", 7.99))
        menu.add(Product("Dos Amigos", R.drawable.dosamigos, "Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese. served with a side of rice and beans", 8.99))
        menu.add(Product("Burrito Pepe", R.drawable.burritopepe, "A flour tortilla wrapped around your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo. served with a side of rice.", 7.49))

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