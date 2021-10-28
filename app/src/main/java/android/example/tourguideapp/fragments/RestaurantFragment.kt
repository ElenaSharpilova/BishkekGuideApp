package android.example.tourguideapp.fragments

import android.content.Intent
import android.example.tourguideapp.InfoAboutObject
import android.example.tourguideapp.R
import android.example.tourguideapp.RecyclerItemClick
import android.example.tourguideapp.adapters.RecyclerViewAdapter
import android.example.tourguideapp.databinding.FragmentRestaurantBinding
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.bumptech.glide.Glide


class RestaurantFragment: Fragment(), RecyclerItemClick {
    private var _binding: FragmentRestaurantBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy{RecyclerViewAdapter(this)}
    private val itemList by lazy{
        mutableListOf(
            InfoAboutObject("AVOCADO", "219 Сhui avenue", "Vegetarian, vegan coffee and buffet","+996555880390", false, "https://goo.gl/maps/ty8dGdmGL1ikmm16A"),
            InfoAboutObject ("GANDHI", "41 Isanov str.", "Indian restaurant", "+996312442932", false, "https://g.page/gandhirestro?share"),
            InfoAboutObject ("BOOBLIK","1 T.Moldo str.",
            "Italian, European cuisine, large selection of vegetarian dishes", "+996551155555", false, "https://goo.gl/maps/LFQ24M2seqs3EAYX8")
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.listRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.listRecyclerView.adapter = adapter
        adapter.setList(itemList)

        adapter.notifyDataSetChanged()

        return view

    }

    override fun recyclerItemClick(item: InfoAboutObject) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.location))
        startActivity(intent)
    }

}
