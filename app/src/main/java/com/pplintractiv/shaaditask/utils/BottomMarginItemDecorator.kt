package com.pplintractiv.shaaditask.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pplintractiv.shaaditask.extensions.dpToPx

/**
 * Created by Akhil B.V on 6/4/2020.
 * akhilbv@avantari.org
 */
class BottomMarginItemDecorator : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildViewHolder(view).adapterPosition
        if (position == 0) {
            outRect.set(10.dpToPx(), (10.dpToPx()), 10.dpToPx(), (10).dpToPx())
        } else {
            outRect.set(10.dpToPx(), 0, 10.dpToPx(), (10).dpToPx())
        }
    }
}