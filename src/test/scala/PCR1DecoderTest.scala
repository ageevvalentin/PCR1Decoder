import org.scalatest.FunSuite

class PCR1DecoderTest extends FunSuite {
  val decoder = new PCR1Decoder()

  test("PCR1Decoder.parse") {
    testCountParsing("0a0010ddffff200020", 16)
    testCountParsing("0a0000ddffff200020", 0)
  }

  def testCountParsing(payload: String, resultCount: Int): Unit = {
    assert(decoder.execute(payload).fields("count").toString().toInt == resultCount)
  }
}
