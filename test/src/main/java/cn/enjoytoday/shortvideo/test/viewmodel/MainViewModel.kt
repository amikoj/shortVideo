package cn.enjoytoday.shortvideo.test.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.enjoytoday.base.Event
import cn.enjoytoday.base.base.BaseViewModel

/**
 * 作者： hfcai
 * 时间： 19-4-17
 * 描述：模拟请求
 */
class MainViewModel:BaseViewModel<Unit> (){


    private val _clicked = MutableLiveData<Event<Int>>()


    /**
     * 点击事件
     */
    val clicked: LiveData<Event<Int>>
        get() = _clicked

    fun onClick(view: View){
        _clicked.value = Event(view.id)
    }


}