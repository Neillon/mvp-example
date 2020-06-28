package com.neillon.actions.contracts

class MainContract {
    interface PresenterInterface {
        fun airplaneMode()
        fun turnOff()
        fun userInfo()
        fun onBindActionsHolder(position: Int, holder: ItemContract)
        fun actionsSize(): Int
    }

    interface ViewInterface {
        fun finishActivity()
    }
}