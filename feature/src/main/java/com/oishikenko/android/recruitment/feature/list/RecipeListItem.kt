package com.oishikenko.android.recruitment.feature.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.oishikenko.android.recruitment.data.model.CookingRecord

@Composable
fun RecipeListItem(
    cookingRecord: CookingRecord
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp,
            ),
    ) {
        AsyncImage(
            model = cookingRecord.imageUrl,
            contentDescription = cookingRecord.comment,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(4.dp)),
        )
        Text(text = translateRecipeType(cookingRecord.recipeType))
        Text(text = generateDateText(cookingRecord.recordedAt))
    }
}

fun translateRecipeType(recipeType: String): String {
    return when (recipeType) {
        "main_dish" -> "主菜/主食"
        "side_dish" -> "副菜"
        else -> "スープ"
    }
}

fun generateDateText(recordedAt: String): String {
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
        )
    )
}