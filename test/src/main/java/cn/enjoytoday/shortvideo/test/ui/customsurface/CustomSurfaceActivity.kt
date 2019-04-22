package cn.enjoytoday.shortvideo.test.ui.customsurface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cn.enjoytoday.shortvideo.test.R
import kotlinx.android.synthetic.main.activity_custom_surface.*

/**
 * 自定义surfaceView
 *
 */
class CustomSurfaceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_surface)
    }


    /**
     * 点击事件监听
     */
    fun onClick(view: View){

        when(view.id){
            R.id.beginDraw -> customerSurfaceView.refreshSin()
            R.id.cosDraw -> customerSurfaceView.cos()
        }


    }
}
