package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins

import javax.inject.Inject

data class CoinsUseCase @Inject constructor(
    val getCoinsRemote: GetCoinsRemote,
    val insertCoinsLocal: InsertCoinsLocal,
    val getCoinsLocal: GetCoinsLocal,
    val deleteCoinsLocal: DeleteCoinsLocal
)