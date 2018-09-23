package com.setyo.kotlin.latihanrecyclerview

import android.content.Context
import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*


class DetailFootballClub : AppCompatActivity() {
    var nama: String = ""
    private var deskripsi: String = ""
    lateinit var img : ImageView
    var gambar : Int = 0
    lateinit var tvNama: TextView
    lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)
            gravity = Gravity.CENTER

            img =imageView(R.drawable.abc_ab_share_pack_mtrl_alpha) {
            }.lparams{
                width = dip(100)
                height = dip(100)
            }


            tvNama = textView().lparams { topMargin = dip(16) }

            tvInfo = textView(){
                textColor = Color.BLACK
                textSize = 16f
                topPadding = dip(30)
            }

        }

        val intent = intent
        nama = intent.getStringExtra("nama")
        gambar = intent.getIntExtra("gambar",0)
        deskripsi = intent.getStringExtra("deskripsi")
        tvNama.text = nama
        tvInfo.text = deskripsi

        Glide.with(applicationContext).load(gambar).into(img)


    }


}