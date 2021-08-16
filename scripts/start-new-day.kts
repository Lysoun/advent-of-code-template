import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate

@file:Include("git-utils.kts")

/**
 * Returns true if folder was created
 */
fun createFolder(day: Int): String? {
    val folderName = "day${day}"

    if(File(folderName).exists()) {
        return null
    }

    Files.createDirectory(Paths.get(folderName))
    return folderName
}

fun createPart1File(folderName: String) {
    val templatePath = Paths.get("scripts/templates/solution_template.ml")
    Files.copy(templatePath, Paths.get("${folderName}/part1.ml"))
}

val currentDateDay = LocalDate.now().dayOfMonth
createFolder(currentDateDay)?.let { createPart1File(it) }
commitDaySolutionsInit(currentDateDay)