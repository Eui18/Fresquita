package com.myapp.fresquita.presentation.common

import com.myapp.fresquita.R

fun getStatusText(status: ExpirationStatus): Int? {
    return when (status) {
        ExpirationStatus.VALID -> R.string.status_valid
        ExpirationStatus.EXPIRING_SOON -> R.string.status_expiring_soon
        ExpirationStatus.EXPIRED -> R.string.status_expired
        ExpirationStatus.NO_DATE -> null
    }
}