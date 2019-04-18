package cn.enjoytoday.shortvideo.test.ui.api

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.annotation.DrawableRes
import cn.enjoytoday.shortvideo.test.R

/**
 * 作者： hfcai
 * 时间： 19-4-18
 * 描述：
 */
class CustomerImageView(context: Context,attributes: AttributeSet?,defStyleAttr:Int): View(context,attributes,defStyleAttr) {


    private var imageRes:Int = R.drawable.ic_back

    private var bitmap: Bitmap?=null

    private val paint = Paint()

    constructor(context: Context):this(context,null)

    constructor(context: Context,attributes: AttributeSet?):this(context,attributes,0)


    init {
        paint.isAntiAlias =true
        paint.style = Paint.Style.STROKE
    }



    fun setImageResource(@DrawableRes drawableRes: Int){
        this.imageRes = drawableRes
        postInvalidate()
    }


    override fun onDraw(canvas: Canvas){
        bitmap= BitmapFactory.decodeResource(resources,imageRes)
        if (bitmap!=null) {
            canvas.drawBitmap(bitmap, 0f, 0f, paint)
        }
    }



}