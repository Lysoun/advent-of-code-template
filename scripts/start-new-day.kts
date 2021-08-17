@file:Include("util-file.kts")
@file:Include("util-git.kts")
@file:Include("util-http.kts")
@file:Include("util-config.kts")

import java.time.LocalDate


fun createDayFolder(day: Int): String {
    val folderName = "day$day"
    createFolder(folderName)
    return folderName
}

fun createPart1File(folderName: String): Boolean = createFileUsingTemplate(
    fileName = "${folderName}/part1.ml",
    templateFilePath = "scripts/templates/solution_template.ml"
)

fun retrieveInput(folderName: String, day: Int, sessionId: String) {
    val url = "https://adventofcode.com/2020/day/$day/input"
    val input = get(url, sessionId)
    if (input == null) {
        println("Input was empty; no file was written")
    } else {
        println("Writing input for day $day into file")
        writeToFile(
            "$folderName/input.txt",
            input
        )
    }
}

val currentDateDay = LocalDate.now().dayOfMonth

val folderName = createDayFolder(currentDateDay)
val part1FileCreated = createPart1File(folderName)
if (part1FileCreated) {
    println("Commit files for day $currentDateDay")
    commitDaySolutionsInit(currentDateDay)
}
retrieveInput(folderName, currentDateDay, loadSessionId())
