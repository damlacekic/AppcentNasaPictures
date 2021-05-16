package com.damla.nasapictures.fragments.curiosity

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.damla.nasapictures.R
import com.damla.nasapictures.activity.MainActivity
import com.damla.nasapictures.dataSource.ViewModelDataSource
//import com.damla.nasapictures.api.ViewModel.ApiViewModel
import com.damla.nasapictures.databinding.FragmentCuriosityBinding

import com.damla.nasapictures.recyclerview.AdapterCuriosity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class CuriosityFragment : Fragment() {
    private lateinit var binding:FragmentCuriosityBinding
    lateinit var mApiViewModel : ViewModelDataSource
    lateinit var recyclerView:RecyclerView
    private lateinit var curiosityAdapter: AdapterCuriosity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCuriosityBinding.inflate(inflater,container,false)
     //recyclerView = binding.recyclerViewCriosity
        mApiViewModel = ViewModelProvider(this).get(ViewModelDataSource::class.java)
      /*  mApiViewModel.searchPhotoLiveData("curiosity").observe(viewLifecycleOwner, Observer {
            val adapter = AdapterCuriosity()
            adapter.submitData(this.lifecycle,it)
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
        curiosityAdapter = AdapterCuriosity()
        binding.recyclerViewCriosity.apply {
            adapter = curiosityAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }


    fun loaddata(){
        /*lifecycleScope.launch {
            mApiViewModel.getPhotos("curiosity").collect {
                curiosityAdapter.submitData(it)
            }
        }*/
        mApiViewModel.getPhotosLiveData("curiosity").observe(viewLifecycleOwner, Observer {
            curiosityAdapter.submitData(this.lifecycle,it)})
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.nav_menucuriosity,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.cameraSOCFHAZ){
       /* mApiViewModel.getPhotosFilteredLiveData("curiosity","fhaz").observe(viewLifecycleOwner,Observer{
            curiosityAdapter.submitData(this.lifecycle,it) })*/
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("curiosity","fhaz").observe(viewLifecycleOwner,Observer{
                curiosityAdapter.submitData(this.lifecycle,it) })

        }
        if(item.itemId == R.id.cameraSOCRHAZ){
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("curiosity","rhaz").observe(viewLifecycleOwner,Observer{
                curiosityAdapter.submitData(this.lifecycle,it) })

        }
        if(item.itemId == R.id.cameraSOCNAVCAM){
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("curiosity","navcam").observe(viewLifecycleOwner,Observer{
                curiosityAdapter.submitData(this.lifecycle,it) })

        }
        if(item.itemId == R.id.cameraCMAST){
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("curiosity","mast").observe(viewLifecycleOwner,Observer{
                curiosityAdapter.submitData(this.lifecycle,it) })

        }
        if(item.itemId == R.id.cameraCCHEMCAM){
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("curiosity","chemcam").observe(viewLifecycleOwner,Observer{
                curiosityAdapter.submitData(this.lifecycle,it) })

        }

        if(item.itemId == R.id.cameraCMARDI){
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("curiosity","mardi").observe(viewLifecycleOwner,Observer{
                curiosityAdapter.submitData(this.lifecycle,it) })

        }

        if(item.itemId == R.id.cameraCMAHLI){
            setupRecyclerView()
            mApiViewModel.getPhotosFilteredLiveData("curiosity","mahli").observe(viewLifecycleOwner,Observer{
                curiosityAdapter.submitData(this.lifecycle,it) })

        }



        return super.onOptionsItemSelected(item)
    }
















    

}



