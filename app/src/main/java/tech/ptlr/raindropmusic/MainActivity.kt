package tech.ptlr.raindropmusic

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import tech.ptlr.raindropmusic.ui.theme.RaindropMusicTheme

class MainActivity : ComponentActivity() {
    val buttonNames = listOf("A", "B", "C")
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaindropMusicTheme {
                Scaffold(bottomBar = {
                    BottomAppBar {
                        val state = remember { mutableStateOf(0) }
                        TabRow(selectedTabIndex = state.value) {
                            buttonNames.forEachIndexed { index, name ->
                                Tab(text = { Text(name) },
                                    selected = state.value == index,
                                    onClick = {
                                        state.value = index
                                        Log.w("RDM","SELECT: " + state.value.toString())
                                    }
                                )
                            }
                        }
                    }
                }
            ) { _ -> Greeting(name = "Android") }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Hello $name!")
        Text(text = "ROW 2")
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RaindropMusicTheme {
        Greeting("Android")
    }
}