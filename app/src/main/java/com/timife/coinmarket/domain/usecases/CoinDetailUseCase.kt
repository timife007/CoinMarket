package com.timife.coinmarket.domain.usecases

import com.timife.coinmarket.common.Resource
import com.timife.coinmarket.data.mappers.toCoinDetail
import com.timife.coinmarket.data.mappers.toCoinListItem
import com.timife.coinmarket.domain.model.CoinDetail
import com.timife.coinmarket.domain.model.CoinListItem
import com.timife.coinmarket.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val data = repository.getCoinDetail(coinId).toCoinDetail()
                emit(Resource.Success(data))
            }catch (e: HttpException){
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

            }catch (e: IOException){
                emit(Resource.Error( "Couldn't reach server, check your internet connection"))
            }
        }
    }
}