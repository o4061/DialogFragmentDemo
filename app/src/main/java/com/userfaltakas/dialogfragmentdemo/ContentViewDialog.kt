package com.userfaltakas.dialogfragmentdemo

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources

class ContentViewDialog private constructor() {

    class Builder(private val context: Context) {
        private var mView: View? = null
        private var mTitle: CharSequence? = null
        private var mTitleTv: TextView? = null
        private var mMessage: CharSequence? = null
        private var mMessageTv: TextView? = null
        private var mIcon: Drawable? = null
        private var mIconIv: ImageView? = null
        private var mPositiveBtn: Button? = null
        private var mPositiveButtonText: CharSequence? = null
        private var mPositiveButtonListener: DialogInterface.OnClickListener? = null
        private var mNeutralBtn: Button? = null
        private var mNeutralButtonText: CharSequence? = null
        private var mNeutralButtonListener: DialogInterface.OnClickListener? = null
        private var mNegativeBtn: Button? = null
        private var mNegativeButtonText: CharSequence? = null
        private var mNegativeButtonListener: DialogInterface.OnClickListener? = null
        private var mOnCancelListener: DialogInterface.OnCancelListener? = null
        private var mOnDismissListener: DialogInterface.OnDismissListener? = null
        private var mCancelable: Boolean = false


        fun setView(view: View) = apply {
            mView = view
        }

        fun setIcon(imageView: ImageView) = apply {
            mIconIv = imageView
        }

        fun setIcon(imageView: ImageView, @DrawableRes icon: Int) = apply {
            mIcon = AppCompatResources.getDrawable(context, icon)
            mIconIv = imageView
        }

        fun setIcon(imageView: ImageView, icon: Drawable) = apply {
            mIcon = icon
            mIconIv = imageView
        }

        fun setTitle(textView: TextView) = apply {
            mTitleTv = textView
        }

        fun setTitle(textView: TextView, @StringRes title: Int) = apply {
            mTitle = context.getText(title)
            mTitleTv = textView
        }

        fun setTitle(textView: TextView, title: CharSequence) = apply {
            mTitle = title
            mTitleTv = textView
        }

        fun setMessage(textView: TextView) = apply {
            mMessageTv = textView
        }

        fun setMessage(textView: TextView, @StringRes message: Int) = apply {
            mMessage = context.getText(message)
            mMessageTv = textView
        }

        fun setMessage(textView: TextView, message: CharSequence) = apply {
            mMessage = message
            mMessageTv = textView
        }

        fun setPositiveButton(
            button: Button,
            listener: DialogInterface.OnClickListener
        ) =
            apply {
                mPositiveBtn = button
                mPositiveButtonListener = listener
            }

        fun setPositiveButton(
            button: Button,
            @StringRes text: Int,
            listener: DialogInterface.OnClickListener
        ) =
            apply {
                mPositiveBtn = button
                mPositiveButtonText = context.getText(text)
                mPositiveButtonListener = listener
            }


        fun setPositiveButton(
            button: Button,
            text: CharSequence,
            listener: DialogInterface.OnClickListener
        ) =
            apply {
                mPositiveBtn = button
                mPositiveButtonText = text
                mPositiveButtonListener = listener
            }

        fun setNeutralButton(
            button: Button,
            listener: DialogInterface.OnClickListener
        ) =
            apply {
                mNeutralBtn = button
                mNeutralButtonListener = listener
            }

        fun setNeutralButton(
            button: Button,
            @StringRes text: Int,
            listener: DialogInterface.OnClickListener
        ) =
            apply {
                mNeutralBtn = button
                mNeutralButtonText = context.getText(text)
                mNeutralButtonListener = listener
            }

        fun setNeutralButton(
            button: Button,
            text: CharSequence,
            listener: DialogInterface.OnClickListener
        ) =
            apply {
                mNeutralBtn = button
                mNeutralButtonText = text
                mNeutralButtonListener = listener
            }

        fun setNegativeButton(
            button: Button,
            listener: DialogInterface.OnClickListener
        ) =
            apply {
                mNegativeBtn = button
                mNegativeButtonListener = listener
            }

        fun setNegativeButton(
            button: Button,
            @StringRes text: Int,
            listener: DialogInterface.OnClickListener
        ) =
            apply {
                mNegativeBtn = button
                mNegativeButtonText = context.getText(text)
                mNegativeButtonListener = listener
            }

        fun setNegativeButton(
            button: Button,
            text: CharSequence,
            listener: DialogInterface.OnClickListener
        ) =
            apply {
                mNegativeBtn = button
                mNegativeButtonText = text
                mNegativeButtonListener = listener
            }

        fun setOnCancelListener(onCancelListener: DialogInterface.OnCancelListener) {
            mOnCancelListener = onCancelListener
        }

        fun setOnDismissListener(onDismissListener: DialogInterface.OnDismissListener) {
            mOnDismissListener = onDismissListener
        }

        fun setCancelable(cancelable: Boolean) = apply {
            mCancelable = cancelable
        }

        private fun create(): AlertDialog {
            val dialog: AlertDialog = AlertDialog.Builder(context)
                .setOnCancelListener(mOnCancelListener)
                .setOnDismissListener(mOnDismissListener)
                .setCancelable(mCancelable)
                .create()

            dialog.setView(mView)
            if (mTitle != null) mTitleTv?.text = mTitle
            if (mMessage != null) mMessageTv?.text = mMessage
            if (mIcon != null) mIconIv?.setImageDrawable(mIcon)

            mPositiveBtn?.apply {
                if (mPositiveButtonText != null) text = mPositiveButtonText
                setOnClickListener {
                    mPositiveButtonListener?.onClick(
                        dialog, AlertDialog.BUTTON_POSITIVE
                    )
                }
            }

            mNegativeBtn?.apply {
                if (mNegativeButtonText != null) text = mNegativeButtonText
                setOnClickListener {
                    mNegativeButtonListener?.onClick(
                        dialog, AlertDialog.BUTTON_NEGATIVE
                    )
                }
            }

            mNeutralBtn?.apply {
                text = mNeutralButtonText
                if (mNeutralButtonText != null) setOnClickListener {
                    mNeutralButtonListener?.onClick(
                        dialog, AlertDialog.BUTTON_NEUTRAL
                    )
                }
            }
            return dialog
        }

        fun show(): Dialog {
            val dialog: AlertDialog = create()
            dialog.show()
            return dialog
        }
    }
}