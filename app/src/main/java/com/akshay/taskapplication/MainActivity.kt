package com.akshay.taskapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshay.taskapplication.domain.NetworkModule
import com.akshay.taskapplication.domain.repositories.DataRepoImpl
import com.akshay.taskapplication.model.DataResponse
import com.akshay.taskapplication.ui.theme.TaskApplicationTheme
import com.akshay.taskapplication.viewmodel.MainViewModel


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = NetworkModule()

        val dataRepo = DataRepoImpl(api.getApi())
        viewModel = MainViewModel(dataRepo)
        setContent {
            TaskApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DataSection(viewModel)
                }
            }
        }
    }
}

@Composable
fun DataSection(mainViewModel: MainViewModel) {

    val data by remember {
        mainViewModel.dataResponse
    }.collectAsState()

    LaunchedEffect(Unit) {
        mainViewModel.getData()
    }

    val dataList = mutableListOf<DataResponse>()
    dataList.addAll(data)


    LazyColumn(contentPadding = PaddingValues(12.dp)) {
        itemsIndexed(dataList) { index, dataItem ->

            key(index) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = dataItem.school_name, fontSize = 16.sp, color = Color.Blue)
                    Text(text = dataItem.dbn, fontSize = 14.sp, color = Color.Blue)
                    Text(text = "Location- ${dataItem.location}", fontSize = 14.sp)
                    Text(text = "Phone Number- ${dataItem.phone_number}", fontSize = 14.sp)
                    Text(text = "Web View- ${dataItem.website}", fontSize = 14.sp)
                    Text(text = dataItem.overview_paragraph, fontSize = 14.sp)

                }
            }
        }
    }

}




