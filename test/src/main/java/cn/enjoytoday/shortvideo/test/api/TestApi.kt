package cn.enjoytoday.shortvideo.test.api

import cn.enjoytoday.base.data.remote.BaseResp
import cn.enjoytoday.base.liveData.CallAdapterLiveData
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 作者： hfcai
 * 时间： 19-4-17
 * 描述：
 */
interface TestApi {

    @POST("/test/request")
    fun testReqeust(@Body request: TestRequest): CallAdapterLiveData<BaseResp<TestResponse>>

}

/**
 * 模拟请求
 */
data class TestRequest(val token:String?="")


/**
 * 模拟请求返回参数
 */
data class TestResponse(val info:String?="")