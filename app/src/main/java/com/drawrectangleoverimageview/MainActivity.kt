package com.drawrectangleoverimageview

import android.app.Activity
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.bottomEdit
import kotlinx.android.synthetic.main.activity_main.drawButton
import kotlinx.android.synthetic.main.activity_main.image
import kotlinx.android.synthetic.main.activity_main.leftEdit
import kotlinx.android.synthetic.main.activity_main.rightEdit
import kotlinx.android.synthetic.main.activity_main.topEdit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this)
            .load(DEMO_IMAGE_URL)
            .into(image)

        drawButton.setOnClickListener {

            hideKeyboard()

            val leftX = leftEdit.text.toString().toInt()

            val topY = topEdit.text.toString().toInt()

            val rightX = rightEdit.text.toString().toInt()

            val bottomY = bottomEdit.text.toString().toInt()

            val rect = Rect(leftX, topY, rightX, bottomY)
            image.rect = rect
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    companion object {
        const val DEMO_IMAGE_URL =
            "https://www.vietnam-briefing.com/news/wp-content/uploads/2019/04/VB-mag-image-1.jpg"
    }
}
