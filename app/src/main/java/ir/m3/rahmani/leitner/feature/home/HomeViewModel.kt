package ir.m3.rahmani.leitner.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.m3.rahmani.leitner.data.local.entities.CardEntity
import ir.m3.rahmani.leitner.data.model.Card
import ir.m3.rahmani.leitner.data.repository.LeitnerRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.Calendar

class HomeViewModel(
  private val leitnerRepository: LeitnerRepository
) : ViewModel() {

  private var fetchJob: Job? = null
  private val _homeUiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
  val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

  private val currentTime = Calendar.getInstance().timeInMillis

  private val getCardsStream: Flow<List<Card>> =
    leitnerRepository.todayReviewCards(currentTime)
      .catch { emit(emptyList()) }

  fun getCards(){
    viewModelScope.launch {
      _homeUiState.update {
        it.copy(cards = getCardsStream)
      }
    }
  }

  fun removeCard(card: Card){
    viewModelScope.launch {
      leitnerRepository.removeCard(card)
    }
  }

  fun guessCorrect(card: Card, boolean: Boolean){
    var newReviewTime:Int = 0
    if (boolean){

    }else{

    }


  }

  fun calculateNewReviewTime(){
    // todo: found a way calculate
  }

  fun updateCard(card: Card){
    viewModelScope.launch{
      leitnerRepository.updateCard(card)
    }
  }

}