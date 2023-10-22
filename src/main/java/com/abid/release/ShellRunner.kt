package com.abid.release

class ShellRunner {
    fun runShell(command: String): String {
        val process = Runtime.getRuntime().exec(command)
        process.waitFor()
        return process.inputStream.bufferedReader().readText()
    }
}