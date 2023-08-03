package com.circle.exoplayer.data

import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.circle.exoplayer.ui.ExoPlayerActivity

class FirstViewModel : ViewModel() {

    var editField = MutableLiveData<String>()

    fun openNewScreen(view: View) {
        val intent = Intent(view.context, ExoPlayerActivity::class.java)
        view.context.startActivity(intent)
    }

}