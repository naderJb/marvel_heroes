package com.nader.marvelheroes.core.extensions

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.nader.marvelheroes.R
import com.nader.marvelheroes.home.data.model.ThumbnailModel


@BindingAdapter("loadImage")
fun ShapeableImageView.loadImage(thumbnail: ThumbnailModel?) {
    Glide
        .with(context)
        .load(thumbnail?.getImage())
        .placeholder(R.drawable.bg_marvel_icon)
        .error(R.drawable.bg_marvel_icon)
        .fallback(R.drawable.bg_marvel_icon)
        .into(this)
}


@BindingAdapter(
    value = ["app:topLeft", "app:topRight", "app:bottomLeft", "app:bottomRight"],
    requireAll = false
)
fun ShapeableImageView.setCorners(
    topLeft: Int?,
    topRight: Int?,
    bottomLeft: Int?,
    bottomRight: Int?
) {
    with(context) {
        shapeAppearanceModel = shapeAppearanceModel.toBuilder().apply {
            topLeft?.let { setTopLeftCorner(CornerFamily.ROUNDED, getFloatFromDp(it)) }
            topRight?.let { setTopRightCorner(CornerFamily.ROUNDED, getFloatFromDp(it)) }
            bottomLeft?.let { setBottomLeftCorner(CornerFamily.ROUNDED, getFloatFromDp(it)) }
            bottomRight?.let { setBottomRightCorner(CornerFamily.ROUNDED, getFloatFromDp(it)) }
        }.build()
    }
}