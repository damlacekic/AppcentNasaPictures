package com.damla.nasapictures.fragments.opportunity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.damla.nasapictures.R
import com.damla.nasapictures.activity.MainActivity
//import com.damla.nasapictures.api.ViewModel.ApiViewModel
import com.damla.nasapictures.dataSource.ViewModelDataSource
import com.damla.nasapictures.databinding.FragmentOppurtunityBinding
import com.damla.nasapictures.recyclerview.AdapterCuriosity
import com.damla.nasapictures.recyclerview.AdapterOpportunity
import dagger.hilt.android.AndroidEntryPoint

class OpportunityFragment : Fragment() {

    private lateinit var binding: FragmentOppurtunityBinding
    private lateinit var mApiViewModel: ViewModelDataSource
    private lateinit var recyclerView: RecyclerView
    private lateinit var opportunityAdapter:AdapterOpportunity
    private lateinit var preferences : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentOppurtunityBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewOpportunity
        preferences = requireActivity().getSharedPreferences("com.damla.finalproject", Context.MODE_PRIVATE)

        mApiViewModel = ViewModelProvider(this).get(ViewModelDataSource::class.java)
      /*  mApiViewModel.searchPhotoLiveData("opportunity").observe(viewLifecycleOwner, Observer {
            val adapter = AdapterOpportunity()
            adapter.submitData(this.lifecycle, it)
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
            }
        })*/
        //setRetainInstance(true)
        setupRecyclerView()
        loaddata()
        setHasOptionsMenu(true)
        return binding.root
    }
    fun setupRecyclerView(){
        opportunityAdapter = AdapterOpportunity()
        binding.recyclerViewOpportunity.apply {
            adapter = opportunityAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }


    fun loaddata(){
        /*lifecycleScope.launch {
            mApiViewModel.getPhotos("curiosity").collect {
                curiosityAdapter.submitData(it)
            }
        }*/

            mApiViewModel.getPhotosLiveData("opportunity").observe(viewLifecycleOwner, Observer {
                opportunityAdapter.submitData(this.lifecycle,it)})


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.nav_menuopporunity, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.cameraSOCFHAZ) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("opportunity","fhaz").observe(viewLifecycleOwner,Observer{
                opportunityAdapter.submitData(this.lifecycle,it) })
        }

        if (item.itemId == R.id.cameraSOCRHAZ) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("opportunity","rhaz").observe(viewLifecycleOwner,Observer{
                opportunityAdapter.submitData(this.lifecycle,it) })
        }
        if (item.itemId == R.id.cameraSOCNAVCAM) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("opportunity","navcam").observe(viewLifecycleOwner,Observer{
                opportunityAdapter.submitData(this.lifecycle,it) })
        }
        if (item.itemId == R.id.cameraSOPANCAM) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("opportunity","pancam").observe(viewLifecycleOwner,Observer{
                opportunityAdapter.submitData(this.lifecycle,it) })
        }
        if (item.itemId == R.id.cameraSOMINITES) {
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("opportunity","minites").observe(viewLifecycleOwner,Observer{
                opportunityAdapter.submitData(this.lifecycle,it) })

        }



        return super.onOptionsItemSelected(item)
    }

}





