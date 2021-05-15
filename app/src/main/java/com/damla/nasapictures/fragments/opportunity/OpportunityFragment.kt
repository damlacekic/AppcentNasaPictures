package com.damla.nasapictures.fragments.opportunity

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.damla.nasapictures.R
//import com.damla.nasapictures.api.ViewModel.ApiViewModel
import com.damla.nasapictures.dataSource.ViewModelDataSource
import com.damla.nasapictures.databinding.FragmentOppurtunityBinding
import com.damla.nasapictures.recyclerview.AdapterOpportunity

class OpportunityFragment : Fragment() {

    private lateinit var binding: FragmentOppurtunityBinding
    private lateinit var mApiViewModel: ViewModelDataSource
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOppurtunityBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewOpportunity
        mApiViewModel = ViewModelProvider(this).get(ViewModelDataSource::class.java)
        mApiViewModel.searchPhotoLiveData("opportunity").observe(viewLifecycleOwner, Observer {
            val adapter = AdapterOpportunity()
            adapter.submitData(this.lifecycle, it)
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
            }
        })


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.nav_menuopporunity, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.cameraSOCFHAZ) {
            mApiViewModel.searchPhotoFilteredLiveData("opportunity","fhaz").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterOpportunity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }

        if (item.itemId == R.id.cameraSOCRHAZ) {
            mApiViewModel.searchPhotoFilteredLiveData("opportunity","rhaz").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterOpportunity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }
        if (item.itemId == R.id.cameraSOCNAVCAM) {
            mApiViewModel.searchPhotoFilteredLiveData("opportunity","navcam").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterOpportunity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }
        if (item.itemId == R.id.cameraSOPANCAM) {
            mApiViewModel.searchPhotoFilteredLiveData("opportunity","pancam").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterOpportunity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }
        if (item.itemId == R.id.cameraSOMINITES) {
            mApiViewModel.searchPhotoFilteredLiveData("opportunity","minites").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterOpportunity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })

        }



        return super.onOptionsItemSelected(item)
    }

}





