package com.neillon.actions.adapters

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neillon.actions.R
import com.neillon.actions.contracts.ActionItemContract
import com.neillon.actions.contracts.MainContract
import com.neillon.actions.enum.Actions
import kotlinx.android.synthetic.main.item_action.view.*

class ActionsAdapter(var presenter: MainContract.PresenterInterface) :
    RecyclerView.Adapter<ActionsAdapter.ActionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewHolder =
        ActionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_action, parent, false)
        )

    override fun getItemCount(): Int = presenter.actionsSize()

    override fun onBindViewHolder(holder: ActionViewHolder, position: Int) {
        presenter.onBindActionsHolder(position, holder)
    }

    /**
     * ViewHolder
     */
    inner class ActionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        ActionItemContract {

        override fun changeAirplaneIcon(isAirplaneModeActive: Boolean) {
            if (isAirplaneModeActive) {
                itemView.imageButtonAction.setImageResource(R.drawable.ic_baseline_airplanemode_inactive)
            } else {
                itemView.imageButtonAction.setImageResource(R.drawable.ic_baseline_airplanemode_active)
            }
        }

        override fun bindIcon(type: Actions) {
            when (type) {
                Actions.Airplane -> {
                    itemView.imageButtonAction.setImageResource(R.drawable.ic_baseline_airplanemode_inactive)
                }
                Actions.TurnOff -> {
                    itemView.imageButtonAction.setImageResource(R.drawable.ic_baseline_power_off)
                }
                Actions.User -> {
                    itemView.imageButtonAction.setImageResource(R.drawable.ic_baseline_person)
                }
            }

        }

        override fun bindClick(click: () -> Unit) {
            itemView.imageButtonAction.setOnClickListener { click() }
        }

        override fun bindColor(color: String) {
            itemView.imageButtonAction.setColorFilter(color.toInt(), PorterDuff.Mode.SRC_ATOP)
        }

    }

}