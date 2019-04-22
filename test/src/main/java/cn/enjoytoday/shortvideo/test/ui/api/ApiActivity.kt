package cn.enjoytoday.shortvideo.test.ui.api

import android.graphics.BitmapFactory
import android.graphics.Paint
import android.os.Bundle
import android.view.SurfaceHolder
import androidx.lifecycle.Observer
import cn.enjoytoday.base.mvvm.BaseMvvmActivity
import cn.enjoytoday.shortvideo.test.R
import cn.enjoytoday.shortvideo.test.databinding.ActivityApiBinding
import cn.enjoytoday.shortvideo.test.ui.customsurface.CustomSurfaceActivity
import cn.enjoytoday.shortvideo.test.ui.customsurface.CustomerSurfaceView
import kotlinx.android.synthetic.main.activity_api.*
import me.jessyan.autosize.utils.LogUtils
import org.jetbrains.anko.startActivity
/**
 * 作者： hfcai
 * 时间： 19-4-18
 * 描述： 通过三种api绘制图片
 */
class ApiActivity :BaseMvvmActivity<ActivityApiBinding,ApiViewModel>(R.layout.activity_api){


    override fun observe(v: ApiViewModel) {

        v.apply {

            click.observe(this@ApiActivity, Observer {

                if (!it.hasBeenHandled){
                    when(it.peekContent()){

                        // 通过ImageView加载Image
                        R.id.imageViewBtn -> loadImageByImageView()
                        // 通过surfaceView加载
                        R.id.surfaceViewBtn -> loadImageBySurface()
                        // 通过Customer加载图片
                        R.id.customViewBtn -> loadImageByCustomer()
                        R.id.customSurfaceViewBtn -> this@ApiActivity.startActivity<CustomSurfaceActivity>()


                    }
                }
            })

        }
    }

    /**
     * 通过ImageView加载Image
     */

    private fun loadImageByImageView(){
        toImageView.setImageResource(R.drawable.wx_offical)
    }


    /**
     * 通过surfaceView加载
     */
    private fun loadImageBySurface(){
        LogUtils.e("loadImageBySurface")
        surfaceView.holder.addCallback(object : SurfaceHolder.Callback{
            override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
                LogUtils.e("surfaceCreated")
            }


            /**
             * surface销毁
             */
            override fun surfaceDestroyed(p0: SurfaceHolder?) {
            }


            /**
             * surfaceview绘制
             */
            override fun surfaceCreated(p0: SurfaceHolder?) {
                LogUtils.e("surfaceCreated")
                val paint = Paint()
                paint.isAntiAlias =true
                paint.style = Paint.Style.STROKE


                val bitmap = BitmapFactory.decodeResource(resources,R.drawable.wx_offical)
                val canvas = p0?.lockCanvas()
                canvas?.drawBitmap(bitmap,0f,0f,paint)
                p0?.unlockCanvasAndPost(canvas)

            }

        })
    }


    /**
     * 通过Customer加载图片
     */
    private fun loadImageByCustomer(){
        customView?.setImageResource(R.drawable.wx_offical)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadImageBySurface()
    }
}