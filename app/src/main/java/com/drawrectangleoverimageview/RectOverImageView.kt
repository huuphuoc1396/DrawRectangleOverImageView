package com.drawrectangleoverimageview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class RectOverImageView : AppCompatImageView {

    constructor(context: Context) : super(context)

    constructor(
        context: Context,
        attrs: AttributeSet
    ) : super(context, attrs)

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr)

    private var _rect: Rect? = null

    var rect: Rect?
        get() = _rect
        set(value) {
            _rect = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawRect(canvas)
    }

    private fun drawRect(canvas: Canvas?) {
        _rect?.let {
            val paint = Paint()
            paint.color = RECT_COLOR
            paint.strokeWidth = RECT_STROKE_WIDTH
            paint.style = RECT_STYLE
            canvas?.drawRect(it, paint)
        }
    }

    companion object {
        private const val RECT_COLOR = Color.RED
        private const val RECT_STROKE_WIDTH = 8F

        private val RECT_STYLE = Paint.Style.STROKE
    }
}