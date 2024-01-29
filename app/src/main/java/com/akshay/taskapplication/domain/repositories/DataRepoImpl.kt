package com.akshay.taskapplication.domain.repositories

import com.akshay.taskapplication.domain.APIInterface
import com.akshay.taskapplication.model.DataResponse

class DataRepoImpl(val api: APIInterface): DataRepo {
    override suspend fun getData(): List<DataResponse> {
        return api.getData()
    }

}