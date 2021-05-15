package com.damla.nasapictures.adater

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.damla.nasapictures.fragments.curiosity.CuriosityFragment
import com.damla.nasapictures.fragments.opportunity.OpportunityFragment
import com.damla.nasapictures.fragments.spirit.SpiritFragment

class ViewPagerAdapter(fragmentManager:FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {


    private var fragment = Fragment()
    override fun getItemCount(): Int {
            return 3
    }
    override fun createFragment(position: Int): Fragment {
      when(position){
            0 -> fragment = CuriosityFragment()
            1 -> fragment = OpportunityFragment()
            2 -> fragment = SpiritFragment()
            else -> fragment = Fragment()
        }
        return fragment
    }

}