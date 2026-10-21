package com.myapp.fresquita.presentation.form.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.myapp.fresquita.R
import com.myapp.fresquita.data.model.FoodCategory
import com.myapp.fresquita.presentation.common.components.PrimaryButton
import com.myapp.fresquita.presentation.common.components.ScreenHeader
import com.myapp.fresquita.presentation.common.components.SecondaryButton
import com.myapp.fresquita.presentation.form.components.CategorySelector
import com.myapp.fresquita.presentation.form.components.FoodTextField
import com.myapp.fresquita.presentation.form.state.FoodFormUiState

@Composable
fun FoodFormContent(
    uiState: FoodFormUiState,
    onNameChange: (String) -> Unit,
    onCategoryChange: (FoodCategory) -> Unit,
    onQuantityChange: (String) -> Unit,
    onUnitChange: (String) -> Unit,
    onExpirationDateChange: (String) -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        IconButton(onClick = onCancel) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.form_back)
            )
        }

        ScreenHeader(
            title = stringResource(
                if (uiState.editingId == null) R.string.form_title else R.string.form_title_edit
            ),
            subtitle = stringResource(R.string.form_subtitle)
        )

        FoodTextField(
            value = uiState.name,
            onValueChange = onNameChange,
            label = stringResource(R.string.form_name_label),
            supportingText = if (uiState.nameError) stringResource(R.string.form_name_error) else null,
            isError = uiState.nameError
        )

        Text(
            text = stringResource(R.string.form_category_label),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        CategorySelector(
            selected = uiState.category,
            onSelected = onCategoryChange
        )

        FoodTextField(
            value = uiState.quantity,
            onValueChange = onQuantityChange,
            label = stringResource(R.string.form_quantity_label),
            supportingText = if (uiState.quantityError) stringResource(R.string.form_quantity_error) else null,
            isError = uiState.quantityError,
            keyboardType = KeyboardType.Decimal
        )

        FoodTextField(
            value = uiState.unit,
            onValueChange = onUnitChange,
            label = stringResource(R.string.form_unit_label),
            supportingText = if (uiState.unitError) stringResource(R.string.form_unit_error) else null,
            isError = uiState.unitError
        )

        FoodTextField(
            value = uiState.expirationDate,
            onValueChange = onExpirationDateChange,
            label = stringResource(R.string.form_date_label),
            supportingText = stringResource(
                if (uiState.dateError) R.string.form_date_error else R.string.form_date_hint
            ),
            isError = uiState.dateError
        )

        PrimaryButton(
            text = stringResource(R.string.form_save),
            onClick = onSave
        )

        SecondaryButton(
            text = stringResource(R.string.form_cancel),
            onClick = onCancel
        )
    }
}