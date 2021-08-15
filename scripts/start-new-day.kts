import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate

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



val currentDateDay = LocalDate.now().dayOfMonth
createFolder(currentDateDay)