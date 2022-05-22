package com.example.chapter4_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var batukiri : ImageView
    lateinit var batukanan : ImageView
    lateinit var guntingkiri : ImageView
    lateinit var guntingkanan : ImageView
    lateinit var kertaskanan : ImageView
    lateinit var kertaskiri : ImageView
    lateinit var hasilsuit : ImageView

    var player1 = -1
    var com = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batukiri = findViewById<ImageView>(R.id.img_batukiri)
        batukanan = findViewById<ImageView>(R.id.img_batukanan)
        guntingkiri = findViewById<ImageView>(R.id.img_guntingkiri)
        guntingkanan = findViewById<ImageView>(R.id.img_guntingkanan)
        kertaskiri = findViewById<ImageView>(R.id.img_kertaskiri)
        kertaskanan = findViewById<ImageView>(R.id.img_kertaskanan)

        hasilsuit = findViewById<ImageView>(R.id.view_result)

        val reset = findViewById<ImageView>(R.id.img_refresh)




        batukiri.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Batu Kiri")
            selectViewPlayer1(batukiri,0)
        }

        guntingkiri.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Gunting Kiri")
            selectViewPlayer1(guntingkiri,1)
        }

        kertaskiri.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Kertas Kiri")
            selectViewPlayer1(kertaskiri,2)
        }
        batukanan.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Batu Kanan")
            selectViewCom(batukanan,0)
        }

        guntingkanan.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Gunting Kanan")
            selectViewCom(guntingkanan,1)
        }

        kertaskanan.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Kertas Kanan")
            selectViewCom(kertaskanan, 2)
        }

        reset.setOnClickListener {
            clearViewPlayer1()
            clearViewCom()
        }
    }

    private fun selectViewPlayer1(view: ImageView, pilihan : Int) {
        player1 = pilihan
        clearViewPlayer1()
        view.resources.getColor(R.color.black)
        hasilsuit()
    }

    private fun selectViewCom(view: ImageView, pilihan : Int) {
        com = pilihan
        clearViewCom()
        view.resources.getColor(R.color.black)
        hasilsuit()
    }

    private fun clearViewPlayer1() {
        batukiri.setBackgroundColor(0)
        guntingkiri.setBackgroundColor(0)
        kertaskiri.setBackgroundColor(0)
    }

    private fun clearViewCom() {
        batukanan.setBackgroundColor(0)
        guntingkanan.setBackgroundColor(0)
        kertaskanan.setBackgroundColor(0)
    }

    private fun hasilsuit() {
        if(player1 >= 0 && com >= 0) {
            if (player1 == 1 && com == 2 || player1 == 2 && com == 1) {
                    hasilsuit.setImageResource(R.drawable.ic_gunting)
            } else if (player1 == 1 && com == 0 || player1 == 0 && com == 1) {
                hasilsuit.setImageResource(R.drawable.ic_batu)
            } else if (player1 == 2 && com == 2 || player1 == 1 && com == 1 || player1 == 0 && com == 0) {
                hasilsuit.setImageResource(R.drawable.ic_batu)
            } else if (player1 == 2 && com == 0 || player1 == 0 && com == 2) {
                hasilsuit.setImageResource(R.drawable.ic_kertas)
            }
        }
    }
}
