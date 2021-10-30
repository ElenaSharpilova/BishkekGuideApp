package android.example.tourguideapp.fragments

import android.content.Intent
import android.example.tourguideapp.InfoAboutObject
import android.example.tourguideapp.R
import android.example.tourguideapp.RecyclerItemClick
import android.example.tourguideapp.adapters.RecyclerViewAdapter
import android.example.tourguideapp.databinding.FragmentLeisureBinding
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

class LeisureFragment : Fragment(), RecyclerItemClick {
    private var _binding: FragmentLeisureBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy{ RecyclerViewAdapter(this) }
    private val itemList by lazy{
        mutableListOf(
            InfoAboutObject("SUMBULE SPA", "54 Zhayil Baatyra st.", "More than 10 types of steam rooms, pool, jacuzzi, restaurant, massage","+996551418888", false, "https://goo.gl/maps/dehpUK4aX9oftFKE8"),
            InfoAboutObject ("Rope park - ARKAN TOKOI", "Elm grove, Bishkek", "Park of high-rise extreme Arkan Tokoy is an incredible set of nature, adrenaline, pleasant physical activity, safety and walking distance for a city dweller. A ten-minute drive from the center of Bishkek,in the shade of the magnificent trunks of the Karagachevaya Grove, passers-by in amazement raise their chins and enthusiastically point their fingers at the mysterious intricacies of climbing ropes, strange rope ladders and wooden platforms that are stuck to\n" +
                    "mighty, healthy oak trees. - You will get an adrenaline shower by following one of the suggested routes. By the way, there are several of them - at a height of five to fifteen meters above the ground (from a two- to seven-story building), wooden platforms are securely fixed in compliance with the international safety standard, connected to each other by nets, steps, swings, hinges, logs and other obstacles", "+996504535444", false, "https://goo.gl/maps/zhTeLCJMuXNWL38Q7"),
            InfoAboutObject ("Sports trampoline complex - SMILE","1B Gorky st.",
                "Sports trampoline complex \"Smile\" is - free jumping on a trampoline, acrobatic training, rock climbing wall,bouldering wall, rope town. proJumping - fitness, entertainment, holidays, group programs. Sports complex \"Smile\" is a unique combination of entertainment and sports, now available in Bishkek!\n" +
                        "Working hours from 10:00 to 21:00", "+996556466420", false, "https://goo.gl/maps/z6w2f86bDtgWgzfS9")
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLeisureBinding.inflate(inflater, container, false)
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