package cn.enjoytoday.shortvideo.test.ui.api

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.enjoytoday.base.Event
import cn.enjoytoday.base.base.BaseViewModel

/**
 * 作者： hfcai
 * 时间： 19-4-18
 * 描述：
 */
class ApiViewModel:BaseViewModel<Unit>() {




    private val _click = MutableLiveData<Event<Int>>()

    val click:LiveData<Event<Int>>
        get() = _click



    fun onClick(view: View){
        _click.value = Event(view.id)
    }



}