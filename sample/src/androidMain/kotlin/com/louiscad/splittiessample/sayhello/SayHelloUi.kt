/*
 * Copyright 2019 Louis Cognault Ayeva Derman. Use of this source code is governed by the Apache 2.0 license.
 */
package com.louiscad.splittiessample.sayhello

import android.content.Context
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.louiscad.splittiessample.R
import com.louiscad.splittiessample.extensions.ui.addDefaultAppBar
import splitties.dimensions.dip
import splitties.experimental.ExperimentalSplittiesApi
import splitties.snackbar.snack
import splitties.views.InputType
import splitties.views.dsl.coordinatorlayout.coordinatorLayout
import splitties.views.dsl.core.*
import splitties.views.dsl.material.MaterialComponentsStyles
import splitties.views.dsl.material.addInput
import splitties.views.dsl.material.contentScrollingWithAppBarLParams
import splitties.views.gravityEnd
import splitties.views.material.text
import splitties.views.onClick
import splitties.views.type

@UseExperimental(ExperimentalSplittiesApi::class)
class SayHelloUi(override val ctx: Context) : Ui {
    private val materialStyles = MaterialComponentsStyles(ctx)
    private val firstNameInput = materialStyles.textInputLayout.outlinedBox {
        addInput(R.id.input_name) {
            hint = "First name"
            type = InputType.personName
        }
    }
    private val lastNameInput = materialStyles.textInputLayout.outlinedBox {
        addInput(R.id.input_name) {
            hint = "Last name"
            type = InputType.personName
        }
    }
    private val sayHelloBtn = materialStyles.button.filled { text = "Say hello!" }
    override val root: CoordinatorLayout = coordinatorLayout {
        fitsSystemWindows = true
        addDefaultAppBar(ctx)
        add(verticalLayout {
            add(firstNameInput, lParams(width = matchParent))
            add(lastNameInput, lParams(width = matchParent))
            add(sayHelloBtn, lParams(gravity = gravityEnd) {
                topMargin = dip(8)
            })
        }, contentScrollingWithAppBarLParams {
            margin = dip(16)
        })
    }

    init {
        sayHelloBtn.onClick {
            val fullName = "${firstNameInput.text} ${lastNameInput.text}"
            root.snack("Hello $fullName!")
        }
    }
}
