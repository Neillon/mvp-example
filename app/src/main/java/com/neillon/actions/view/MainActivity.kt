package com.neillon.actions.view

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.neillon.actions.R
import com.neillon.actions.adapters.ActionsAdapter
import com.neillon.actions.contracts.MainContract
import com.neillon.actions.enum.Actions
import com.neillon.actions.model.Action
import com.neillon.actions.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.ViewInterface {

    private lateinit var presenter: MainContract.PresenterInterface
    private lateinit var actions: MutableList<Action>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createActions()
        setupPresenter()
        initializeViews()
    }

    private fun createActions() {
        actions = mutableListOf(
            Action(
                color = Color.BLUE.toString(),
                type = Actions.Airplane
            ),
            Action(
                color = Color.RED.toString(),
                type = Actions.TurnOff
            ),
            Action(
                color = Color.GREEN.toString(),
                type = Actions.User
            )
        )
    }

    private fun setupPresenter() {
        presenter = MainPresenter(actions, this)
    }

    private fun initializeViews() {
        recyclerViewActions.adapter = ActionsAdapter(presenter)
        recyclerViewActions.layoutManager = GridLayoutManager(this, 3)
    }

    override fun finishActivity() {
        finish()
    }
}