package com.myapp.fresquita.presentation.common

import com.myapp.fresquita.R
import com.myapp.fresquita.data.model.FoodCategory

fun getCategoryText(category: FoodCategory): Int {
    return when (category) {
        FoodCategory.FRUITS -> R.string.category_fruits
        FoodCategory.VEGETABLES -> R.string.category_vegetables
        FoodCategory.REFRIGERATED -> R.string.category_refrigerated
        FoodCategory.PANTRY -> R.string.category_pantry
    }
}