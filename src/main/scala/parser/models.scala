package org.decaf.yeboo.parser
import java.awt.image.BufferedImage

case class FileDescription(line: String)
case class ImageDescription(lines: List[FileDescription])
