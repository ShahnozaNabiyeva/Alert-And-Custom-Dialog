package com.shahnoza.alertvacustomdialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btn1:Button
    lateinit var btn2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    btn1=findViewById(R.id.btnAletDialog)
    btn2=findViewById(R.id.btnCustomAlertDialog)




        btn1.setOnClickListener {
         val alertDialog=AlertDialog.Builder(this)
         alertDialog.setPositiveButton("HA",object :DialogInterface.OnClickListener{
             override fun onClick(dialog: DialogInterface?, which: Int) {
                 Toast.makeText(this@MainActivity, "O'chirildi", Toast.LENGTH_SHORT).show()
             }
         })

            alertDialog.setNegativeButton("YO'Q",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "BEKOR QILINDI!", Toast.LENGTH_SHORT).show()
                }

            })

            alertDialog.setTitle("O'chirish")
            alertDialog.setMessage("Ushbu ma'lumotlarni o'chirmoqchimisiz?")
            alertDialog.show()
            alertDialog.setCancelable(false)

        }


        btn2.setOnClickListener {

            val customDialog=AlertDialog.Builder(this)
            val view=LayoutInflater.from(this).inflate(R.layout.item_dialog,null)
            customDialog.setView(view)
            customDialog.show()


            view.findViewById<Button>(R.id.btnCancel).setOnClickListener {
                Toast.makeText(this, "Bekor qilindi!", Toast.LENGTH_SHORT).show()
            }
            view.findViewById<Button>(R.id.btnDelete).setOnClickListener {
                Toast.makeText(this, "O'chirildi!", Toast.LENGTH_SHORT).show()
            }

        }


    }
}