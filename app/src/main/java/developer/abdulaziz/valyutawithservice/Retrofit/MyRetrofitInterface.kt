package developer.abdulaziz.valyutawithservice.Retrofit

import developer.abdulaziz.valyutawithservice.Class.MyCurrency
import retrofit2.Call
import retrofit2.http.GET

interface MyRetrofitInterface {
    @GET("json")
    fun getMovieList(): Call<List<MyCurrency>>
}