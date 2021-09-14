package com.cerr.fastclean

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cerr.fastclean.databinding.EmpresasItemBinding
import com.google.firebase.database.*

class ElegirActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<Empresas>
    lateinit var emp : Array<String>

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elegir)
        userRecyclerview = findViewById(R.id.listEmpresas)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)
        userArrayList = arrayListOf<Empresas>()
        emp = arrayOf(
            getString(R.id.tvnombreEmpresa)
        )
        getEmpresaData()
    }

    private fun getEmpresaData() {
        dbref = FirebaseDatabase.getInstance().getReference("Empresas")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val empresaUser = userSnapshot.getValue(Empresas::class.java)
                        userArrayList.add(empresaUser!!)
                    }

                    var adapter = MyAdapter(userArrayList)
                    userRecyclerview.adapter = adapter
                    adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intencion = Intent(this@ElegirActivity, ServicioActivity::class.java)
                            intencion.putExtra("empresa", emp[position])
                            startActivity(intencion)
                        }
                    })
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}