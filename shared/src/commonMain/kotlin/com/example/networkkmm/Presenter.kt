package com.example.networkkmm

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Presenter(private val view: IView): IPresenter {
    private val network = Network()
    override fun onButtonClick(name: String) {
        network.getData(name) {
            view.showResult(it)
        }
    }
}
