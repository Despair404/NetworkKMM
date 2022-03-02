package com.example.networkkmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.networkkmm.Character
import com.example.networkkmm.Greeting
import com.example.networkkmm.IPresenter
import com.example.networkkmm.IView
import com.example.networkkmm.Presenter
import com.squareup.picasso.Picasso

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity(), IView {

    private val presenter:IPresenter = Presenter(this)
    private lateinit var tvName: TextView
    private lateinit var tvBirthday: TextView
    private lateinit var tvStatus: TextView
    private lateinit var tvNickname: TextView
    private lateinit var tvPortrayed: TextView
    private lateinit var imvPhoto: ImageView
    private lateinit var etName: EditText
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnGet)
        tvName = findViewById(R.id.tvName)
        tvBirthday = findViewById(R.id.tvBirthday)
        tvStatus = findViewById(R.id.tvStatus)
        tvNickname = findViewById(R.id.tvNickname)
        tvPortrayed = findViewById(R.id.tvPortrayed)
        imvPhoto = findViewById(R.id.imvPhoto)
        etName = findViewById(R.id.etName)

        button.setOnClickListener {
            val name = etName.text.toString()
            presenter.onButtonClick(name)
        }
    }

    override fun showResult(result: ArrayList<Character>) {
        val character = result[0]
        tvName.text = character.name
        tvBirthday.text = character.birthday
        tvStatus.text = character.status
        tvNickname.text = character.nickname
        tvPortrayed.text = character.portrayed
        Picasso.with(this)
            .load(character.img)
            .into(imvPhoto)
    }
}
