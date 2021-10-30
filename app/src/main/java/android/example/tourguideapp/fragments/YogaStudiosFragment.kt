package android.example.tourguideapp.fragments

import android.content.Intent
import android.example.tourguideapp.InfoAboutObject
import android.example.tourguideapp.R
import android.example.tourguideapp.RecyclerItemClick
import android.example.tourguideapp.adapters.RecyclerViewAdapter
import android.example.tourguideapp.databinding.FragmentYogaStudiosBinding
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions



class YogaStudiosFragment : Fragment(), RecyclerItemClick {
    private var _binding: FragmentYogaStudiosBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy{ RecyclerViewAdapter(this) }
    private val itemList by lazy{
        mutableListOf(
            InfoAboutObject("ATMA", "17\\2 Baitik Baatyra st.", "yoga, pilates, stretching","+996559930071", false, "https://g.page/Yogadomatma?share"),
            InfoAboutObject ("ЁGA HALL", "103 Bokombaeva st.", "Located in the very center of Bishkek. Our studio is taught by professional instructors and presents a wide variety of yoga directions.", "+996553880108", false, "https://g.page/egahall?share"),
            InfoAboutObject ("SATTVA","167 Toktogula st.",
                "yoga, pilates, stretching,stand on nails", "+996708112212", false, "https://goo.gl/maps/diK4PLjpHjEbgcgn9")
        )
    }
    /*private val imageList by lazy {
        listOf(R.drawable.atma,
        R.drawable.egahall,
        R.drawable.sattva)
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentYogaStudiosBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.listRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.listRecyclerView.adapter = adapter
        adapter.setList(itemList)
        adapter.notifyDataSetChanged()

        //val imageUrl = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fi1.photo.2gis.com%2Fimages%2Fbranch%2F0%2F30258560054995284_c098.jpg&imgrefurl=https%3A%2F%2Fm.2gis.kg%2Fbishkek%2Ffirm%2F70000001046162075%2FcardTab%2Fgallery%2Fphotos%2Ffirm%2F70000001046162075-30258560053578984&tbnid=cCAXKNfrknsjmM&vet=12ahUKEwjvkL-UyO_zAhUGxCoKHUZcB7gQMygDegQIARAW..i&docid=hMj_hdEyALCrzM&w=5184&h=3456&itg=1&q=sattva%20bishkek&ved=2ahUKEwjvkL-UyO_zAhUGxCoKHUZcB7gQMygDegQIARAW"
        //val imagePath = view.findViewById<ImageView>(R.id.iv_icon)
        //val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
       // Glide.with(this).load(imageUrl).into(imagePath)
        //Glide.with(this)
            //.load(imageUrl)
            //.into(imagePath)
        return view
    }

    override fun recyclerItemClick(item: InfoAboutObject) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.location))
        startActivity(intent)
    }
}

