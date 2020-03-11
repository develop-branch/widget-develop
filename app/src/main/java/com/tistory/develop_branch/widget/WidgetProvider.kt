package com.tistory.develop_branch.widget

import android.appwidget.AppWidgetManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class WidgetProvider : BroadcastReceiver() {

	override fun onReceive(context: Context?, intent: Intent?) {
		if (intent == null) {
			return
		}

		val widgetManager = AppWidgetManager.getInstance(context)
		when (intent.action) {
			AppWidgetManager.ACTION_APPWIDGET_UPDATE -> {
				val remoteViews = RemoteViews(
					"com.tistory.develop_branch.widget",
					R.layout.widget_layout
				)
				intent.extras?.let {
					val appWidgetIds: IntArray? =
						intent.extras!!.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS)
					appWidgetIds?.forEach {
						widgetManager.updateAppWidget(it, remoteViews)
					}
				}
			}
		}
	}
}