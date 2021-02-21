package com.codingwithsid.tracelocation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingwithsid.tracelocation.R
import com.codingwithsid.tracelocation.adapter.RecyclerViewAdapter
import com.codingwithsid.tracelocation.models.RecyclerList
import com.codingwithsid.tracelocation.viewmodel.MainActivityViewModel


class RecyclerListFragment : Fragment() {

    private lateinit var recyclerAdapter : RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        initViewModel()
        initViewModel(view)
        return view
    }

    private fun initViewModel(view: View?) {
        val rv = view?.findViewById<RecyclerView>(R.id.rv)
        rv?.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        rv?.addItemDecoration(decoration)
        recyclerAdapter = RecyclerViewAdapter(context)
        rv?.adapter = recyclerAdapter

        /*rv?.setOnClickListener {
            startActivity(Intent(activity, TraceLocationActivity::class.java))
        }*/
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(this, Observer<RecyclerList>{
            if (it != null) {
                recyclerAdapter.setUpdatedData(it.items)
            } else {
                Toast.makeText(activity, "Error in getting Data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    companion object {

        @JvmStatic
        fun newInstance() = RecyclerListFragment()
    }
}