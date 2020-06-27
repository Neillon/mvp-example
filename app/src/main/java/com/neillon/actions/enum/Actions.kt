package com.neillon.actions.enum

sealed class Actions {
    object Airplane: Actions()
    object TurnOff: Actions()
    object User: Actions()
}