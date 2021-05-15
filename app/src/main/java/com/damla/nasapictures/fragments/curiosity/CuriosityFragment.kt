package com.damla.nasapictures.fragments.curiosity

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.damla.nasapictures.R
import com.damla.nasapictures.dataSource.ViewModelDataSource
//import com.damla.nasapictures.api.ViewModel.ApiViewModel
import com.damla.nasapictures.databinding.FragmentCuriosityBinding

import com.damla.nasapictures.recyclerview.AdapterCuriosity

class CuriosityFragment : Fragment() {



    
    private lateinit var binding:FragmentCuriosityBinding
    private lateinit var mApiViewModel : ViewModelDataSource
    lateinit var recyclerView:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCuriosityBinding.inflate(inflater,container,false)

        recyclerView = binding.recyclerViewCriosity
        mApiViewModel = ViewModelProvider(this).get(ViewModelDataSource::class.java)
        mApiViewModel.searchPhotoLiveData("curiosity").observe(viewLifecycleOwner, Observer {
            val adapter = AdapterCuriosity()
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

        inflater.inflate(R.menu.nav_menucuriosity,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.cameraSOCFHAZ){

            mApiViewModel.searchPhotoFilteredLiveData("curiosity","fhaz").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterCuriosity()
                    adapter.submitData(this.lifecycle,it)

                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })

        }
        if(item.itemId == R.id.cameraSOCRHAZ){
            mApiViewModel.searchPhotoFilteredLiveData("curiosity","rhaz").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterCuriosity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }
        if(item.itemId == R.id.cameraSOCNAVCAM){
            mApiViewModel.searchPhotoFilteredLiveData("curiosity","navcam").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterCuriosity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }
        if(item.itemId == R.id.cameraCMAST){
            mApiViewModel.searchPhotoFilteredLiveData("curiosity","mast").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterCuriosity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }
        if(item.itemId == R.id.cameraCCHEMCAM){
            mApiViewModel.searchPhotoFilteredLiveData("curiosity","chemcam").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterCuriosity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }

        if(item.itemId == R.id.cameraCMARDI){
            mApiViewModel.searchPhotoFilteredLiveData("curiosity","mardi").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterCuriosity()
                    adapter.submitData(this.lifecycle,it)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        recyclerView.layoutManager = layoutManager
                        recyclerView.adapter = adapter
                    } })
        }

        if(item.itemId == R.id.cameraCMAHLI){
            mApiViewModel.searchPhotoFilteredLiveData("curiosity","mahli").observe(viewLifecycleOwner,
                Observer { val adapter = AdapterCuriosity()
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



