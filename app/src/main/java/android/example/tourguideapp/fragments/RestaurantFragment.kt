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
            InfoAboutObject("AVACADO", "219 Сhui avenue", "Vegetarian, vegan coffee and buffet","+996555880390", false, "https://goo.gl/maps/MrRQo72QXn25AcdSA"),
            InfoAboutObject ("GANDHI", "41 Isanov str./Toktogul str", "Indian restaurant", "+996312442932\\n+996705442932", false, "https://g.page/gandhirestro?share"),
            InfoAboutObject ("BOOBLIK","103 Bokombaeva str.\\n Sydykova str./T.Moldo str.",
            "Italian, European cuisine, large selection of vegetarian dishes", "+996551155555\\n+996550788788", false, "https://goo.gl/maps/ty8dGdmGL1ikmm16A")
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

        //val url = "https://cafe.kg/wp-content/uploads/2019/07/53491120_2037979912975947_2988720050245992448_n.jpg"
        /*imageIcon = view.findViewById(R.id.iv_icon)
        Glide.with(this)
            .load(url)
            .into(imageIcon)*/
        adapter.notifyDataSetChanged()

        return view
    }

    override fun recyclerItemClick(item: InfoAboutObject) {
        val intentUri = Uri.parse(item.location)
        val mapIntent = Intent(Intent.ACTION_VIEW, intentUri )
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }


}
