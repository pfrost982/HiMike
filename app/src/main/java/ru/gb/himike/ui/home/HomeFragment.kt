package ru.gb.himike.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.gb.himike.databinding.FragmentHomeBinding
import ru.gb.himike.ui.home.recycler_classes.ClassesAdapter
import ru.gb.himike.ui.home.recycler_classes.HomeworkAdapter
import ru.gb.himike.ui.home.recycler_classes.lessons

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.countdownString.observe(viewLifecycleOwner) {
            binding.count.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.classesRecyclerview.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager
                .HORIZONTAL, false
        )
        binding.classesRecyclerview.adapter = ClassesAdapter(lessons)

        binding.homeworkRecyclerview.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager
                .HORIZONTAL, false
        )
        binding.homeworkRecyclerview.adapter = HomeworkAdapter(lessons)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}