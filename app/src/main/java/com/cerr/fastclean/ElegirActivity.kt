package com.cerr.fastclean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cerr.fastclean.databinding.EmpresasItemBinding
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference

class ElegirActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<Empresas>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elegir)
        userRecyclerview = findViewById(R.id.listEmpresas)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)
        userArrayList = arrayListOf<Empresas>()
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
                    userRecyclerview.adapter = MyAdapter(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}