package cn.enjoytoday.base.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import cn.enjoytoday.base.ViewModelFactory
import cn.enjoytoday.base.data.BaseRepository
import cn.enjoytoday.base.data.remote.RetrofitFactory
import java.lang.reflect.ParameterizedType

abstract class BaseViewModel<T> : ViewModel() {

    /**
     * 网络请求泛型占位符
     */
    private  val tClass:Class<T>?
    val resp: BaseRepository = ViewModelFactory.getInstance().repository
    init {
        val type = javaClass.genericSuperclass
        val types = (type as ParameterizedType).actualTypeArguments
        tClass = types[0] as Class<T>
    }

    /**
     * 网络请求api
     */
    val api:T? by lazy {
        tClass?.let {
            RetrofitFactory.instance.create(tClass)
        }
    }

    companion object {

        @BindingAdapter("app:imageUrl")
        @JvmStatic
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView.context).load(url).into(imageView)
        }

    }


}