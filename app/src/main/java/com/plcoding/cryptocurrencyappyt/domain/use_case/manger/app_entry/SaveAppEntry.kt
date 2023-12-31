package com.plcoding.cryptocurrencyappyt.domain.use_case.manger.app_entry

import com.plcoding.cryptocurrencyappyt.domain.use_case.manger.LocalUserManger
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}