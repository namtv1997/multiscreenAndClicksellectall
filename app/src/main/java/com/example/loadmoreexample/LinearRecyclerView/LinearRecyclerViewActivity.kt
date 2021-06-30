package com.example.loadmoreexample.LinearRecyclerView

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Layout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.rangeTo
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loadmoreexample.*
import kotlinx.android.synthetic.main.activity_linear_recycler_view.*

class LinearRecyclerViewActivity : AppCompatActivity() {

    private lateinit var progressDialog: CircleProgressDialog


    lateinit var itemsCells: ArrayList<HomeCashBack?>
    lateinit var loadMoreItemsCells: ArrayList<HomeCashBack?>
    var adapterLinear: AdapterHomeCashBack? = null
    lateinit var scrollListener: RecyclerViewLoadMoreScroll
    lateinit var mLayoutManager: RecyclerView.LayoutManager
    private var isRefresh = true

    private lateinit var viewModel: LinearVewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_recycler_view)
        progressDialog = CircleProgressDialog(this)
        itemsCells = ArrayList()
        setAdapter()

        viewModel = ViewModelProvider(this).get(LinearVewModel::class.java).apply {
            homeListRefresh.observe(
                this@LinearRecyclerViewActivity,
                androidx.lifecycle.Observer { data ->
                    sw.isRefreshing = false
                    if (isRefresh) {
                        itemsCells.clear()
                        data?.forEach {
                            itemsCells.add(it)
                        }
                        adapterLinear?.notifyDataSetChanged()
                    } else {

                        adapterLinear?.addLoadingView()
                        loadMoreItemsCells = ArrayList()
                        Handler(Looper.getMainLooper()).postDelayed({

                            data?.forEach {
                                loadMoreItemsCells.add(it)
                            }
                            //Get the number of the current Items of the main Arraylist
                            adapterLinear?.removeLoadingView()
                            //We adding the data to our main ArrayList
                            adapterLinear?.addData(loadMoreItemsCells)
                            //Change the boolean isLoading to false
                            scrollListener.setLoaded()
                            //Update the recyclerView in the main thread
                        }, 2000)

                    }
                })

            loadingStatus.observe(this@LinearRecyclerViewActivity, Observer {
                showOrHideProgressDialog(it)
            })
        }

        sw.setOnRefreshListener {
            isRefresh = true
            viewModel.getListHome(true)
        }
    }

    fun showOrHideProgressDialog(isShow: Boolean) {
        when (isShow) {
            true -> progressDialog.show()
            else -> progressDialog.dismiss()
        }
    }

    override fun onPause() {
        super.onPause()
        progressDialog.cancel()
    }


    private fun setAdapter() {
        adapterLinear = AdapterHomeCashBack(itemsCells)
        mLayoutManager = LinearLayoutManager(this)
        items_linear_rv.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter = adapterLinear
            scrollListener = RecyclerViewLoadMoreScroll(mLayoutManager as LinearLayoutManager).apply {
                setOnLoadMoreListener(object : OnLoadMoreListener {
                    override fun onLoadMore() {
                        isRefresh = false
                        viewModel.getListHome(false)
                    }
                })
            }
            addOnScrollListener(scrollListener)
        }
    }


}
