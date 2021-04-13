package com.technipixl.evand1.exo3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : Activity(), View.OnClickListener {
    private var listItems = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (findViewById<View>(R.id.buttonNext) as Button).setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        fillData()
        updateUI()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    private fun fillData() {
        listItems.add("Item 1")
        listItems.add("item 2")
        listItems.add("Item 3")
        listItems.add("Item 4")
        listItems.add("Item 5")
    }

    private val stringData: String
        private get() {
            val builder = StringBuilder()
            for (item in listItems) {
                builder.append(item.trimIndent())
                builder.appendLine()
            }
            return builder.toString()
        }

    private fun updateUI() {
        (findViewById<View>(R.id.textViewItems) as TextView).text = stringData
    }

    private fun hideContentImageView() {
        (findViewById<View>(R.id.imageViewContent) as ImageView).visibility =
            View.INVISIBLE
    }

    override fun onClick(v: View) {
        val intentSecondActivity = Intent(this, SecondActivity::class.java)
        startActivity(intentSecondActivity)
    }
}