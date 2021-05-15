package com.damla.nasapictures.fragments.spirit

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.damla.nasapictures.R
//import com.damla.nasapictures.api.ViewModel.ApiViewModel
import com.damla.nasapictures.dataSource.ViewModelDataSource
import com.damla.nasapictures.databinding.FragmentSpiritBinding
import com.damla.nasapictures.recyclerview.AdapterSpirit

class SpiritFragment : Fragment() {

    private lateinit var binding: FragmentSpiritBinding
    private lateinit var mApiViewModel : ViewModelDataSource
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpiritBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewSpirit
        mApiViewModel = ViewModelProvider(this).get(ViewModelDataSource::class.java)
        mApiViewModel.searchPhotoLiveData("spirit").observe(viewLifecycleOwner, Observer {
            val adapter = AdapterSpirit()
            adapter.submitData(this.lifecycle,it)
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

        inflater.inflate(R.menu.nav_menuspirit, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.cameraSOCFHAZ) {
            mApiViewModel.searchPhotoFilteredLiveData("spirit","fhaz").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterSpirit()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }
        if (item.itemId == R.id.cameraSOCRHAZ) {
            mApiViewModel.searchPhotoFilteredLiveData("spirit","rhaz").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterSpirit()
                    adapter.submitData(this.lifecycle,it)
                    if(adapter.itemCount>0){
                        recyclerView.apply {
                            layoutManager = LinearLayoutManager(requireContext())
                            recyclerView.layoutManager = layoutManager
                            recyclerView.adapter = adapter
                        }
                    }else{
                        Toast.makeText(requireContext(),"I believe there is no photo in this field",
                            Toast.LENGTH_LONG).show()

                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }
        if (item.itemId == R.id.cameraSOCNAVCAM) {
            mApiViewModel.searchPhotoFilteredLiveData("spirit","navcam").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterSpirit()
                    adapter.submitData(this.lifecycle,it)

                        recyclerView.apply {
                            layoutManager = LinearLayoutManager(requireContext())
                            recyclerView.layoutManager = layoutManager
                            recyclerView.adapter = adapter

                    }

                     })
        }
        if (item.itemId == R.id.cameraSOPANCAM) {
            mApiViewModel.searchPhotoFilteredLiveData("spirit","pancam").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterSpirit()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    }

                })
        }
        if (item.itemId == R.id.cameraSOMINITES) {
            mApiViewModel.searchPhotoFilteredLiveData("spirit","minites").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterSpirit()
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