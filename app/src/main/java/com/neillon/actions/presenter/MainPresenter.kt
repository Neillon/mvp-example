package com.neillon.actions.presenter

import com.neillon.actions.contracts.ItemContract
import com.neillon.actions.contracts.MainContract
import com.neillon.actions.enum.Actions
import com.neillon.actions.model.Action

class MainPresenter(
    var actions: List<Action>,
    private val viewInterface: MainContract.ViewInterface
) :
    MainContract.PresenterInterface {

    private var isAirplaneModeStarted = false

    override fun airplaneMode() {
        isAirplaneModeStarted = isAirplaneModeStarted.not()
    }

    override fun turnOff() {
        viewInterface.finishActivity()
    }

    override fun userInfo() {}

    override fun onBindActionsHolder(position: Int, holder: ItemContract) {
        val action = actions[position]

        holder.bindClick {
            when (action.type) {
                Actions.Airplane -> {
                    airplaneMode()
                    holder.changeAirplaneIcon(isAirplaneModeStarted)
                }
                Actions.TurnOff -> {
                    turnOff()
                }
                Actions.User -> {
                    userInfo()
                }
            }
        }
        holder.bindColor(action.color)
        holder.bindIcon(action.type)

    }

    override fun actionsSize(): Int = actions.size

}