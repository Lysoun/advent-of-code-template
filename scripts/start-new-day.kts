@file:Include("util-file.kts")
@file:Include("util-git.kts")
@file:Include("input.kts")
@file:Include("folder.kts")

import java.time.LocalDate

fun createPart1File(folderName: String): Boolean = createFileUsingTemplate(
    fileName = "${folderName}/part1.ml",
    templateFilePath = "scripts/templates/solution_template.ml"
)

val currentDateDay = LocalDate.now().dayOfMonth

val folderName = createDayFolder(currentDateDay)
val part1FileCreated = createPart1File(folderName)
if (part1FileCreated) {
    println("Commit files for day $currentDateDay")
    commitDaySolutionsInit(currentDateDay)
}

loadInput(currentDateDay, folderName)