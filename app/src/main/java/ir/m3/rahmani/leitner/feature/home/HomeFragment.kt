package ir.m3.rahmani.leitner.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.viewModelFactory
import ir.m3.rahmani.leitner.data.local.db.AppDatabase
import ir.m3.rahmani.leitner.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

  private var _binding: FragmentHomeBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)


    binding.showAnswer.setOnClickListener {
      it.visibility = View.GONE
      binding.llAnswerBox.visibility = View.VISIBLE
      // TODO -> Change frameLayout home to background
    }

  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}