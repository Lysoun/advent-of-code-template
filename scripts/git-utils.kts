#!/usr/bin/env kscript
@file:Include("shell-utils.kts")

fun commitFiles(filesToCommit: List<String>, commitMessage: String) {
    runCommand(listOf("git", "add") + filesToCommit)
    runCommand(listOf("git", "commit", "-m", commitMessage))
}

fun commitDaySolutionsInit(dayNumber: Int) {
    val part1FilePath = "day${dayNumber}/part1.ml"
    commitFiles(listOf(part1FilePath), ":tada: Init day ${dayNumber} solutions")
}

