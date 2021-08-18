@file:Include("util-file.kts")
@file:Include("util-git.kts")

fun createPart1File(folderName: String): Boolean = createFileUsingTemplate(
    fileName = "${folderName}/part1.ml",
    templateFilePath = "scripts/templates/solution_template.ml"
)

fun createPart1File(folderName: String, day: Int) {
    val part1FileCreated = createPart1File(folderName)
    if (part1FileCreated) {
        println("Commit files for day $currentDateDay")
        commitDaySolutionsInit(currentDateDay)
    }
}