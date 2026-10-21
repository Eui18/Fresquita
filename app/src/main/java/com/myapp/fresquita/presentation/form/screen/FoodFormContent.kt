package com.myapp.fresquita.presentation.form.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.myapp.fresquita.R
import com.myapp.fresquita.data.model.FoodCategory
import com.myapp.fresquita.presentation.common.getCategoryText
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
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = stringResource(R.string.form_title))

        OutlinedTextField(
            value = uiState.name,
            onValueChange = onNameChange,
            label = { Text(text = stringResource(R.string.form_name_label)) },
            isError = uiState.nameError,
            supportingText = {
                if (uiState.nameError) {
                    Text(text = stringResource(R.string.form_name_error))
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = stringResource(R.string.form_category_label))
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FoodCategory.entries.forEach { category ->
                FilterChip(
                    selected = uiState.category == category,
                    onClick = { onCategoryChange(category) },
                    label = { Text(text = stringResource(getCategoryText(category))) }
                )
            }
        }

        OutlinedTextField(
            value = uiState.quantity,
            onValueChange = onQuantityChange,
            label = { Text(text = stringResource(R.string.form_quantity_label)) },
            isError = uiState.quantityError,
            supportingText = {
                if (uiState.quantityError) {
                    Text(text = stringResource(R.string.form_quantity_error))
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.unit,
            onValueChange = onUnitChange,
            label = { Text(text = stringResource(R.string.form_unit_label)) },
            isError = uiState.unitError,
            supportingText = {
                if (uiState.unitError) {
                    Text(text = stringResource(R.string.form_unit_error))
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.expirationDate,
            onValueChange = onExpirationDateChange,
            label = { Text(text = stringResource(R.string.form_date_label)) },
            isError = uiState.dateError,
            supportingText = {
                val messageId = if (uiState.dateError) {
                    R.string.form_date_error
                } else {
                    R.string.form_date_hint
                }
                Text(text = stringResource(messageId))
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onSave,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.form_save))
        }

        OutlinedButton(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.form_cancel))
        }
    }
}