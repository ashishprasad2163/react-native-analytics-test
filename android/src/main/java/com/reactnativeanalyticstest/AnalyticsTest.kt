package com.reactnativeanalyticstest

import com.reactnativeanalyticstest.Analytics
import com.reactnativeanalyticstest.integrations.integration

object AnalyticsTest {

    private val integrations = mutableSetOf<Integration.Factory>()
    private val onReadyCallbacks = mutableMapOf<String, Analytics.Callback<Any?>>()

    fun setIDFA(idfa: String) {
        // do nothing; iOS only.
    }
    
    fun addIntegration(integration: Integration.Factory) {
        integrations.add(integration)
    }

    fun buildWithIntegrations(builder: Analytics.Builder): Analytics {
        for(integration in AnalyticsTest.integrations) {
            builder.use(integration)
        }

        return builder.build()
    }

    fun addOnReadyCallback(key: String, callback: Analytics.Callback<Any?>) {
        onReadyCallbacks[key] = callback
    }

    fun setupCallbacks(analytics: Analytics) {
        for(integration in AnalyticsTest.onReadyCallbacks.keys) {
            analytics.onIntegrationReady(integration, AnalyticsTest.onReadyCallbacks[integration])
        }
    }}

