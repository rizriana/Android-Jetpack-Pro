package com.kotlin.academy.ui.reader.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.academy.data.ContentEntity
import com.kotlin.academy.data.ModuleEntity
import com.kotlin.academy.databinding.FragmentModuleContentBinding
import com.kotlin.academy.ui.reader.CourseReaderViewModel

class ModuleContentFragment : Fragment() {

    private var _binding: FragmentModuleContentBinding? = null
    private val binding get() = _binding!!

    companion object {
        val TAG: String = ModuleContentFragment::class.java.simpleName
        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentModuleContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(
                requireActivity(),
                ViewModelProvider.NewInstanceFactory()
            )[CourseReaderViewModel::class.java]
//            val content =
//                ContentEntity("<h3 class=\\\"fr-text-bordered\\\">Contoh Content</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>")
//            populateWebView(content)
            val module = viewModel.getSelectedModule()
            populateWebView(module)
        }
    }

//    private fun populateWebView(content: ContentEntity) {
//        binding.webView.loadData(content.content ?: "", "text/html", "UTF-8")
//    }

    private fun populateWebView(module: ModuleEntity) {
        binding.webView.loadData(module.contentEntity?.content ?: "", "text/html", "UTF-8")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}