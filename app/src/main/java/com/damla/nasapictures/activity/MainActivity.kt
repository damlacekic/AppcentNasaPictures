package com.damla.nasapictures.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider

import androidx.viewpager2.widget.ViewPager2
import com.damla.nasapictures.R
import com.damla.nasapictures.adater.ViewPagerAdapter
import com.damla.nasapictures.dataSource.ViewModelDataSource
import com.damla.nasapictures.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    private lateinit var aViewModel : ActivityViewModel
    var changingCameras : Int =  1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val tablayout : TabLayout = binding.tabLayout
        val viewPager2:ViewPager2 = binding.viewPager
        aViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        val toolBar : Toolbar = binding.toolBarPictures
        setSupportActionBar(toolBar)
        viewPager2.adapter = adapter
        viewPager2.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                changingCameras = position
                super.onPageSelected(position)
            }
        })

        TabLayoutMediator(tablayout,viewPager2){tab,position ->
                viewPager2.setCurrentItem(position)
            when(position){
                0-> tab.text = "Curiosity"
                1-> tab.text = "Opportunity"
                2 -> tab.text = "Spirit"
            }

        }.attach()


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        when(changingCameras){
            0 -> MenuInflater(this).inflate(R.menu.nav_menucuriosity,menu)
            1 -> MenuInflater(this).inflate(R.menu.nav_menuopporunity,menu)
            2 -> MenuInflater(this).inflate(R.menu.nav_menuspirit,menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
/*



*/

            if(changingCameras==0){
               menu?.findItem(R.id.cameraSOCFHAZ)?.setVisible(false)
                menu?.findItem(R.id.cameraSOCRHAZ)?.setVisible(false)
                menu?.findItem(R.id.cameraSOCNAVCAM)?.setVisible(false)
                menu?.findItem(R.id.cameraCMAST)?.setVisible(false)
                menu?.findItem(R.id.cameraCCHEMCAM)?.setVisible(false)
                menu?.findItem(R.id.cameraCMAHLI)?.setVisible(false)
                menu?.findItem(R.id.cameraCMARDI)?.setVisible(false)

            }

            if(changingCameras==1){
                menu?.findItem(R.id.cameraSOCFHAZ)?.setVisible(false)
                menu?.findItem(R.id.cameraSOCRHAZ)?.setVisible(false)
                menu?.findItem(R.id.cameraSOCNAVCAM)?.setVisible(false)
                menu?.findItem(R.id.cameraSOPANCAM)?.setVisible(false)
                menu?.findItem(R.id.cameraSOMINITES)?.setVisible(false)






            }
            if(changingCameras==2){
                menu?.findItem(R.id.cameraSOCFHAZ)?.setVisible(false)
                menu?.findItem(R.id.cameraSOCRHAZ)?.setVisible(false)
                menu?.findItem(R.id.cameraSOCNAVCAM)?.setVisible(false)
                menu?.findItem(R.id.cameraSOPANCAM)?.setVisible(false)
                menu?.findItem(R.id.cameraSOMINITES)?.setVisible(false)
            }


        return super.onPrepareOptionsMenu(menu)
    }




}