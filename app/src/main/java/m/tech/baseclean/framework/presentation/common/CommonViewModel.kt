package m.tech.baseclean.framework.presentation.common

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import m.tech.baseclean.business.data.DataState
import m.tech.baseclean.business.domain.Dummy
import m.tech.baseclean.business.interactors.GetDummies

class CommonViewModel
@ViewModelInject
constructor(
    @Assisted private val savedStateHandler: SavedStateHandle,
    private val getDummies: GetDummies
) : ViewModel() {

    private val _dummies = MutableLiveData<DataState<List<Dummy>>>()
    val dummies: LiveData<DataState<List<Dummy>>>
        get() = _dummies

    fun getDummies() = viewModelScope.launch {
        withContext(IO) {
            getDummies.getDummies(true).collect { dataState ->
                withContext(Main) {
                    _dummies.value = dataState
                }
            }
        }
    }

}