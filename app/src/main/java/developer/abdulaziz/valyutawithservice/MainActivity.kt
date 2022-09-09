package developer.abdulaziz.valyutawithservice

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import developer.abdulaziz.valyutawithservice.Adapters.MyRvAdapter
import developer.abdulaziz.valyutawithservice.Class.MyCurrency
import developer.abdulaziz.valyutawithservice.Room.MyDatabase
import developer.abdulaziz.valyutawithservice.Service.MyService
import developer.abdulaziz.valyutawithservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyObject.binding = binding
        startService(Intent(this, MyService::class.java))
    }

    fun getAll(binding: ActivityMainBinding, myDatabase: MyDatabase) {
        val list = ArrayList<MyCurrency>()
        list.addAll(myDatabase.myDao().read())
        val adapter = MyRvAdapter(
            list,
            object : MyRvAdapter.MyClick {
                @SuppressLint("SetTextI18n")
                override fun onClick(myCurrency: MyCurrency, pos: Int) {
                    binding.linear.visibility = View.VISIBLE
                    binding.cancel.setOnClickListener { binding.linear.visibility = View.GONE }
                    binding.about.text = "Id: ${list[pos].id}" + "\n" +
                            "Code: ${list[pos].Code}" + "\n" +
                            "Ccy: ${list[pos].Ccy}" + "\n" +
                            "CcyNm_RU: ${list[pos].CcyNm_RU}" + "\n" +
                            "CcyNm_UZ: ${list[pos].CcyNm_UZ}" + "\n" +
                            "CcyNm_UZC: ${list[pos].CcyNm_UZC}" + "\n" +
                            "CcyNm_EN: ${list[pos].CcyNm_EN}" + "\n" +
                            "Nominal: ${list[pos].Nominal}" + "\n" +
                            "Rate: ${list[pos].Rate} so'm" + "\n" +
                            "Diff: ${list[pos].Diff}" + "\n" +
                            "Date: ${list[pos].Date}"
                }
            })
        binding.rv.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}