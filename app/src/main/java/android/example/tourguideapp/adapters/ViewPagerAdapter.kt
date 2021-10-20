package android.example.tourguideapp.adapters

import android.example.tourguideapp.fragments.LeisureFragment
import android.example.tourguideapp.fragments.RestaurantFragment
import android.example.tourguideapp.fragments.YogaStudiosFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


private const val NUM_TABS = 3

public class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return YogaStudiosFragment()
            1 -> return RestaurantFragment()
        }
        return LeisureFragment()
    }
}