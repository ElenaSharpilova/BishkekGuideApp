package android.example.tourguideapp.fragments

import android.content.Intent
import android.example.tourguideapp.InfoAboutObject
import android.example.tourguideapp.RecyclerItemClick
import android.example.tourguideapp.adapters.RecyclerViewAdapter
import android.example.tourguideapp.databinding.FragmentRestaurantBinding
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager


class RestaurantFragment: Fragment(), RecyclerItemClick {
    private var _binding: FragmentRestaurantBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy{RecyclerViewAdapter(this)}
    private val itemList by lazy{
        mutableListOf(
            InfoAboutObject("AVOCADO", "219 Сhui avenue", "Vegetarian, vegan coffee and buffet","+996555880390", false, "https://goo.gl/maps/ty8dGdmGL1ikmm16A", "https://media-cdn.tripadvisor.com/media/photo-s/1d/40/0d/eb/front.jpg"),
            InfoAboutObject ("GANDHI", "41 Isanov str.", "Indian restaurant", "+996312442932", false, "https://g.page/gandhirestro?share", "https://media-cdn.tripadvisor.com/media/photo-s/18/7f/4d/1a/great-first-impression.jpg"),
            InfoAboutObject ("BOOBLIK","1 T.Moldo str.",
            "Italian, European cuisine, large selection of vegetarian dishes", "+996551155555", false, "https://goo.gl/maps/LFQ24M2seqs3EAYX8", "https://lh3.googleusercontent.com/proxy/7zDJUg_-XaIL3NlIxZ-evaKikdUNET0PcDNPPYpoTDmNp6HPn_g3qls1i6OivUyWFzdAtUmIEhIjWqcqfcF0GrNOTI7xnKcB8-95Mxc6wB4TB-U_LasRNHJ7pWDNyQRONwProgviYxiBmUdrFAgOclUMpL-b")
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
