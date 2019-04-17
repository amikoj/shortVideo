package cn.enjoytoday.shortvideo.test

import android.os.Bundle
import androidx.lifecycle.Observer
import cn.enjoytoday.base.mvvm.BaseMvvmActivity
import cn.enjoytoday.shortvideo.test.databinding.ActivityMainBinding
import cn.enjoytoday.shortvideo.test.viewmodel.MainViewModel

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
                        R.id.api_test -> {
                            //api操作
                        }


                    }

                }
            })

        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
