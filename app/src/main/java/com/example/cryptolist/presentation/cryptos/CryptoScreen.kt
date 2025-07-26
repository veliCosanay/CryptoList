package com.example.cryptolist.presentation.cryptos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptolist.presentation.cryptos.views.CryptoItem

@Composable
fun CryptoFun(
    cryptoViewModel: CryptoViewModel = hiltViewModel()
) {
    val state = cryptoViewModel.cryptoState.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(state.crypto) { crypto ->
                CryptoItem(crypto = crypto)
                HorizontalDivider()
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}