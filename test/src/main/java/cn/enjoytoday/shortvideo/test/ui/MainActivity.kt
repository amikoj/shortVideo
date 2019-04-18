package cn.enjoytoday.shortvideo.test.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import cn.enjoytoday.base.mvvm.BaseMvvmActivity
import cn.enjoytoday.shortvideo.test.R
import cn.enjoytoday.shortvideo.test.databinding.ActivityMainBinding
import cn.enjoytoday.shortvideo.test.ui.api.ApiActivity
import cn.enjoytoday.shortvideo.test.viewmodel.MainViewModel
import org.jetbrains.anko.startActivity

class MainActivity :
    BaseMvvmActivity<ActivityMainBinding,MainViewModel>(R.layout.activity_main){


    /**
     * 监听
     */
    override fun observe(v: MainViewModel) {
        v.apply {
            clicked.observe(this@MainActivity, Observer {

                if (!it.hasBeenHandled){
                    when(it.peekContent()){
                        R.id.api_test -> startActivity<ApiActivity>()


                    }

                }
            })

        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
