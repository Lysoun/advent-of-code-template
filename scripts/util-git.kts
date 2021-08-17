#!/usr/bin/env kscript
@file:Include("util-shell.kts")

fun commitFiles(filesToCommit: List<String>, commitMessage: String) {
    runCommand(listOf("git", "add") + filesToCommit)
    runCommand(listOf("git", "commit", "-m", commitMessage))
}

fun commitDaySolutionsInit(dayNumber: Int) {
    val part1FilePath = "day${dayNumber}/part1.ml"
    commitFiles(listOf(part1FilePath), ":tada: Init day ${dayNumber} solutions")
}

fun commitInput(dayNumber: Int) {
    val inputFilePath = "day$dayNumber/input.txt"
    commitFiles(listOf(inputFilePath), ":tada: Retrieve input for day $dayNumber")
}