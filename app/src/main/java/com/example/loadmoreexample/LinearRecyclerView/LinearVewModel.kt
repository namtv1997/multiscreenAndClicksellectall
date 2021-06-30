package com.example.loadmoreexample.LinearRecyclerView

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loadmoreexample.API
import com.example.loadmoreexample.HomeCashBack
import com.example.loadmoreexample.observeOnMain

class LinearVewModel : ViewModel() {

    private var offset = 0
    var homeListRefresh = MutableLiveData<List<HomeCashBack>?>()
    val loadingStatus: MutableLiveData<Boolean> = MutableLiveData()

    init {
        getListHome(true)
    }

    fun getListHome(isRefresh: Boolean) {
        if (isRefresh) {
            offset = 0
        }
        API.service.getListHomeCashBack("", 10, offset, null, null, null, null, null, null, 1)
            .observeOnMain()
            ?.doOnSubscribe { loadingStatus.postValue(true) }
            ?.doOnNext { loadingStatus.postValue(false) }
            ?.doOnError { loadingStatus.postValue(false) }
            ?.subscribe({
                offset += it?.data?.size ?: 0
                homeListRefresh.value = it?.data
            }, {

            })

    }
}