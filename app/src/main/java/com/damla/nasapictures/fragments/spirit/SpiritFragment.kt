package com.damla.nasapictures.fragments.spirit

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.damla.nasapictures.R
//import com.damla.nasapictures.api.ViewModel.ApiViewModel
import com.damla.nasapictures.dataSource.ViewModelDataSource
import com.damla.nasapictures.databinding.FragmentSpiritBinding
import com.damla.nasapictures.recyclerview.AdapterOpportunity
import com.damla.nasapictures.recyclerview.AdapterSpirit
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SpiritFragment : Fragment() {

    private lateinit var binding: FragmentSpiritBinding
    private lateinit var mApiViewModel : ViewModelDataSource
    private lateinit var spiritAdapter:AdapterSpirit
    private lateinit var sViewModel : SpiritViewModel
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpiritBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewSpirit
        mApiViewModel = ViewModelProvider(this).get(ViewModelDataSource::class.java)
        sViewModel = ViewModelProvider(this).get(SpiritViewModel::class.java)


        setupRecyclerView()
        loaddata()
        setHasOptionsMenu(true)
        return binding.root
    }

    fun setupRecyclerView(){
        spiritAdapter = AdapterSpirit()
        binding.recyclerViewSpirit.apply {
            adapter = spiritAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }


    fun loaddata(){

        lifecycleScope.launch {
            mApiViewModel.getPhotos("spirit").collect {
                    spiritAdapter.submitData(it)}

        }

       /* mApiViewModel.getPhotosLiveData("spirit").observe(viewLifecycleOwner, Observer {
            spiritAdapter.submitData(this.lifecycle,it)})*/


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.nav_menuspirit, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.cameraSOCFHAZ) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("spirit","fhaz").observe(viewLifecycleOwner,Observer{
                spiritAdapter.submitData(this.lifecycle,it) })

        }
        if (item.itemId == R.id.cameraSOCRHAZ) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("spirit","rhaz").observe(viewLifecycleOwner,Observer{
                spiritAdapter.submitData(this.lifecycle,it) })

        }
        if (item.itemId == R.id.cameraSOCNAVCAM) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("spirit","navcam").observe(viewLifecycleOwner,Observer{
                spiritAdapter.submitData(this.lifecycle,it) })

        }
        if (item.itemId == R.id.cameraSOPANCAM) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("spirit","pancam").observe(viewLifecycleOwner,Observer{
                spiritAdapter.submitData(this.lifecycle,it) })

        }
        if (item.itemId == R.id.cameraSOMINITES) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("spirit","minites").observe(viewLifecycleOwner,Observer{
                spiritAdapter.submitData(this.lifecycle,it) })

        }

        return super.onOptionsItemSelected(item)
    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        menu?.removeItem(R.id.cameraCMAST)
        menu?.removeItem(R.id.cameraCCHEMCAM)
        menu?.removeItem(R.id.cameraCMAHLI)
        menu?.removeItem(R.id.cameraCMARDI)
    }


}