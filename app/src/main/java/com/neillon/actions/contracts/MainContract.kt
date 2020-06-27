package com.neillon.actions.contracts

import android.widget.ImageButton
import com.neillon.actions.adapters.ActionsAdapter
import com.neillon.actions.model.Action

class MainContract {
    interface PresenterInterface {
        fun airplaneMode()
        fun turnOff()
        fun userInfo()
        fun onBindActionsHolder(position: Int, holder: ActionItemContract)
        fun actionsSize(): Int
    }

    interface ViewInterface {
        fun finishActivity()
    }
}