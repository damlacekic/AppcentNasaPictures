package com.damla.nasapictures.fragments.curiosity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.damla.nasapictures.R
import com.damla.nasapictures.dataSource.ViewModelDataSource
import com.damla.nasapictures.databinding.FragmentCuriosityBinding

import com.damla.nasapictures.recyclerview.AdapterCuriosity


class CuriosityFragment : Fragment() {
    private lateinit var binding:FragmentCuriosityBinding
    lateinit var mApiViewModel : ViewModelDataSource
    lateinit var cViewModel : CuriosityViewModel
    private lateinit var curiosityAdapter: AdapterCuriosity
    var hasLoadedOnce = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCuriosityBinding.inflate(inflater,container,false)
        mApiViewModel = ViewModelProvider(this).get(ViewModelDataSource::class.java)
        cViewModel = ViewModelProvider(this).get(CuriosityViewModel::class.java)

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
            mApiViewModel.getPhotosLiveData("curiosity").observe(viewLifecycleOwner, Observer {
                curiosityAdapter.submitData(this.lifecycle,it)})

        mApiViewModel.getPhotosLiveData("curiosity").observe(viewLifecycleOwner, Observer {
            curiosityAdapter.submitData(this.lifecycle,it)})
    }
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if(this.isVisible){
            if(!isVisibleToUser && !hasLoadedOnce){
                hasLoadedOnce = true
            }
        }

        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.nav_menucuriosity,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.cameraSOCFHAZ){

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

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu?.removeItem(R.id.cameraSOPANCAM)
        menu?.removeItem(R.id.cameraSOCNAVCAM)

    }

}



