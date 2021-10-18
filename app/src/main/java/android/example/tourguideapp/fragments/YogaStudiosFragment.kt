package android.example.tourguideapp.fragments

import android.example.tourguideapp.databinding.FragmentYogaStudiosBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class YogaStudiosFragment : Fragment() {
    private var _binding: FragmentYogaStudiosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentYogaStudiosBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}