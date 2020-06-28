package com.neillon.actions.contracts

import com.neillon.actions.enum.Actions

interface ItemContract {
    fun changeAirplaneIcon(isAirplaneModeActive: Boolean)
    fun bindIcon(type: Actions)
    fun bindClick(click: () -> Unit)
    fun bindColor(color: String)
}