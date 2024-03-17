package ir.m3.rahmani.leitner.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.m3.rahmani.leitner.data.Card
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class HomeViewModel : ViewModel() {

  private var fetchJob: Job? = null
  private val _homeUiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
  val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

  fun getCard() {
    fetchJob?.cancel()
    fetchJob = viewModelScope.launch {
      try {
        _homeUiState.update {
          val card = Card()
          it.copy(card = card)
        }
      } catch (ioe: IOException) {
        _homeUiState.update {
          it.copy(card = Card(ioe.message.toString()))

        }
      }
    }

  }
}