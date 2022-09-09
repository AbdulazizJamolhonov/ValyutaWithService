package developer.abdulaziz.valyutawithservice.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulaziz.valyutawithservice.Class.MyCurrency
import developer.abdulaziz.valyutawithservice.databinding.ItemRvBinding

class MyRvAdapter(
    private val list: ArrayList<MyCurrency>,
    private val myClick: MyClick
) :
    RecyclerView.Adapter<MyRvAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: MyCurrency, pos: Int) {
            binding.name.text = user.CcyNm_UZ
            binding.value.text = "${user.Rate} so'm"
            binding.mroot.setOnClickListener { myClick.onClick(user, pos) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(hol: ViewHolder, pos: Int) = hol.onBind(list[pos], pos)
    override fun getItemCount(): Int = list.size

    interface MyClick {
        fun onClick(myCurrency: MyCurrency, pos: Int)
    }
}