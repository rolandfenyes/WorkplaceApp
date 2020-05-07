package aut.bme.hu.workplaceapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import aut.bme.hu.workplaceapp.fragments.DetailsProfileFragment
import aut.bme.hu.workplaceapp.fragments.MainProfileFragment

class ProfilePagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    companion object {
        private const val NUM_PAGES = 2
    }

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MainProfileFragment()
            1 -> DetailsProfileFragment()
            else -> MainProfileFragment()
        }
    }
}