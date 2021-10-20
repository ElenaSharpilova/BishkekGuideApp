package android.example.tourguideapp.fragments

import android.example.tourguideapp.InfoAboutObject
import android.example.tourguideapp.R
import android.example.tourguideapp.adapters.RecyclerViewAdapter
import android.example.tourguideapp.databinding.FragmentRestaurantBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RestaurantFragment: Fragment() {
    private var _binding: FragmentRestaurantBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: RecyclerViewAdapter
    //private lateinit var manager: RecyclerView.LayoutManager

    private var restaurantsList = ArrayList<InfoAboutObject>()

//    private var restaurants = listOf(
//        InfoAboutObject ("AVACADO", R.drawable.avocado,"219 Сhui avenue", "Vegetarian, vegan coffee and buffet","+996555880390"),
//        InfoAboutObject ("GANDHI", R.drawable.gandhi, "41 Isanov str./Toktogul str", "Indian restaurant", "+996312442932\\n+996705442932"),
//        InfoAboutObject ("BOOBLIK",R.drawable.booblik,"103 Bokombaeva str.\\n Sydykova str./T.Moldo str.",
//            "Italian, European cuisine, large selection of vegetarian dishes", "+996551155555\\n+996550788788")
//    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        rvAdapter = RecyclerViewAdapter(restaurantsList)
        binding.listRecyclerView.adapter = rvAdapter

        val rest1 = InfoAboutObject("AVACADO", R.drawable.avocado,"219 Сhui avenue", "Vegetarian, vegan coffee and buffet","+996555880390", false)
        val rest2 = InfoAboutObject ("GANDHI", R.drawable.gandhi, "41 Isanov str./Toktogul str", "Indian restaurant", "+996312442932\\n+996705442932", false)
        val rest3 = InfoAboutObject ("BOOBLIK",R.drawable.booblik,"103 Bokombaeva str.\\n Sydykova str./T.Moldo str.",
            "Italian, European cuisine, large selection of vegetarian dishes", "+996551155555\\n+996550788788", false)

        restaurantsList.add(rest1)
        restaurantsList.add(rest2)
        restaurantsList.add(rest3)
        rvAdapter.notifyDataSetChanged()

//        manager = LinearLayoutManager(context)
//        binding.listRecyclerView.apply {
//            adapter = RecyclerViewAdapter(restaurants)
//            layoutManager = manager
//        }
        return view
    }

}
