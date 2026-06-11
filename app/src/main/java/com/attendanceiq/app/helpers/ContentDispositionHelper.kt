package com.attendanceiq.app.helpers

object ContentDispositionHelper {
    fun parseHeader(contentDisposition: String?): String {
        if (contentDisposition == null) return "download"
        val matcher = Regex("filename[*]?=[\"']?([^\"';\\s]+)", RegexOption.IGNORE_CASE)
        return matcher.find(contentDisposition)?.groupValues?.get(1) ?: "download"
    }
}
