package cn.enjoytoday.shortvideo.test.ui.customsurface

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceHolder.SURFACE_TYPE_NORMAL
import android.view.SurfaceView
import me.jessyan.autosize.utils.LogUtils
import java.lang.Exception

/**
 * 作者： hfcai
 * 时间： 19-4-22
 * 描述：自定义SurfaceView
 */
class CustomerSurfaceView(context: Context, attributes: AttributeSet?, defStyleAttr:Int)
    :SurfaceView(context,attributes,defStyleAttr), SurfaceHolder.Callback {

    var mIsDrawing = false
    var x =1
    var y = 0;
    private var mPath:Path?=null
    private var mPaint: Paint?=null
    var mCanvas:Canvas?=null

    /**
     * 图层改变，当Surface的状态（大小和格式）发生变化的时候会调用该函数，在surfaceCreated调用后该函数至少会被调用一次
     */
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    /**
     * 图层销毁,surfaceView隐藏前surface会被销毁
     */
    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        mIsDrawing =false

    }


    /**
     * 图层创建,surfaceView可见时surface会被创建
     * 创建后可以开始绘制surface界面
     *
     */
    override fun surfaceCreated(holder: SurfaceHolder?) {
        holder?.let {
            mIsDrawing =true
            SinThread().start()
//            mCanvas =   it.lockCanvas() //lockCanvas锁定整个画布，不缓存绘制，同步线程锁
//            mCanvas =it.lockCanvas(Rect(0,0,200,200)) //锁定指定位置画布,指定范围外的画布不重新绘制(缓存)
//            //解除线程锁,并提交绘制显示图像
//            it.unlockCanvasAndPost(mCanvas)
        }

    }

    /**
     * 构造方法
     */
    constructor(context: Context, attributes: AttributeSet?):this(context,attributes,-1)

    constructor(context: Context):this(context,null)



    init {
        //初始化操作

        holder.addCallback(this)
        isFocusable = true
        isFocusableInTouchMode = true
        keepScreenOn = true

    }


    /**
     * 刷新绘制
     */
    fun refreshSin(){
        SinThread().start()
    }


    fun cos(){
        CosThread().start()
    }


    /**
     * 正弦函数
     */
   inner class SinThread :Thread(){


        override fun run() {
            x =1
            y=0
            mPaint = Paint()
            mPaint?.strokeWidth=12f
            mPaint?.color = Color.BLUE
            mPath = Path()
            while (mIsDrawing) {
                try {

                    mCanvas = holder.lockCanvas()
                    mCanvas?.drawColor(Color.WHITE)
                    mCanvas?.drawPath(mPath, mPaint)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    if (mCanvas != null) {
                        holder?.unlockCanvasAndPost(mCanvas)
                    }
                }
                x+=1

                if (x<=width) {
                    y = (100*Math.sin(x*2*Math.PI/180)+400).toInt()
                    mPath?.lineTo(x.toFloat(),y.toFloat())
                }else{
                    break
                }

            }


        }
    }



    /**
     * 余弦函数
     */
    inner class CosThread :Thread(){


        override fun run() {
            x =1
            y=0
            mPaint = Paint()
            mPaint?.strokeWidth=12f
            mPaint?.color = Color.BLUE
            mPath = Path()
            while (mIsDrawing) {
                try {
                    mCanvas = holder.lockCanvas()
                    mCanvas?.drawColor(Color.WHITE)
                    mCanvas?.drawPath(mPath, mPaint)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    if (mCanvas != null) {
                        holder?.unlockCanvasAndPost(mCanvas)
                    }
                }
                x+=1
                if (x<=width) {
                    y = (100*Math.cos(x*2*Math.PI/180)+400).toInt()
                    mPath?.lineTo(x.toFloat(), y.toFloat())
                }else{
                    break
                }

            }


        }
    }






}