package com.plcoding.cryptocurrencyappyt.domain.use_case.manger.app_entry

import com.plcoding.cryptocurrencyappyt.domain.use_case.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry @Inject constructor(
    private val localUserManger: LocalUserManger
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}