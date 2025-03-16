package com.example.food2forkjetpackcomposekotlin

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation

class HorizontalDottedProgress : View {

    // Actual dot radius
    private var mDotRadius = 5

    // Bounced Dot Radius
    private var mBounceDotRadius = 8

    // To get identified in which position dot has to bounce
    private var mDotPosition = 0

    // Specify how many dots you need in a progress bar
    private var mDotAmount = 10

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    // Method to draw your customized dot on the canvas
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()

        // Set the color for the dot that you want to draw
        paint.color = Color.parseColor("#fd583f")

        // Function to create dot
        createDot(canvas, paint)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        // Animation called when attaching to the window, i.e., to your screen
        startAnimation()
    }

    private fun createDot(canvas: Canvas, paint: Paint) {
        // Here I have set the progress bar with 10 dots, so repeat and when i == mDotPosition then
        // increase the radius of dot i.e., mBounceDotRadius
        for (i in 0 until mDotAmount) {
            if (i == mDotPosition) {
                canvas.drawCircle(
                    10f + (i * 20),
                    mBounceDotRadius.toFloat(),
                    mBounceDotRadius.toFloat(),
                    paint
                )
            } else {
                canvas.drawCircle(
                    10f + (i * 20),
                    mBounceDotRadius.toFloat(),
                    mDotRadius.toFloat(),
                    paint
                )
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width: Int
        val height: Int

        // Calculate the view width
        val calculatedWidth = 20 * 9

        width = calculatedWidth
        height = mBounceDotRadius * 2

        // MUST CALL THIS
        setMeasuredDimension(width, height)
    }

    private fun startAnimation() {
        val bounceAnimation = BounceAnimation()
        bounceAnimation.duration = 100
        bounceAnimation.repeatCount = Animation.INFINITE
        bounceAnimation.interpolator = LinearInterpolator()
        bounceAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {}

            override fun onAnimationRepeat(animation: Animation) {
                mDotPosition++
                // When mDotPosition == mDotAmount, then start again applying animation from 0th position,
                // i.e., mDotPosition = 0;
                if (mDotPosition == mDotAmount) {
                    mDotPosition = 0
                }
                Log.d("INFOMETHOD", "----On Animation Repeat----")
            }
        })
        startAnimation(bounceAnimation)
    }

    private inner class BounceAnimation : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            super.applyTransformation(interpolatedTime, t)
            // Call invalidate to redraw your view again.
            invalidate()
        }
    }
}