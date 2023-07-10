package com.oishikenko.android.recruitment.feature.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeDetail() {
    Scaffold(
        topBar = {
            DetailHeader()
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        }
    }
}

@Composable
fun DetailHeader() {
    val appBarHorizontalPadding = 4.dp
    Modifier
        .fillMaxHeight()
        .width(72.dp - appBarHorizontalPadding)

    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        val imageModifier = Modifier
            .size(60.dp)
        val textModifier = Modifier
            .padding(0.dp, 0.dp, 10.dp, 0.dp)

        Box(
            Modifier
                .height(64.dp)
                .fillMaxSize()
        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    text = stringResource(id = com.oishikenko.android.recruitment.feature.R.string.recipe_detail_title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = textModifier,
                    color = Color.Black
                )
            }
        }
    }
}