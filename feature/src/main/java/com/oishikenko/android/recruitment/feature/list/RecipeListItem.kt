package com.oishikenko.android.recruitment.feature.list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.oishikenko.android.recruitment.data.model.CookingRecord

@Composable
fun RecipeListItem(
    cookingRecord: CookingRecord,
    onClick: (String) -> Unit
) {
    Surface(
        modifier = Modifier.clickable { onClick("recipeDetail") },
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 10.dp, 16.dp, 0.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFDCE0E0),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            AsyncImage(
                model = cookingRecord.imageUrl,
                contentDescription = cookingRecord.comment,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(8, 0, 0, 8)),
            )
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = translateRecipeType(cookingRecord.recipeType),
                    fontWeight = FontWeight.Bold
                )
                Text(text = generateDateString(cookingRecord.recordedAt))
            }
        }
    }
}

fun translateRecipeType(recipeType: String): String {
    return when (recipeType) {
        "main_dish" -> "主菜/主食"
        "side_dish" -> "副菜"
        else -> "スープ"
    }
}

fun generateDateString(recordedAt: String): String {
    val year = recordedAt.substring(0, 4)
    val month = recordedAt.substring(5, 7)
    val date = recordedAt.substring(8, 10)
    val time = recordedAt.substring(11, 16)
    return "$year/$month/$date $time"
}

@Preview
@Composable
fun PreviewRecipeListItem() {
    RecipeListItem(
        cookingRecord = CookingRecord(
            imageUrl = "",
            comment = "豚肉のコクとごぼうの香り、野菜の甘みで奥行きのある味わい。",
            recipeType = "soup",
            recordedAt = "2018-05-01 17:57:31"
        ),
    ) {}
}