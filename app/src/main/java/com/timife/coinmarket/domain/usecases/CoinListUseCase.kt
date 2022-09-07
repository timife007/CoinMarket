package com.timife.coinmarket.domain.usecases

import com.timife.coinmarket.common.Resource
import com.timife.coinmarket.data.mappers.toCoinListItem
import com.timife.coinmarket.domain.model.CoinListItem
import com.timife.coinmarket.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinListUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<CoinListItem>>>{
        return flow {
            try {
                emit(Resource.Loading(true))
                val data = repository.getCoins().map { it.toCoinListItem() }
                emit(Resource.Success(data))
            }catch (e:HttpException){
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

            }catch (e:IOException)){
                emit(Resource.Error( "Couldn't reach server, check your internet connection"))
            }
        }
    }
}