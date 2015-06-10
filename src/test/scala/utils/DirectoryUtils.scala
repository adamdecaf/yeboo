package yeboo.utils
import java.io.File

trait DirectoryUtils {
  def iterateAndStreamFiles(dir: String): Iterator[File] = {
    val directory = new File(dir)
    directory.listFiles().iterator
  }
}
