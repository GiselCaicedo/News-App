package com.example.news_app.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_app.repository.NewsRepository

class MainViewModelProviderFactory (val app: Application, val newsRepository : NewsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(app, newsRepository) as T
    }
}