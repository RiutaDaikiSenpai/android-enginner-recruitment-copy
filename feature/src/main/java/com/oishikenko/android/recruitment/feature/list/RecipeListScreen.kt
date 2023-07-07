package com.oishikenko.android.recruitment.feature.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oishikenko.android.recruitment.feature.R


@Composable
fun RecipePageScreen() {
    ListScreen()
    HeaderScreen()
}

@OptIn(ExperimentalLifecycleComposeApi::class, ExperimentalLayoutApi::class)
@Composable
fun ListScreen(
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val cookingRecords by viewModel.cookingRecords.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            HeaderScreen()
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .consumedWindowInsets(innerPadding)
        ) {
            items(cookingRecords) {
                RecipeListItem(it)
            }
        }
    }
}


@Composable
fun HeaderScreen() {
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
                    text = stringResource(id = R.string.cooking_records_title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = textModifier
                )
                Image(
                    painter = painterResource(id = R.drawable.group),
                    contentDescription = "料理",
                    modifier = imageModifier
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecipeListScreen() {
    MaterialTheme {
        ListScreen()
    }
}
