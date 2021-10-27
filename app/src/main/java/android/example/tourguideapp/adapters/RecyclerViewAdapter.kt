package android.example.tourguideapp.adapters

import android.example.tourguideapp.InfoAboutObject
import android.example.tourguideapp.R
import android.example.tourguideapp.RecyclerItemClick
import android.example.tourguideapp.databinding.ListItemBinding
import android.example.tourguideapp.fragments.RestaurantFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter(private val click: RecyclerItemClick) :


    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var list = mutableListOf<InfoAboutObject>()
    fun setList(list: MutableList<InfoAboutObject>){
        this.list = list
    }

    inner class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                //binding.ivIcon.setImageResource(this.icon)

                binding.tvTitle.text = this.name
                binding.tvAddress.text = this.address
                binding.tvDescription.text = this.description
                binding.tvPhone.text = this.phone
                binding.expandedView.visibility = if (this.expand) View.VISIBLE else View.GONE
                binding.cardLayout.setOnClickListener {
                    this.expand = !this.expand
                    notifyDataSetChanged()
                }
                binding.tvAddress.setOnClickListener{
                    click.recyclerItemClick(list[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
