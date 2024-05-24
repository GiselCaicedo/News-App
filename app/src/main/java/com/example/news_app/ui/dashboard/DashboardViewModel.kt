//package com.example.news_app.ui.dashboard
//
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.TextView
//import androidx.cardview.widget.CardView
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.news_app.adapters.NewsAdapter
//import com.example.news_app.databinding.FragmentDashboardBinding
//import com.example.news_app.ui.MainViewModel
//import com.example.news_app.util.Constants
//
//class DashboardViewModel : ViewModel() {
//    private lateinit var binding: FragmentDashboardBinding
//    private lateinit var mainViewModel: MainViewModel
//    private lateinit var newsAdapter: NewsAdapter
//    private lateinit var retryButton: Button
//    private lateinit var error: TextView
//    private lateinit var itemHeadLinesError: CardView
//
//    private var isError = false
//    private var isLoading = false
//    private var isLastPage = false
//    private var isScrolling = false
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentDashboardBinding.bind(view)
//        setupRecyclerView()
//
//        // Initialize other views, ViewModel, and set listeners
//    }
//
//    private fun setupRecyclerView() {
//        newsAdapter = NewsAdapter()
//        binding.recyclerView.apply {
//            adapter = newsAdapter
//            layoutManager = LinearLayoutManager(activity)
//            addOnScrollListener(this@HomeFragment.scrollListener)
//        }
//    }
//
//    private fun hideProgressBar() {
//        binding.paginationProgressBar.visibility = View.INVISIBLE
//        isLoading = false
//    }
//
//    private fun showProgressBar() {
//        binding.paginationProgressBar.visibility = View.VISIBLE
//        isLoading = true
//    }
//
//    private fun hideErrorMessage() {
//        itemHeadLinesError.visibility = View.INVISIBLE
//        isError = false
//    }
//
//    private fun showErrorMessage(message: String) {
//        itemHeadLinesError.visibility = View.VISIBLE
//        error.text = message
//        isError = true
//    }
//
//    private val scrollListener = object : RecyclerView.OnScrollListener() {
//        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//            super.onScrolled(recyclerView, dx, dy)
//
//            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
//            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
//            val visibleItemCount = layoutManager.childCount
//            val totalItemCount = layoutManager.itemCount
//
//            val isNoErrors = !isError
//            val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
//            val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
//            val isNotAtBeginning = firstVisibleItemPosition >= 0
//            val isTotalMoreThanVisible = totalItemCount >= Constants.QUERY_PAGE_SIZE
//            val shouldPaginate = isNoErrors && isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeginning && isTotalMoreThanVisible && isScrolling
//
//            if (shouldPaginate) {
//                mainViewModel.getNewsHeadlines("co")
//                isScrolling = false
//            }
//        }
//
//        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//            super.onScrollStateChanged(recyclerView, newState)
//            if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
//                isScrolling = true
//            }
//        }
//    }
//}