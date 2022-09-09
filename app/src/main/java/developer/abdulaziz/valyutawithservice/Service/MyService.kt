package developer.abdulaziz.valyutawithservice.Service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import developer.abdulaziz.valyutawithservice.Class.MyCurrency
import developer.abdulaziz.valyutawithservice.MainActivity
import developer.abdulaziz.valyutawithservice.MyObject
import developer.abdulaziz.valyutawithservice.Retrofit.MyCommon
import developer.abdulaziz.valyutawithservice.Room.MyDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        getAllMovieList()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? = null

    private fun getAllMovieList() {
        MyCommon.retrofitService.getMovieList().enqueue(object : Callback<List<MyCurrency>> {
            override fun onFailure(call: Call<List<MyCurrency>>, t: Throwable) {
                Log.d("MyService", "onFailure: ${t.message}")
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<MyCurrency>>,
                response: Response<List<MyCurrency>>
            ) {
                Log.d("MyService", "onResponse: $response ${response.body()}")
                if (response.isSuccessful) {
                    val appDatabase = MyDatabase.getInstance(this@MyService)
                    val d = ArrayList<MyCurrency>()
                    d.addAll(appDatabase.myDao().read())
                    response.body()!!.forEach {
                        if (d.isEmpty()) appDatabase.myDao().create(it)
                        else appDatabase.myDao().update(it)
                    }
                    MainActivity().getAll(MyObject.binding!!, appDatabase)
                }
            }
        })
    }
}