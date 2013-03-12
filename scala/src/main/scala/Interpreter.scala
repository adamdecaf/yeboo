package yeboo
import yeboo.parser.FileParser
import yeboo.images.ImageGeneration

class Interpreter() {

  def generate(rawFile: String) = {
    lazy val data = FileParser.parseFileByRawString(rawFile)
    ImageGeneration.createImageFromFileDescription(data)
  }

}
