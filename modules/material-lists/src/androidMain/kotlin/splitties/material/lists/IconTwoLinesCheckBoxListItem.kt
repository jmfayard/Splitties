/*
 * Copyright 2019 Louis Cognault Ayeva Derman. Use of this source code is governed by the Apache 2.0 license.
 */

package splitties.material.lists

import android.content.Context
import android.text.TextUtils.TruncateAt.END
import android.util.AttributeSet
import androidx.appcompat.R
import splitties.dimensions.dip
import splitties.resources.styledColorSL
import splitties.views.appcompat.imgTintList
import splitties.views.dsl.constraintlayout.bottomOfParent
import splitties.views.dsl.constraintlayout.centerVertically
import splitties.views.dsl.constraintlayout.endOfParent
import splitties.views.dsl.constraintlayout.endToStartOf
import splitties.views.dsl.constraintlayout.lParams
import splitties.views.dsl.constraintlayout.startOfParent
import splitties.views.dsl.constraintlayout.startToStartOf
import splitties.views.dsl.constraintlayout.topOfParent
import splitties.views.dsl.constraintlayout.topToBottomOf
import splitties.views.dsl.core.add
import splitties.views.dsl.core.checkBox
import splitties.views.dsl.core.endMargin
import splitties.views.dsl.core.imageView
import splitties.views.dsl.core.startMargin
import splitties.views.dsl.core.textView
import splitties.views.dsl.core.verticalMargin
import splitties.views.dsl.core.wrapContent
import splitties.views.selectable.constraintlayout.SelectableConstraintLayout
import splitties.views.textAppearance

class IconTwoLinesCheckBoxListItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    disableDefaultTint: Boolean = false
) : SelectableConstraintLayout(context, attrs, defStyleAttr) {

    val icon = imageView {
        if (!disableDefaultTint) imgTintList = styledColorSL(android.R.attr.textColorSecondary)
        isDuplicateParentStateEnabled = true
    }

    val firstLine = textView {
        ellipsize = END
        minLines = 1
        maxLines = 1
        textAppearance = R.style.TextAppearance_AppCompat_Subhead
        isDuplicateParentStateEnabled = true
    }

    val secondLine = textView {
        ellipsize = END
        minLines = 1
        maxLines = 1
        textAppearance = R.style.TextAppearance_AppCompat_Small
        isDuplicateParentStateEnabled = true
    }

    val checkBox = checkBox(R.id.checkbox) {
        isDuplicateParentStateEnabled = true
    }

    init {
        val iconSize = dip(24)
        add(icon, lParams(iconSize, iconSize) {
            verticalMargin = dip(8)
            startMargin = dip(16)
            startOfParent()
            centerVertically()
        })
        add(firstLine, lParams(height = wrapContent) {
            startMargin = dip(72)
            topMargin = dip(8)
            endMargin = dip(8)
            startOfParent()
            topOfParent()
            endToStartOf(checkBox)
        })
        add(secondLine, lParams(height = wrapContent) {
            endMargin = dip(8)
            bottomMargin = dip(8)
            startToStartOf(firstLine)
            topToBottomOf(firstLine)
            endToStartOf(checkBox)
            bottomOfParent()
        })
        add(checkBox, lParams(wrapContent, wrapContent) {
            endMargin = dip(16)
            endOfParent()
            centerVertically()
        })
    }
}
