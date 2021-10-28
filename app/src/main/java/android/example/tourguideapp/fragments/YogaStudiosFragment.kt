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
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide


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

        return view
    }

    override fun recyclerItemClick(item: InfoAboutObject) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.location))
        startActivity(intent)
    }
}
