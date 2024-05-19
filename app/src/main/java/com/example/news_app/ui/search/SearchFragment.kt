package com.example.news_app.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.news_app.databinding.FragmentSearchBinding // Asegúrate de importar la clase de enlace correcta

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false) // Aquí se utiliza la clase de enlace de tu fragmento de búsqueda
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
